package org.toj.mother.game.objects.creatures.player;

import org.toj.mother.game.Game;
import org.toj.mother.game.levels.Location;

public abstract class Creature {
    private Location location;
    private Game game;

    public Creature(Game game) {
        this.game = game;
    }

    public Creature(Location l, Game game) {
        this.location = l;
        this.game = game;
    }

    public void move(int x, int y) {
        Location newLoc = location.move(x, y);
        if (!game.getLevel().getTerrainAt(newLoc).impassible()) {
            location = newLoc;
        }
    }

    public Location getLocation() {
        return location;
    }

	public void setLocation(Location location) {
		this.location = location;
	}
}
