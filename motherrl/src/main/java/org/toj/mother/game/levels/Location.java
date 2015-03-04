package org.toj.mother.game.levels;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
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
        Location other = (Location) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public List<Location> getNeighbours4() {
        List<Location> results = new ArrayList<Location>(4);
        results.add(new Location(x - 1, y));
        results.add(new Location(x + 1, y));
        results.add(new Location(x, y - 1));
        results.add(new Location(x, y + 1));
        return results;
    }
}
