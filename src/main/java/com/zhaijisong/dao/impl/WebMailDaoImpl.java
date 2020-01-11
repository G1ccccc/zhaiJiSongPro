package com.zhaijisong.dao.impl;

import com.zhaijisong.pojo.UserMsg;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("webMailDaoImpl")
public class WebMailDaoImpl {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;

    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public int insertUserMasg(UserMsg userMsg) {
        SqlSession sqlSession=null;
        int fh=0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "usermsg.crud.insertUserMasg";
            //6、执行查询操作
            fh = sqlSession.insert(statementKey,userMsg);
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return fh;
    }
}
