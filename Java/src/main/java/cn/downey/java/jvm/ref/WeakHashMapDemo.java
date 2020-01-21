package cn.downey.java.jvm.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("===========");
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<KeyDemo, String> map = new HashMap<>();
        KeyDemo keyDemo = new KeyDemo(5.123);
        String value = "HashMap";

        map.put(keyDemo, value);
        System.out.println(map);

        keyDemo.db = 6.321;
        System.out.println(map);

        System.gc();
        System.out.println(map + "==" + map.size());
    }


    private static void myWeakHashMap() {
        WeakHashMap<KeyDemo, String> map = new WeakHashMap<>();
        KeyDemo keyDemo = new KeyDemo(5.123);
        String value = "WeakHashMap";

        map.put(keyDemo, value);
        System.out.println(map);

        keyDemo = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "==" + map.size());
    }
}
