package cn.downey.interview.Tencent;

import java.util.Scanner;

class Card {
    int a;
    int b;
    boolean cur;

    public Card(int a, int b) {
        this.a = a;
        this.b = b;
        this.cur = false;
    }

    public int get() {
        return !cur ? a : b;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] str1 = scanner.nextLine().split(" ");
        String[] str2 = scanner.nextLine().split(" ");
        Card[] cards = new Card[count];
        for (int i = 0; i < count; i++) {
            cards[i] = new Card(Integer.parseInt(str1[i]), Integer.parseInt(str2[i]));
        }
        System.out.println(func(count, cards));
    }

    private static int func(int count, Card[] cards) {
        int times = 0;
        boolean isSorted = false;
        for (int i = 0; i < count - 1; i++) {
            if (cards[i].get() > cards[i + 1].get()) {
                swapAndReverse(cards, i, i + 1);
                times++;
                if (cards[i].get() <= cards[i + 1].get()) {
                    isSorted = true;
                } else {
                    isSorted = false;
                    break;
                }
            } else {
                isSorted = true;
            }
        }
        return isSorted ? times : -1;
    }

    private static void swapAndReverse(Card[] cards, int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = cards[i];
        cards[i].cur = !cards[i].cur;
        cards[j].cur = !cards[j].cur;
    }
}
