package org.toj.mother.game;

import org.toj.mother.game.levels.Level;
import org.toj.mother.game.levels.Coordinates;
import org.toj.mother.game.levels.builder.LevelBuilder;
import org.toj.mother.game.objects.creatures.player.Player;
import org.toj.mother.game.objects.terrain.Tile;

public class Game {
	private static final int LEVEL_WIDTH = 120;
	private static final int LEVEL_HEIGHT = 80;

	private int depth;
	private Level level;
	private Player player;

	public Game() {
		enterLevel(1);
	}

	private void placePlayer() {
		Coordinates startingPoint = level.getRandomEmptySpace();
		if (player == null) {
			player = new Player(startingPoint, this);
		} else {
			player.setCoordinates(startingPoint);
		}
	}

	private void enterLevel(int depth) {
		this.depth = depth;
		buildLevel();
		placePlayer();
	}

	private void buildLevel() {
		LevelBuilder lb = new LevelBuilder(LEVEL_WIDTH, LEVEL_HEIGHT, depth, this);
		level = lb.buildLevel();
	}

	public void movePlayer(int x, int y) {
		player.move(x, y);
	}

	public void descendPlayer() {
		if (Tile.EXIT.equals(level.getTerrainAt(player.getCoordinates()))) {
			enterLevel(getDepth() + 1);
		}
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
