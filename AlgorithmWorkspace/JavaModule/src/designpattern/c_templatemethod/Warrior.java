package designpattern.c_templatemethod;

import java.util.Random;

public class Warrior extends Character{

    private Random random = new Random();

    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calDefenseWeight(int damage) {
        def = 30;
        System.out.println("[Warrior 특성 발동] 방어술");
        return damage - (damage * def/100);
    }

    @Override
    protected int calAttackWeight(){
        return random.nextInt(atk, atk*4);
    }
}
