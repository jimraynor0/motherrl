package org.toj.mother.game.objects.terrain;

public enum Tile {
    FLOOR(false), WALL(true), BOUNDS(true), EXIT(false);

    private boolean impassible;

    Tile(boolean impassible) {
        this.impassible = impassible;
    }

    public boolean impassible() {
        return impassible;
    }
}
