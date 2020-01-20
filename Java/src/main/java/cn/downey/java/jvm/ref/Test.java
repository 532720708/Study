package cn.downey.java.jvm.ref;

import java.util.ArrayList;
import java.util.HashMap;

class KeyDemo {

    Double db;

    KeyDemo(Double db) {
        this.db = db;
    }

    @Override
    public String toString() {
        return db.toString();
    }
}

public class Test {
    public static void main(String[] args) {
        HashMap<KeyDemo, String> hashMap = new HashMap<>();
        ArrayList<KeyDemo> arrayList = new ArrayList<>();
        KeyDemo keyDemo = new KeyDemo(5.123);
        hashMap.put(keyDemo, "aaa");
        arrayList.add(keyDemo);
        System.out.println(hashMap.get(keyDemo));
        System.out.println(arrayList.get(0));
        arrayList.add(keyDemo);
        keyDemo.db = 6.321;
        System.out.println(hashMap.get(keyDemo));
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
    }
}
