package org.algorithms.onecontact;

import java.math.BigInteger;

public class ThreadJoinTest implements Runnable {

    public ThreadJoinTest(String n) {
        this.name = n;
    }

    public String name;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadJoinTest("Foo1"));
        Thread t2 = new Thread(new ThreadJoinTest("Foo2"));
        Thread t3 = new Thread(new ThreadJoinTest("Foo3"));

        t1.start();
        t2.start();
        t3.start();
        t2.join();
        t1.join();
        t3.join();
    }

}
