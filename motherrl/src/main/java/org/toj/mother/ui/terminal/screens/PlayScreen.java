package org.toj.mother.ui.terminal.screens;

import java.awt.event.KeyEvent;

import org.toj.mother.game.Game;
import org.toj.mother.game.objects.creatures.monsters.Monster;
import org.toj.mother.ui.terminal.glyphs.GlyphFactory;
import org.toj.mother.ui.terminal.tiles.AsciiTile;

import external.trystan.asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {

    private int screenWidth = 80;
    private int screenHeight = 40;
    private Game game;

    public PlayScreen(Game game) {
        this.game = game;
    }

    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();
        displayTiles(terminal, left, top);

        terminal.write("press [enter] to win", 82, 37);
        terminal.write("press [escape] to lose", 82, 38);
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                AsciiTile tile = AsciiTile.get(game.getLevel().getTerrainAt(wx,
                        wy));
                terminal.write(tile.glyph(), x, y, tile.color());
            }
        }
        for (Monster m : game.getLevel().getMonsters()) {
            terminal.write(GlyphFactory.glyph(m).glyph(), m
                    .getCoordinates().x - left, m.getCoordinates().y
                    - top, GlyphFactory.glyph(m).color());
        }
        terminal.write(AsciiTile.PLAYER.glyph(), game.getPlayer()
                .getCoordinates().x - left, game.getPlayer().getCoordinates().y
                - top, AsciiTile.PLAYER.color());
    }

    public int getScrollX() {
        return Math.max(0, Math.min(game.getPlayer().getCoordinates().x
                - screenWidth / 2, game.getLevel().getWidth() - screenWidth));
    }

    public int getScrollY() {
        return Math
                .max(0,
                        Math.min(game.getPlayer().getCoordinates().y
                                - screenHeight / 2, game.getLevel().getHeight()
                                - screenHeight));
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            movePlayer(-1, 0);
            break;
        case KeyEvent.VK_RIGHT:
            movePlayer(1, 0);
            break;
        case KeyEvent.VK_UP:
            movePlayer(0, -1);
            break;
        case KeyEvent.VK_DOWN:
            movePlayer(0, 1);
            break;
        case KeyEvent.VK_ESCAPE:
            return new LoseScreen();
        case KeyEvent.VK_ENTER:
            return new WinScreen();
        }
        switch (key.getKeyChar()) {
        case '<':
            game.descendPlayer();
        }

        return this;
    }

    private void movePlayer(int x, int y) {
        game.movePlayer(x, y);
    }
}
