package cn.downey.interview.NetEase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Warrior {
    int hurt;
    int defense;

    Warrior(int defense) {
        this.defense = defense;
        hurt = 0;
    }
}

class Monster {
    Integer defense;
    Integer hurt;

    Monster(int defense, int hurt) {
        this.defense = defense;
        this.hurt = hurt;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        int count = Integer.parseInt(line1[0]);
        Warrior warrior = new Warrior(Integer.parseInt(line1[1]));
        Monster[] monsters = new Monster[count];
        String[] line2 = scanner.nextLine().split(" ");
        String[] line3 = scanner.nextLine().split(" ");
        for (int i = 0; i < count; i++) {
            monsters[i] = new Monster(Integer.parseInt(line2[i]), Integer.parseInt(line3[i]));
        }
        System.out.println(func(monsters, warrior));
    }

    private static int func(Monster[] monsters, Warrior warrior) {
        Arrays.sort(monsters, Comparator.comparing(o -> o.defense));
        int i = 0;
        while (i < monsters.length) {
            if (monsters[i].defense >= warrior.defense) {
                warrior.hurt += monsters[monsters.length - 1].hurt;
                warrior.defense += 1;
                monsters = Arrays.copyOf(monsters, monsters.length - 1);
            } else {
                warrior.defense += 1;
                i++;
            }

        }
        return warrior.hurt;
    }

}
