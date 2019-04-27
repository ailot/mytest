package com.ailot.juc;

import java.util.concurrent.*;

public class TestCountDownLatch {

    public static void main(String[] args) {

        final int threadCount = 10;

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        ExecutorService executorService = new ThreadPoolExecutor(threadCount, threadCount, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println("服务" + name + "开始启动");
                try {
                    int time = (int) (10000 + Math.random() * 50000);
                    System.out.println(name + "休眠：" + time);
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("服务" + name + "启动完成");
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有服务启动完毕" + countDownLatch.getCount());
    }
}
