package com.experiment.async.threadExperiment.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author wuruohong
 * @date 2022-06-19 21:39
 */
public class LongSum extends RecursiveTask<Long> {

    static final int SEQUENTIAL_THRESHOLD = 10000;
    int low;
    int high;
    int[] array;

    LongSum(int[] arr, int lo, int hi) {
        array = arr;
        low = lo;
        high = hi;
    }

    @Override
    protected Long compute() {
        //当任务拆分到小于等于阀值时开始求和
        if (high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for (int i = low; i < high; ++i) {
                sum += array[i];
            }  return sum;
        } else {
            // 任务过大继续拆分
            int mid = low + (high - low) / 2;
            LongSum left = new LongSum(array, low, mid);
            LongSum right = new LongSum(array, mid, high);
            // 提交任务
            left.fork();
            right.fork();
            //获取任务的执行结果,将阻塞当前线程直到对应的子任务完成运行并返回结果
            long rightAns = right.join();
            long leftAns = left.join();
            return leftAns + rightAns;
        }
    }

    public static void main(String[] args) {

        // int[] arr = Stream.generate(Math::random).limit(10).mapToInt(i->i).toArray()

        int[] array = IntStream.range(1,100000000).toArray();

        int size = array.length;
        long ret = 0;

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            ret += array[i];
        }
        long start2 = System.currentTimeMillis();
        System.out.println("ret = " + ret);

        System.out.println("1 start2-start1 = " + (start2 - start1));



        //递归任务 用于计算数组总和
        LongSum ls = new LongSum(array, 0, array.length);
        // 构建ForkJoinPool
        ForkJoinPool fjp = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        start1 = System.currentTimeMillis();
        //ForkJoin计算数组总和
        ForkJoinTask<Long> result = fjp.submit(ls);

        System.out.println("result.join() = " + result.join().longValue());
        start2 = System.currentTimeMillis();

        System.out.println("2 start2-start1 = " + (start2 - start1));
    }

}
