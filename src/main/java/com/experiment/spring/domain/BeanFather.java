package com.experiment.spring.domain;

/**
 * @author wuruohong
 * @date 2022-06-16 2:33
 */
public class BeanFather extends BeanGrandFather{
    @Override
    public void say() {
        System.out.println(" father ");
    }
}
