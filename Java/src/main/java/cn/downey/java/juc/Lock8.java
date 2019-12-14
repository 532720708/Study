package cn.downey.java.juc;

import java.util.concurrent.TimeUnit;

class Phone {

    public static synchronized void sendEmail() throws Exception {
        System.out.println(System.currentTimeMillis() + "\t" + Thread.currentThread().getName());
        //暂停一会线程
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + "\t Send Email");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println(System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + "\t Send Message");
    }

    public void hello() {
        System.out.println(System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + "\t Hello");
    }
}

/**
 * 多线程8锁
 * <p>
 * 1.   标准访问，先打印邮件还是短信？
 * <p>
 * 2.   邮件方法暂停4秒，先打印邮件还是短信？
 * <p>
 * synchronized锁的不是当前方法，而是当前对象,
 * 一个对象里面如果有多个同步方法，某一个时刻内，只要一个线程去调用其中一个同步方法，
 * 其它线程只能等待，换句话说，某一个时刻能，只能有唯一一个线程去访问这些同步方法,
 * 锁的是当前对象this，其它线程都不能进入到当前对象的其它同步方法
 * <p>
 * 3.   新增一个普通方法hello，先打印邮件还是hello？
 * <p>
 * 4.   两部手机，先打印邮件还是短信？
 * <p>
 * 普通方法和同步锁无关,
 * 换成两个对象后，是两个this
 * <p>
 * 5.   两个静态同步方法，同一部手机，先打印邮件还是短信？
 * <p>
 * 6.   两个静态同步方法，2部手机，先打印邮件还是短信？
 * <p>
 * new this, 锁是具体的一个对象,
 * static，锁的是类模板
 * <p>
 * 7.   1个同步方法，一个静态同步方法，1部手机，先打印邮件还是短信？
 * <p>
 * 8.   1个同步方法，一个静态同步方法，2部手机，先打印邮件还是短信？
 * <p>
 * 对于普通同步方法，锁的是当前实例对象
 * <p>
 * 对于静态同步方法，锁的是当前类的class对象
 * <p>
 * 对于同步方法块，锁的是Synchronized括号配置里的对象
 * <p>
 * 所有的静态同步方法锁的是类对象本身，静态同步和非静态同步不会产生竞争
 */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100); //保证A先抢到资源

        new Thread(() -> {
            try {
//                phone.sendSMS();
//                phone.hello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
