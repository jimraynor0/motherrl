package org.toj.mother.game.levels.builder;

import org.toj.mother.game.levels.LevelMap;

public interface MapBuilder {
    LevelMap generateMap(int width, int height, int depth);
}
