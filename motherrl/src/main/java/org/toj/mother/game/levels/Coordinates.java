package org.toj.mother.game.levels;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Coordinates> getNeighbours4() {
        List<Coordinates> results = new ArrayList<Coordinates>(4);
        results.add(new Coordinates(x - 1, y));
        results.add(new Coordinates(x + 1, y));
        results.add(new Coordinates(x, y - 1));
        results.add(new Coordinates(x, y + 1));
        return results;
    }

    public Coordinates move(int mx, int my) {
        return new Coordinates(x + mx, y + my);
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
