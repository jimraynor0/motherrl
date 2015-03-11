package org.toj.mother.game.levels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.toj.mother.game.objects.terrain.Tile;

public class LevelMap implements Iterable<Coordinates> {
    private int width;
    private int height;
    private Tile[][] tiles;

    public LevelMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public Tile getTerrain(Coordinates c) {
        if (outOfBounds(c)) {
            return Tile.BOUNDS;
        }
        return tiles[c.x][c.y];
    }

    public void setTerrain(Coordinates c, Tile tile) {
        if (!outOfBounds(c)) {
            tiles[c.x][c.y] = tile;
        }
    }

    public boolean outOfBounds(Coordinates c) {
        return c.x < 0 || c.y < 0 || c.x >= width || c.y >= height;
    }

    public Coordinates getRandomEmptySpace() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        while (tiles[x][y].impassible()) {
            x = (int) (Math.random() * width);
            y = (int) (Math.random() * height);
        }
        return new Coordinates(x, y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Iterator<Coordinates> iterator() {
        List<Coordinates> allCoordinates = new ArrayList<Coordinates>(width * height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                allCoordinates.add(new Coordinates(x, y));
            }
        }
        return allCoordinates.iterator();
    }
}
