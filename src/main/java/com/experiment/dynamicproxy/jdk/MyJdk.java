package com.experiment.dynamicproxy.jdk;

import com.experiment.dynamicproxy.PersonInterface;
import com.experiment.dynamicproxy.PersonMove;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wuruohong
 * @date 2022-06-27 9:02
 */
public class MyJdk implements InvocationHandler {

    private Object target;

    public Object newProxyInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理执行前 ");
        return method.invoke(this.target, args);
    }

    public static void main(String[] args) {
        PersonInterface personInterface = (PersonInterface) new MyJdk().newProxyInstance(new PersonMove());
        personInterface.run();

    }
}
