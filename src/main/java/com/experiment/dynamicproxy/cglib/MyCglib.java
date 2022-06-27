package com.experiment.dynamicproxy.cglib;

import com.experiment.dynamicproxy.PersonMove;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wuruohong
 * @date 2022-06-27 8:52
 */
public class MyCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行方法前");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("执行方法后");
        return o1;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonMove.class);
        enhancer.setCallback(new MyCglib());
        PersonMove p = (PersonMove) enhancer.create();
        p.run();
    }
}
