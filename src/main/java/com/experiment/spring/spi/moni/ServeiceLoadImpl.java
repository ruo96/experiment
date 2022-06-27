package com.experiment.spring.spi.moni;

import com.experiment.spring.spi.ServiceLoadInterface;

/**
 * @author wuruohong
 * @date 2022-06-21 22:21
 */
public class ServeiceLoadImpl implements ServiceLoadInterface {
    @Override
    public void say() {
        System.out.println(" 我是spi实现 ");
    }
}
