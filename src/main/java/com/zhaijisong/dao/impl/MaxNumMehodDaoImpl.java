package com.zhaijisong.dao.impl;
import com.zhaijisong.pojo.MaxNum;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("MaxNumMehodDaoImpl")
public class MaxNumMehodDaoImpl {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory=null;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public MaxNum searchMaxNum(MaxNum maxNum) {
        SqlSession sqlSession=null;
        MaxNum maxNum1= null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            maxNum1=sqlSession.selectOne("maxnum.crud.searchMaxNo",maxNum);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return maxNum1;
    }

    public int excuteUpdateRolesMaxNum(MaxNum maxNum) {
        SqlSession sqlSession=null;
        int rows=0;
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            rows=sqlSession.update("maxnum.crud.excuteUpdateRolesMaxNo",maxNum);
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return rows;
    }
}
