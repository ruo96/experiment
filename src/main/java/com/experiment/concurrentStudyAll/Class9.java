package com.experiment.concurrentStudyAll;


import com.experiment.concurrentStudyAll.yml.YmlObj;
import org.ho.yaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wuruohong
 * @date 2022-06-21 12:55
 */
public class Class9 {
    public static void main(String[] args) throws IOException {

        // Yaml yaml = new Yaml();
        // YmlObj obj = yaml.loadAs(Class9.class.getResourceAsStream("yamlobj.yml", YmlObj.class));

        /**
         * 这也是一种读取配置文件的方式
         */
        YmlObj obj = Yaml.loadType(Class9.class.getResourceAsStream("/yamlobj.yml"), YmlObj.class);
        System.out.println("obj = " + obj);

        /**
         * 第二种方式
         */
        InputStream inputStream = Class9.class.getResourceAsStream("/yamlobj.yml");
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println("properties.getProperty(\"mm\") = " + properties.getProperty("mm"));

        /**
         * 外部文件的方式
         */
        FileInputStream fileInputStream = new FileInputStream("D:\\data\\yamlobj.yml");
        properties = new Properties();
        properties.load(fileInputStream);
        System.out.println("fileInputStream properties.getProperty(\"mm\") = " + properties.getProperty("mm"));



    }
}
