package com.experiment.dynamicproxy;

/**
 * @author wuruohong
 * @date 2022-06-27 8:55
 */
public class PersonMove implements PersonInterface{

    public PersonMove() {
        System.out.println("person 构造");
    }

    @Override
    public void run(){
        System.out.println("person run");
    }


}
