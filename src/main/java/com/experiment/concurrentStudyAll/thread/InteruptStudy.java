package com.experiment.concurrentStudyAll.thread;

/**
 * @author wuruohong
 * @date 2022-06-21 0:14
 */
public class InteruptStudy {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock) {
                    int count = 0;
                    while (!Thread.currentThread().isInterrupted() && count < 100) {
                        System.out.println("count: " + count++);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("i feel interupt");
                        }
                    }
                    System.out.println("thread stop");
                }

            }
        });

        // Thread t1 = new Thread(new StopThread());
        t1.setDaemon(false);
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();
    }
}
