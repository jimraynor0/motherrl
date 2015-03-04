package org.toj.mother.game.levels.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.toj.mother.game.levels.LevelMap;
import org.toj.mother.game.levels.Location;
import org.toj.mother.game.objects.terrain.Tile;

class CellularAutomatonCaveBuilder implements MapBuilder {
    private int depth;
    private LevelMap map;

    public LevelMap generateMap(int width, int height, int depth) {
        this.depth = depth;
        this.map = new LevelMap(width, height);

        makeCaves();
        fillIsolatedCaves();

        return map;
    }

    private void fillIsolatedCaves() {
        List<Set<Location>> caves = new ArrayList<Set<Location>>();
        for (Location lc : map) {
            Tile tile = map.getTerrain(lc);
            if (!tile.impassible()) {
                boolean newCave = true;
                for (Set<Location> cave : caves) {
                    if (cave.contains(lc)) {
                        newCave = false;
                        break;
                    }
                }
                if (newCave) {
                    caves.add(floodCave(lc));
                }
            }
        }

        if (caves.size() > 1) {
            Collections.sort(caves, new Comparator<Set<Location>>() {
                public int compare(Set<Location> o1, Set<Location> o2) {
                    return o2.size() - o1.size();
                }
            });
            caves.remove(0);
            for (Set<Location> cave : caves) {
                for (Location location : cave) {
                    map.setTerrain(location, Tile.WALL);
                }
            }
        }
    }

    private Set<Location> floodCave(Location l) {
        HashSet<Location> cave = new HashSet<Location>();
        includeLocation(l, cave);
        return cave;
    }

    private void includeLocation(Location l, HashSet<Location> cave) {
        if (map.getTerrain(l).impassible()) {
            return;
        }

        if (cave.contains(l)) {
            return;
        }

        cave.add(l);
        for (Location neighbour : l.getNeighbours4()) {
            includeLocation(neighbour, cave);
        }
    }

    public void makeCaves() {
        randomizeTiles();
        smooth(4);
    }

    private void randomizeTiles() {
        for (Location l : map) {
            map.setTerrain(l, Math.random() < 0.55 ? Tile.FLOOR : Tile.WALL);
        }
    }

    private void smooth(int times) {
        LevelMap nextIterate = new LevelMap(map.getWidth(), map.getHeight());
        for (int time = 0; time < times; time++) {
            for (int x = 0; x < map.getWidth(); x++) {
                for (int y = 0; y < map.getHeight(); y++) {
                    int wallsInOneStep = wallCountWithinSteps(x, y, 1);

                    nextIterate.setTerrain(new Location(x, y),
                            wallsInOneStep >= 5 ? Tile.WALL : Tile.FLOOR);
                }
            }
            map = nextIterate;
        }
    }

    private int wallCountWithinSteps(int x, int y, int steps) {
        int tileCount = 0;
        for (int ox = 0 - steps; ox < 1 + steps; ox++) {
            for (int oy = 0 - steps; oy < 1 + steps; oy++) {
                if (map.outOfBounds(new Location(x + ox, y + oy))) {
                    tileCount++;
                } else if (map.getTerrain(new Location(x + ox, y + oy)) == Tile.WALL) {
                    tileCount++;
                }
            }
        }
        return tileCount;
    }
}
