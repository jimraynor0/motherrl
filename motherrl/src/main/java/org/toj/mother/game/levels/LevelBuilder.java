package org.toj.mother.game.levels;

import org.toj.mother.game.objects.terrain.Tile;

public class LevelBuilder {
    private int width;
    private int height;
    private Tile[][] tiles;

    public LevelBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public Level buildLevel() {
        return new Level(tiles);
    }

    public LevelBuilder makeCaves() {
        return randomizeTiles().smooth(4);
    }

    private LevelBuilder randomizeTiles() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.55 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    private LevelBuilder smooth(int times) {
        Tile[][] nextIterate = new Tile[width][height];
        for (int time = 0; time < times; time++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int wallsInOneStep = wallCountWithinSteps(x, y, 1);

                    nextIterate[x][y] = wallsInOneStep >= 5 ? Tile.WALL
                            : Tile.FLOOR;
                }
            }
            tiles = nextIterate;
        }

        return this;
    }

    private int wallCountWithinSteps(int x, int y, int steps) {
        int tileCount = 0;
        for (int ox = 0 - steps; ox < 1 + steps; ox++) {
            for (int oy = 0 - steps; oy < 1 + steps; oy++) {
                if (x + ox < 0 || x + ox >= width || y + oy < 0
                        || y + oy >= height) {
                    tileCount++;
                } else if (tiles[x + ox][y + oy] == Tile.WALL) {
                    tileCount++;
                }
            }
        }
        return tileCount;
    }
}
