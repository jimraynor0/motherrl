package org.toj.mother.game.levels;

import java.util.LinkedList;
import java.util.List;

import org.toj.mother.game.objects.creatures.monsters.Monster;
import org.toj.mother.game.objects.terrain.Tile;

public class Level {
    private LevelMap map;
    private List<Monster> monsters = new LinkedList<Monster>();

    public Level(LevelMap map) {
        this.map = map;
    }

    public Tile getTerrainAt(int x, int y) {
        return map.getTerrain(new Coordinates(x, y));
    }

    public Tile getTerrainAt(Coordinates c) {
        return map.getTerrain(c);
    }

    public void setTerrain(int x, int y, Tile tile) {
        map.setTerrain(new Coordinates(x, y), tile);
    }

    public Coordinates getRandomEmptySpace() {
        Coordinates randomEmptySpace = map.getRandomEmptySpace();
        while (getMonsterAt(randomEmptySpace) != null) {
            randomEmptySpace = map.getRandomEmptySpace();
        }
        return randomEmptySpace;
    }

    private Monster getMonsterAt(Coordinates c) {
        for (Monster monster : monsters) {
            if (monster.getCoordinates().equals(c)) {
                return monster;
            }
        }
        return null;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public int getWidth() {
        return map.getWidth();
    }

    public int getHeight() {
        return map.getHeight();
    }
}
