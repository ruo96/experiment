package com.experiment.basic;

import com.experiment.domain.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wuruohong
 * @date 2022-06-27 17:31
 */
public class ObjectMapperStudy {
    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student("W1",18);
        String s = new ObjectMapper().writeValueAsString(student);
        System.out.println(s);

    }
}
