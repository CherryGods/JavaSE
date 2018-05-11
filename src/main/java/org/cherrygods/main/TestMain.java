package org.cherrygods.main;

import org.cherrygods.thread.TestThread02;
import org.cherrygods.thread.TestThread01;

/**
 * @author CherrGods
 * @since 2018-5-10 12:00:40
 */
public class TestMain
{
    public static void main(String[] args) {
        TestThread01 t1 = new TestThread01();
        TestThread02 t2 = new TestThread02();
        t1.run();
        t2.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main >>> "+i);
        }
    }
}
