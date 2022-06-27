package com.experiment.concurrentStudyAll.thread;

/**
 * @author wuruohong
 * @date 2022-06-20 23:58
 */
public class StopThread implements Runnable{


    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 100) {
            System.out.println("count: " + count++);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                 System.out.println("i feel interupt");
                e.printStackTrace();

            }
        }
        System.out.println("thread stop");
    }


}
