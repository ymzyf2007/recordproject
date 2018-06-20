package com.east.dragon.record;

public class Record20180510_ThreadLocalTest {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void setValue() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLongValue() {
        return longLocal.get();
    }

    public String getStringValue() {
        return stringLocal.get();
    }

    public static void main(String[] args) {
        final Record20180510_ThreadLocalTest test = new Record20180510_ThreadLocalTest();
        test.setValue();
        System.out.println(test.getLongValue());
        System.out.println(test.getStringValue());

        Thread t = new Thread(new Runnable() {
            public void run() {
                test.setValue();
                System.out.println(test.getLongValue());
                System.out.println(test.getStringValue());
            }
        });
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(test.getLongValue());
        System.out.println(test.getStringValue());
    }

}
