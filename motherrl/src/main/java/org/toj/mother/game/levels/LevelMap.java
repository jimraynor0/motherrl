package org.toj.mother.game.levels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.toj.mother.game.objects.terrain.Tile;

public class LevelMap implements Iterable<Location> {
    private int width;
    private int height;
    private Tile[][] tiles;

    public LevelMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public Tile getTerrain(Location location) {
        if (outOfBounds(location)) {
            return Tile.BOUNDS;
        }
        return tiles[location.x][location.y];
    }

    public void setTerrain(Location location, Tile tile) {
        if (!outOfBounds(location)) {
            tiles[location.x][location.y] = tile;
        }
    }

    public boolean outOfBounds(Location location) {
        return location.x < 0 || location.y < 0 || location.x >= width || location.y >= height;
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

    public Iterator<Location> iterator() {
        List<Location> allLocation = new ArrayList<Location>(width * height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                allLocation.add(new Location(x, y));
            }
        }
        return allLocation.iterator();
    }
}
