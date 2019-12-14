package cn.downey.java.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 请举例说明集合类是不安全的
 * <p>1 故障现象
 * <p>java.util.ConcurrentModificationException
 * <p>2 导致原因
 * <p>
 * <p>3 解决方案
 * <p>  3.1 new Vector<>();
 * <p>  3.2 Collections.synchronizedList(new ArrayList<>());
 * <p>  3.3 new CopyOnWriteArrayList<>();
 * <p>  写时复制（读写分离思想）：
 * <p>  在往一个CopyOnWrite容器添加元素的时候，不直接往当前容器添加，而是
 * 复制一个新容器，添加完后，再将原容器的引用指向新的容器。这样可以实现并发读
 * 而不需要加锁。因为当前容器不会添加任何元素。
 *
 * <p>4 优化建议
 */
public class NotSafeDemo {

    static {
        new HashMap<>();
        new HashSet<>();
        new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        //HashMap底层是Node类型的(数组+链表)+红黑树
        //哈希桶初始值容量16，负载因子0.75，到12扩容  扩容扩一倍
        //链表法解决冲突 java8中链表长度大于8(泊松分布)改用平衡树
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(System.currentTimeMillis() +
                        "\t" + map.size() +
                        "\t" + map);
            }, String.valueOf(i)).start();
        }

    }

    private static void setNotSafe() {
        //HashSet底层是HashMap
        //add方法的value是一个常量
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(System.currentTimeMillis() +
                        "\t" + Thread.currentThread().getName() +
                        "\t" + set.size() +
                        "\t" + set);
            }, String.valueOf(i)).start();
        }
    }

    /*Ctrl+Alt+M Extract Method*/
    private static void listNotSafe() {
        //Vector的add方法加了synchronized, 但同一时间段只能一个人读/写
        //List<String> list = new Vector<>();

        //ArrayList不安全
        //ArrayList底层是Object数组，默认容量10，扩容扩一半
        List<String> list = new ArrayList<>();

        //Collections. synchronized后带的不安全
        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        //List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(System.currentTimeMillis() +
                        "\t" + Thread.currentThread().getName() +
                        "\t" + list.size() +
                        "\t" + list);
            }, String.valueOf(i)).start();
        }
    }

}
