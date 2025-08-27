package designpattern.c_templatemethod;

import java.util.Random;

public class Player extends Character{

    Random random = new Random();

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calDefenseWeight(int damage) {
        return damage - (damage * def/100) ;
    }

    @Override
    protected int calAttackWeight() {
        return random.nextInt(atk/2, atk*3);
    }
}
