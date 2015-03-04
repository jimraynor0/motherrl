package org.toj.mother.game;

import org.toj.mother.game.levels.Level;
import org.toj.mother.game.levels.Location;
import org.toj.mother.game.levels.builder.LevelBuilder;
import org.toj.mother.game.objects.creatures.player.Player;

public class Game {
    private static final int LEVEL_WIDTH = 120;
    private static final int LEVEL_HEIGHT = 80;

    private int depth;
    private Level level;
    private Player player;

    public Game() {
        enterLevel(1);
        spawnPlayer();
    }

    private void spawnPlayer() {
        Location spawnPoint = level.getRandomEmptySpace();
        player = new Player(spawnPoint, this);
    }

    private void enterLevel(int depth) {
        this.depth = depth;
        buildLevel();
    }

    private void buildLevel() {
        LevelBuilder lb = new LevelBuilder(LEVEL_WIDTH, LEVEL_HEIGHT, depth);
        level = lb.buildLevel();
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
