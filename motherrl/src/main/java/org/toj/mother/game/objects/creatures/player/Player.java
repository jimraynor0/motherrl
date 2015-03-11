package org.toj.mother.game.objects.creatures.player;

import org.toj.mother.game.Game;
import org.toj.mother.game.levels.Coordinates;
import org.toj.mother.game.objects.creatures.Creature;

public class Player extends Creature {

    public Player(Game game) {
        super(game);
    }

    public Player(Coordinates c, Game game) {
        super(c, game);
    }
}
