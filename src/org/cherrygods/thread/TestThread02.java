package org.cherrygods.thread;

public class TestThread02 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("T02 >>> "+i);
        }
    }
}