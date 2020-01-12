package cn.downey.codinginterview;

import java.util.ArrayList;

public class Test {
    ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> a(Integer integer) {
        b(integer, new ArrayList<>());
        return arrayList;
    }

    private void b(Integer integer, ArrayList<Integer> ints) {
        for (int i = 0; i < integer; i++) {
            ints.add(i);
        }
        arrayList.add(ints);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.a(5);
    }

}
