package com.ailot.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author lt48615
 * @date 2019-04-10 21:29
 */
public class LatchTest {

    public static void main(String[] args) throws Exception {
        Runnable taskTemp = new Runnable() {

            private int counter;

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter++;
                    System.out.println(System.nanoTime() + "[" + Thread.currentThread().getName() + "] counter=" + counter);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        LatchTest latchTest = new LatchTest();
        latchTest.startTaskAllOnce(5,taskTemp);

    }

    public long startTaskAllOnce(int threadNums, final Runnable task) throws Exception {
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(threadNums);
        for (int i = 0; i < threadNums; i++) {
            Thread thread = new Thread(() -> {
                try {
                    start.await();
                    task.run();
                    end.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            thread.start();
        }
        long startTime = System.nanoTime();
        System.out.println(startTime + "[" + Thread.currentThread().getName() + "] All thread is ready");
        start.countDown();
        end.await();
        long endTime = System.nanoTime();
        System.out.println(startTime + "[" + Thread.currentThread().getName() + "] All thread is completed");
        return endTime - startTime;
    }
}
