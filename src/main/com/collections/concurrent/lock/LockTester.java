package com.collections.concurrent.lock;

public class LockTester {
    public static void main(String[] args) {
        Resource r=new Resource();
        //Thread t1=new Thread(new ConcurrencyLockExample(r));
        //Thread t2=new Thread(new ConcurrencyLockExample(r));
        //t1.start();
        //t2.start();

        Thread t3=new Thread(new SynchronizedLockExample(r));
        Thread t4=new Thread(new SynchronizedLockExample(r));

        t3.setName("third");
        t4.setName("forth");

        t3.start();
        t4.start();

    }
}
