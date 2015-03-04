package org.toj.mother.ui.terminal.screens;

import java.awt.event.KeyEvent;

import org.toj.mother.game.Game;
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
        System.out.println("player position: "
                + game.getPlayer().getLocation().x + " , "
                + game.getPlayer().getLocation().y);
        System.out.println("scroll position: " + left + " , " + top);
        displayTiles(terminal, left, top);

        terminal.writeCenter("-- press [escape] to lose or [enter] to win --",
                22);
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
        terminal.write(AsciiTile.PLAYER.glyph(),
                game.getPlayer().getLocation().x - left, game.getPlayer()
                        .getLocation().y - top, AsciiTile.PLAYER.color());
    }

    public int getScrollX() {
        return Math.max(0, Math.min(game.getPlayer().getLocation().x
                - screenWidth / 2, game.getLevel().getWidth() - screenWidth));
    }

    public int getScrollY() {
        return Math
                .max(0,
                        Math.min(game.getPlayer().getLocation().y
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

        return this;
    }

    private void movePlayer(int x, int y) {
        game.movePlayer(x, y);
    }
}
