package com.experiment.async;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

/**
 * @author wuruohong  自定义线程池  比较好的方法
 * @date 2022-06-24 20:29
 */
public class ThreadStudy {

    public static String THREAD_NAME = "first-thread-pool-%d";
    public static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2 + 1;
    public static int MAX_POOL_SIZE = 10;
    public static int QUEUE_SIZE = 10;

    /**
     * 自定义消费队列线程池
     *
     * @return
     */
    @Bean(value = "firstThreadPool")
    public ExecutorService buildFirstThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat(THREAD_NAME).build();

        /**
         * 1. CallerRunsPolicy ：    这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功。
         2. AbortPolicy ：         对拒绝任务抛弃处理，并且抛出异常。
         3. DiscardPolicy ：       对拒绝任务直接无声抛弃，没有异常信息。
         4. DiscardOldestPolicy ： 对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列。
         */
        ExecutorService threadPool = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(QUEUE_SIZE),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
    }
// ————————————————
//     版权声明：本文为CSDN博主「Andya_net」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/Andya_net/article/details/106425501


    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
            int begin = new Random().nextInt(3);
            System.out.println("begin = " + begin);
            int end = ++begin % 3;
            System.out.println("end = " + end);
        }

        for (int i = 0; i < 10; i++) {
            int value = new Random().nextInt(2) +1;
            System.out.println("value = " + value);
        }*/

        // ThreadPoolExecutor executor = new ThreadPoolExecutor();
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newCachedThreadPool();


        // ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 200,60, TimeUnit.SECONDS,new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 6,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(5));
        executor.setThreadFactory(new ThreadFactoryBuilder().setNameFormat("my-custome-thread-%d").build());
        /*executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("reject occur");
                *//** 抛异常外界虽然可以看到，但是整个线程池任务就终止了 这种方法是不可取的。*//**//*
                throw new RuntimeException("exception!!!");*//*
            }
        });*/

        try {
            for (int i = 0; i < 50; i++) {
                System.out.println("ready sumit : " + i);
                executor.submit(new MyTask(i));
            }
        } catch (RejectedExecutionException e){
            System.out.println(" catch rejection: "+ e.getMessage());
        }catch (Exception e) {
            System.out.println("reject: " + e);
        }

        // ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = Executors.newScheduledThreadPool(10);


    }
}
