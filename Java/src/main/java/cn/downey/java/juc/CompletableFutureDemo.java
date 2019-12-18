package cn.downey.java.juc;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
//        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "\t没有返回");
//        });
//        System.out.println(runAsync.get());

        //异步回调
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t有返回");
            int age = 10 / 0;
            return 1024;
        }).whenComplete((t, u) -> {
            System.out.println("**************T:" + t);  //执行正常返回给t，u为null
            System.out.println("**************U:" + u);  //执行错误返回给u，t为null
        }).exceptionally(f -> {
            System.out.println("**************E:" + f.getMessage());
            return 4444;
        });

        System.out.println(supplyAsync.get()); //执行正常不进exceptionally，直接返回结果

    }
}
