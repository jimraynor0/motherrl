package org.toj.mother.game.objects.creatures.player;

import org.toj.mother.game.Game;

public abstract class Creature {
    private int posX;
    private int posY;
    private Game game;

    public Creature(int posX, int posY, Game game) {
        this.posX = posX;
        this.posY = posY;
        this.game = game;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void move(int x, int y) {
        int newX = posX + x;
        int newY = posY + y;
        if (!game.getLevel().getTerrainAt(newX, newY).impassible()) {
            posX = newX;
            posY = newY;
        }
    }
}
