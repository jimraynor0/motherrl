package org.toj.mother.game.levels.builder;

import org.toj.mother.game.Game;
import org.toj.mother.game.levels.Level;
import org.toj.mother.game.levels.LevelMap;
import org.toj.mother.game.objects.creatures.monsters.Monster;
import org.toj.mother.game.objects.creatures.monsters.StationaryAi;
import org.toj.mother.game.objects.terrain.Tile;

public class LevelBuilder {
    private Game game;
    private int width;
    private int height;
    private int depth;
    private Level level;
    private LevelMap map;

    public LevelBuilder(int width, int height, int depth, Game game) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.game = game;
    }

    public Level buildLevel() {
        map = new CellularAutomatonCaveBuilder().generateMap(width, height,
                depth);
        map.setTerrain(map.getRandomEmptySpace(), Tile.EXIT);
        level = new Level(map);
        generateMonsters();
        return level;
    }

    private void generateMonsters() {
        int amount = 20;
        // somehow get monster profile from config
        for (int i = 0; i < amount; i++) {
            level.addMonster(new Monster("fungus", new StationaryAi(), level
                    .getRandomEmptySpace(), game));
        }
    }
}
