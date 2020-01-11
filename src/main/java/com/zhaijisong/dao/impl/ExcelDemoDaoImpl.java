package com.zhaijisong.dao.impl;

import com.zhaijisong.handler.ExcelHandle;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("excelDemoDaoImpl")
public class ExcelDemoDaoImpl {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;

    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<ExcelHandle> getExcelList(){
        SqlSession sqlSession=null;
        List<ExcelHandle> excelList =new ArrayList<ExcelHandle>();
        try{
            sqlSession = sqlSessionFactory.openSession();
            //查询数据
            excelList=sqlSession.selectList("excel.crud.exceldemo");
        }catch (NullPointerException ex){
            ex.getMessage();
        }finally {
            //判断sqlSession不为null
            if (null!= sqlSession) {
                sqlSession.close();
            }
        }
        return excelList;
    }
}
