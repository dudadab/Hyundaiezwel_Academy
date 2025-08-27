package designpattern.d_strategy;

import java.util.Random;
import java.util.Scanner;

import designpattern.d_strategy.Item.Equipment;
import designpattern.d_strategy.Item.Slot;
import designpattern.d_strategy.Item.code.EquipmentData;
import designpattern.d_strategy.character.Monster;
import designpattern.d_strategy.character.Player;

public class Run {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Player player = new Player("모험가", 200, 30, 10);
        Monster monster = new Monster("슬라임", 200, 30, 10);

        System.out.println("[전투이벤트] " + monster.getName() + " 등장!");
        boolean eventFlg = true;
        while(true) {

            if(player.isDead()) {
                System.out.println("\n======================================");
                System.out.println("[결과] LOSE");
                break;
            }

            if(monster.isDead()) {
                System.out.println("\n======================================");
                System.out.println("[결과] WIN");
                break;
            }

            System.out.println("\n======================================");
            sc.nextLine();

            if(player.getCurrentHp() < 150) {

                System.out.println(EquipmentData.valueOf("BASIC_WEAPON"));
                EquipmentData[] datas = EquipmentData.values();
                int index = random.nextInt(0, datas.length);

                if(eventFlg) {
                    player.equip(datas[index].create());
                    eventFlg = false;
                }
            }

            player.attack(monster);
            monster.attack(player);
            System.out.println("------------------------------------");
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
        }
    }

}
