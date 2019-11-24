package cn.downey.thinkinginjava.thread;

public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){
        this.countDown = countDown;
    }

    public String status(){
        return
                Thread.currentThread() +
                        "#" + id + "-----" +(countDown > 0 ? countDown : "Liftoff!");
    }


    public void run() {
        while(countDown-- > 0){
            System.out.println(Thread.currentThread()+"-----"+status());
            Thread.yield();
        }
    }
}
