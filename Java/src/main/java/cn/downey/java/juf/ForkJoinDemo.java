package cn.downey.java.juf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer> {

    private static final Integer ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - begin) <= ADJUST_VALUE) {
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        } else {
            int middle = begin + ((end - begin) >> 1);
            MyTask task01 = new MyTask(begin, middle);
            MyTask task02 = new MyTask(middle + 1, end);
            //fork就是创建分支的意思：
            //如果任务大小小于我们能接受的大小，那线程直接执行；
            //否则，我们会创建分支，由两个子线程来执行原任务，依次递归；
            task01.fork();
            task02.fork();
            //join就是线程等待的意思：
            // 父任务线程创建了子任务线程，他需要等待子任务线程执行完毕，返回最终结果。
            result = task01.join() + task02.join();
        }
        return result;
    }

}

/**
 * 分支合并框架
 * <p>
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);

        ForkJoinPool threadPool = new ForkJoinPool();

        ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        threadPool.shutdown();
    }
}
