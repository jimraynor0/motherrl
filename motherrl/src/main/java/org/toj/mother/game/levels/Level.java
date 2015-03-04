package org.toj.mother.game.levels;

import org.toj.mother.game.objects.terrain.Tile;

public class Level {
    private LevelMap map;

    public Level(LevelMap map) {
        this.map = map;
    }

    public Tile getTerrainAt(int x, int y) {
        return map.getTerrain(new Location(x, y));
    }

    public int getWidth() {
        return map.getWidth();
    }

    public int getHeight() {
        return map.getHeight();
    }
}
