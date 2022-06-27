package com.experiment.concurrentStudyAll;

/**
 * @author wuruohong
 * @date 2022-06-20 15:10
 * 伪共享
 */
public class Class2 {
    public static void main(String[] args) throws InterruptedException {
        testPointer(new Pointer());
    }

    private static void testPointer(Pointer pointer) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100000000; i++) {
                pointer.x ++;
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100000000; i++) {
                pointer.y ++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(pointer.x + "-----------------" + pointer.y);
        System.out.println(System.currentTimeMillis() - start);
    }

}
