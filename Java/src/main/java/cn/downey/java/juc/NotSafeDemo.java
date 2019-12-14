package cn.downey.java.juc;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 请举例说明集合类是不安全的
 * <p>1 故障现象
 * <p>java.util.ConcurrentModificationException
 * <p>2 导致原因
 * <p>
 * <p>3 解决方案
 * <p>  3.1 new Vector<>();
 * <p>  3.2 Collections.synchronizedList(new ArrayList<>());
 * <p>  3.3
 *
 * <p>4 优化建议
 */
public class NotSafeDemo {
    public static void main(String[] args) {

        //ArrayList不安全
        //List<String> list = new ArrayList<>();

        //Vector的add方法加了synchronized
        //List<String> list = new Vector<>();

        //Collections. synchronized后带的不安全
        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();


        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();

        }

    }

}
