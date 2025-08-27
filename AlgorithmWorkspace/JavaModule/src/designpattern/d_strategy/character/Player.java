package designpattern.d_strategy.character;

import designpattern.d_strategy.Item.Equipment;
import designpattern.d_strategy.Item.Equipments;
import designpattern.d_strategy.Item.Slot;
import designpattern.d_strategy.Item.code.EquipmentData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class Player extends Character{

    private Random random = new Random();
    private Equipments equipments = new Equipments();

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    public void attack(Character target) {
        int damage = random.nextInt(atk, atk * 3);

        System.out.println("[" + name + "] 공격!");
        for(Equipment e : equipments.findAll()) {
            damage = e.calAttackWeight(damage);
        }

        Optional<Equipment> optional = equipments.findBySlot(Slot.WEAPON);

        if(optional.isPresent()) {
            System.out.println(optional.get().getEffect());
        }
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        // 피해량 연산
        for(Equipment e : equipments.findAll()) {
            damage = e.calDefenceWeight(damage);
        }
        System.out.println("[ Damage ] :" + damage);

        this.currentHp -= damage;
        this.currentHp = Math.max(currentHp, 0);
    }

    public void equip(Equipment equipment) {
        equipments.equip(equipment);
    }



}
