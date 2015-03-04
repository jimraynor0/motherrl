package org.toj.mother.game.levels.builder;

import org.toj.mother.game.levels.Level;
import org.toj.mother.game.levels.LevelMap;

public class LevelBuilder {
    private int width;
    private int height;
    private int depth;
    private LevelMap map;

    public LevelBuilder(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Level buildLevel() {
        map = new CellularAutomatonCaveBuilder().generateMap(width, height,
                depth);
        return new Level(map);
    }
}
