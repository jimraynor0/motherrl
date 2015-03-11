package org.toj.mother.ui.terminal.glyphs;

import org.toj.mother.game.objects.creatures.monsters.Monster;
import org.toj.mother.ui.terminal.tiles.AsciiTile;

public class GlyphFactory {

    public static AsciiTile glyph(Monster m) {
        if ("fungus".equals(m.getName())) {
            return AsciiTile.FUNGUS;
        }
        throw new RuntimeException("glyph for monster " + m.getName() + " not found.");
    }
}
