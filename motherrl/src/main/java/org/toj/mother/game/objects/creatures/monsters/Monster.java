package org.toj.mother.game.objects.creatures.monsters;

import org.toj.mother.game.Game;
import org.toj.mother.game.levels.Coordinates;
import org.toj.mother.game.objects.creatures.Creature;

public class Monster extends Creature {

    private String name;
    private MonsterAi ai;

    public Monster(String name, MonsterAi ai, Coordinates c, Game game) {
        super(c, game);
        this.name = name;
        this.ai = ai;
    }

    public String getName() {
        return name;
    }
}
