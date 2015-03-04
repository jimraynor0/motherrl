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

    public Tile getTerrainAt(Location location) {
        return map.getTerrain(location);
    }

    public void setTerrain(int x, int y, Tile tile) {
        map.setTerrain(new Location(x, y), tile);
    }

    public Location getRandomEmptySpace() {
        return map.getRandomEmptySpace();
    }

    public int getWidth() {
        return map.getWidth();
    }

    public int getHeight() {
        return map.getHeight();
    }
}
