package cn.downey.java.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //TODO 抛出异常组
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x"));
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

        //TODO 特殊值组
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x"));
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

        //TODO 阻塞
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("x");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();

        //TODO 超时(过时不候)
//        System.out.println(blockingQueue.offer("a", 100, TimeUnit.MILLISECONDS));
//        System.out.println(blockingQueue.offer("b", 100, TimeUnit.MILLISECONDS));
//        System.out.println(blockingQueue.offer("c", 100, TimeUnit.MILLISECONDS));
//        System.out.println(blockingQueue.offer("d", 100, TimeUnit.MILLISECONDS));
//
//        System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS));
//        System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS));
//        System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS));
//        System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS));


    }
}
