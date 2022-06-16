package com.experiment.cache.google;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wuruohong
 * @date 2022-06-16 14:02
 */
public class GuavaCache {
    private static LoadingCache<Integer, String> getCache = CacheBuilder.newBuilder().softValues()
            .maximumSize(5000).expireAfterWrite(2, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer integer) throws Exception {
                    System.out.println(" come db");
                    return "wrh";
                }
            });

    @Test
    public void Test25() throws ExecutionException {
        System.out.println("getCache.get(1) = " + getCache.get(1));
        System.out.println("getCache.get(1) = " + getCache.get(1));

    }
}
