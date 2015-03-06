package org.toj.mother.game.objects.creatures.player;

import org.toj.mother.game.Game;
import org.toj.mother.game.levels.Location;

public class Player extends Creature {

    public Player(Game game) {
        super(game);
    }

    public Player(Location location, Game game) {
        super(location, game);
    }
}
