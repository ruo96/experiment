package com.experiment.async;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author wuruohong
 * @date 2022-06-25 0:42
 */
public class MyTask implements Runnable{

    private int a;

    public MyTask(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(LocalDateTime.now().toString() + "i am running" + Thread.currentThread().getId() + "myid: " + a) ;
        TimeUnit.SECONDS.sleep(1);
    }
}
