package cn.downey.java.juc;

import java.util.concurrent.TimeUnit;

class Phone {
    public synchronized void sendEmail() throws Exception {
        //暂停一会线程
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=======Send Email");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("=======Send Message");
    }

    public void hello() {
        System.out.println("=======Hello");
    }
}

/**
 * 多线程8锁
 * 1.   标准访问，先打印邮件还是短信？
 * 2.   邮件方法暂停4秒，先打印邮件还是短信？
 * 3.   新增一个普通方法hello，先打印邮件还是hello？
 * 4.   两部手机，先打印邮件还是短信？
 * 5.   两个静态同步方法，同一部手机，先打印邮件还是短信？
 * 6.   两个静态同步方法，2部手机，先打印邮件还是短信？
 * 7.   1个同步方法，一个静态同步方法，1部手机，先打印邮件还是短信？
 * 8.   1个同步方法，一个静态同步方法，2部手机，先打印邮件还是短信？
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

        Thread.sleep(100);

        new Thread(() -> {
            try {
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
