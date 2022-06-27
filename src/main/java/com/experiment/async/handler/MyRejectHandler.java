package com.experiment.async.handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wuruohong
 * @date 2022-06-27 8:44
 */
public class MyRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("拒绝后再次提交任务");
        executor.submit(r);
    }
}
