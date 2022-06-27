package com.experiment.spring.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wuruohong
 * @date 2022-06-21 22:20
 */
public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader<ServiceLoadInterface> serviceLoader = ServiceLoader.load(ServiceLoadInterface.class);
        Iterator<ServiceLoadInterface> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            ServiceLoadInterface next = iterator.next();
            next.say();
        }
    }
}
