package com.experiment.async.threadExperiment;

import org.junit.Test;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author wuruohong
 * @date 2022-06-19 13:14
 */

public class ThreadKnowledge {

    @Test
    public void Test1(){
        Executor executor = new ThreadPoolExecutor(
                10,20,60L, TimeUnit.SECONDS
                ,new ArrayBlockingQueue<>(100));
        return;

    }

    @Test
    public void Test(){
        Queue<Integer> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println("queue.size() = " + queue.size());

        for (int i = 0; i < 12; i++) {
            System.out.println("queue.poll() = " + queue.poll());
        }
    }

    @Test
    public void Test22(){
        Integer[] item = new Integer[]{1,2,3};
        final Integer[] item1 = item;
        System.out.println("item1==item = " + (item1 == item));



    }
    @Test
    public void Test33(){

               /* Executors.newCachedThreadPool();   -- SynchronousQueue
        Executors.newFixedThreadPool();            -- LinkedBlockingQueue
        Executors.newSingleThreadExecutor();       -- LinkedBlockingQueue
        Executors.newScheduledThreadPool();        -- DelayedWorkQueue
        Executors.newSingleThreadExecutor();        -- LinkedBlockingQueue*/
    }

    @Test
    public void Test44(){
        // LongSum
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(0);
        System.out.println("set = " + set);
    }

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }

    @Test
    public void Test55() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        // completionService.take()

        ForkJoinPool.commonPool();
        // Future
    }
}
