package com.experiment.basic.enums;

/**
 * @author wuruohong
 * @date 2022-06-27 9:38
 */
public class EnumStudy {
    public static void main(String[] args) {
        for (MyEnum value : MyEnum.values()) {
            System.out.println("value = " + value);
            System.out.println("value.name() = " + value.name());

        }

    }
}
