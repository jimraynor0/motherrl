package org.toj.mother.game.objects.creatures;

import org.toj.mother.game.Game;
import org.toj.mother.game.levels.Coordinates;

public abstract class Creature {
    private Coordinates coordinates;
    private Game game;

    public Creature(Game game) {
        this.game = game;
    }

    public Creature(Coordinates c, Game game) {
        this.coordinates = c;
        this.game = game;
    }

    public void move(int x, int y) {
        Coordinates newLoc = coordinates.move(x, y);
        if (!game.getLevel().getTerrainAt(newLoc).impassible()) {
            coordinates = newLoc;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
