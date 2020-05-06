package cn.downey.interview.WeBank;

import java.util.Arrays;
import java.util.Scanner;

class Card {
    Integer money;
    Integer times;

    public Card(int money, int times) {
        this.money = money;
        this.times = times;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            cards[i] = new Card(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        System.out.println(calculate(cards, n));

    }

    private static int calculate(Card[] cards, int n) {
        Arrays.sort(cards, (o1, o2) -> o1.times.equals(o2.times) ? o1.money.compareTo(o2.money) : o1.times.compareTo(o2.times));
        int chance = 1;
        int ans = 0;
        while (chance != 0 && n != 0) {
            chance = chance - 1 + cards[n - 1].times;
            ans += cards[n - 1].money;
            n--;
        }
        return ans;
    }
}
