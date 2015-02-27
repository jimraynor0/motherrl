package org.toj.mother.game;

import org.toj.mother.game.levels.Level;
import org.toj.mother.game.levels.LevelBuilder;
import org.toj.mother.game.objects.creatures.player.Player;

public class Game {
    private static final int LEVEL_WIDTH = 90;
    private static final int LEVEL_HEIGHT = 31;

    private int depth;
    private Level level;
    private Player player;

    public Game() {
        enterLevel(1);
        spawnPlayer();
    }

    private void spawnPlayer() {
        int x = (int) (Math.random() * LEVEL_WIDTH);
        int y = (int) (Math.random() * LEVEL_HEIGHT);
        while (level.getTerrainAt(x, y).impassible()) {
            x = (int) (Math.random() * LEVEL_WIDTH);
            y = (int) (Math.random() * LEVEL_HEIGHT);
        }
        player = new Player(x, y, this);
    }

    private void enterLevel(int depth) {
        this.depth = depth;
        buildLevel();
    }

    private void buildLevel() {
        level = new LevelBuilder(LEVEL_WIDTH, LEVEL_HEIGHT).makeCaves()
                .buildLevel();
    }

    public void movePlayer(int x, int y) {
        player.move(x, y);
    }

    public int getDepth() {
        return depth;
    }

    public Level getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }
}
