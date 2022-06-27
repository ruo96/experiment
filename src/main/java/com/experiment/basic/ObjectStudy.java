package com.experiment.basic;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author wuruohong
 * @date 2022-06-21 7:24
 * 如果一开始没有休眠，那么启动就是无锁状态，加synchronized之后变轻量锁
 * 如果开始时候休眠了，那么启动就是偏向锁， 加synchronized之后还是偏向锁
 *
 * JVM启动过程，会有很多线程竞争（明确知道），所以默认情况，JVM启动时不打开偏向锁（默认时延4秒）。一段时间之后再打开。可以使用Thread.sleep(5000);
 *
 * 在类中声明的变量是成员变量，也叫全局变量， 放在堆中，因为不会随着方法结束而销毁
 *
 *                        局部变量                                成员变量
 * 基本数据类型          变量名和值都在方法栈                          都在堆
 * 引用数据类型           变量在方法栈，变量指向的对象在堆         变量名和变量名指向的对象都在堆
 */
public class ObjectStudy {
    public static void main(String[] args) throws InterruptedException {
        // TimeUnit.SECONDS.sleep(5);
        /*Object obj = new Object();
        System.out.println("ClassLayout.parseInstance(obj).toPrintable() = " + ClassLayout.parseInstance(obj).toPrintable());*/
        /*ObjectToCalcute obj1 = new ObjectToCalcute();
        System.out.println("ClassLayout.parseInstance(obj1).toPrintable() = " + ClassLayout.parseInstance(obj1).toPrintable());*/
        /*synchronized (obj) {
            System.out.println("AFTER SYNCHRONIZED ClassLayout.parseInstance(obj).toPrintable() = " + ClassLayout.parseInstance(obj).toPrintable());

        }*/
        /**
         * int 4字节   String  4字节    Integer 4字节  对象都是引用的地址
         */
        ObjectToCalcute obj1 = new ObjectToCalcute();
        System.out.println("ClassLayout.parseInstance(obj1).toPrintable() = " + ClassLayout.parseInstance(obj1).toPrintable());
        obj1.setA(new String("1"));
        System.out.println("ClassLayout.parseInstance(obj1).toPrintable() = " + ClassLayout.parseInstance(obj1).toPrintable());
        obj1.setA("2");
        System.out.println("ClassLayout.parseInstance(obj1).toPrintable() = " + ClassLayout.parseInstance(obj1).toPrintable());

    }
}
