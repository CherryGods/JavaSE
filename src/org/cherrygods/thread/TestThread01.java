package org.cherrygods.thread;

public class TestThread01 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("T01 >>> " + i);
        }
    }
}
