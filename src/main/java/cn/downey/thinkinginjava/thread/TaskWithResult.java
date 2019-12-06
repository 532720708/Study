package cn.downey.thinkinginjava.thread;

import java.util.concurrent.Callable;

class TaskWithResult implements Callable {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public Object call() throws Exception {
        return Thread.currentThread() + "-----Result of TaskWithResult " + id;
    }
}


