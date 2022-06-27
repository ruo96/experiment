package com.experiment.concurrentStudyAll;

/**
 * @author wuruohong
 * @date 2022-06-20 15:17
 * 避免伪共享
 */
public class Pointer {
    /**  避免伪共享  @Contended +jvm参数 --XX：-RestrictContended jdk8支持*/
    volatile long x;

    /** 避免伪共享  缓存行填充*/
    long p1,p2,p3,p4,p5,p6,p7;
    volatile long y;
}
