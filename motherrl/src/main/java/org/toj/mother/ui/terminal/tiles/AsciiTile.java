package org.toj.mother.ui.terminal.tiles;

import java.awt.Color;

import org.toj.mother.game.objects.terrain.Tile;

import external.trystan.asciiPanel.AsciiPanel;

public enum AsciiTile {
    FLOOR('.', AsciiPanel.yellow), WALL('#', AsciiPanel.yellow), BOUNDS('x',
            AsciiPanel.brightBlack), PLAYER('@', AsciiPanel.brightWhite), EXIT(
            '<', AsciiPanel.brightMagenta), FUNGUS('f', AsciiPanel.green);

    private char glyph;

    public char glyph() {
        return glyph;
    }

    private Color color;

    public Color color() {
        return color;
    }

    AsciiTile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    public static AsciiTile get(Tile tile) {
        return AsciiTile.valueOf(tile.toString());
    }
}
