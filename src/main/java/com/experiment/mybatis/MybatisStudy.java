package com.experiment.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author wuruohong
 * @date 2022-06-21 23:23
 */
public class MybatisStudy {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis‐config.xml";
            //将XML配置文件构建为Configuration配置类
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        // 这个获取到的sqlsession就是defaultSqlSession, 内部包含executor和configuration，所以从中也可以获取到全局配置信息
        Configuration configuration = sqlSession.getConfiguration();
        // 这个地方就是那个mapper了
        sqlSession.getMapper(Object.class);

    }
}
