package com.experiment.concurrentStudyAll;

import java.util.concurrent.*;

/**
 * @author wuruohong
 * @date 2022-06-21 10:05
 */
public class Class7 {
    public static void main(String[] args) throws InterruptedException {

        // Condition;

        ArrayBlockingQueue b;
        SynchronousQueue s;
        LinkedBlockingQueue linkedBlockingQueue;     // 两把锁 锁分离  每个锁上面有condition
        LinkedBlockingDeque l;
        Executors.newCachedThreadPool();
        LinkedTransferQueue queue = null;
        queue.take();  // 自旋 + locksupport。park
        PriorityBlockingQueue<String> p = new PriorityBlockingQueue<>(); // 默认11  会扩容
        DelayQueue delayQueue;  // 入队不阻塞， 出队为空阻塞，出队时候判断未到过期事件，就判断leader有没有，有就阻塞，没有就自己当leader

        /*p.put(3);
        p.put(5);
        p.put(1);
        p.put(7);
        p.put(6);*/

        p.put("a");
        p.put("f");
        p.put("e");
        p.put("c");
        p.put("v");

        while (p.size() > 0) {
            System.out.println("p.take() = " + p.take());
        }
    }
}
