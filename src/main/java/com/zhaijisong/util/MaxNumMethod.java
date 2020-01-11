package com.zhaijisong.util;

import com.zhaijisong.dao.impl.MaxNumMehodDaoImpl;

import com.zhaijisong.pojo.MaxNum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 龚成
 * @Date: 2020年1月2日19:33:13
 * @Description:公共的方法
 */
@Component("maxNumMethod")
public class MaxNumMethod {
    //依赖注入数据访问层
    @Resource(name = "MaxNumMehodDaoImpl")
    private MaxNumMehodDaoImpl maxNumMehodDaoImpl;
    public void setSaleCommodityManageDaoImpl(MaxNumMehodDaoImpl maxNumMehodDaoImpl) {
        maxNumMehodDaoImpl = maxNumMehodDaoImpl;
    }
    /**
     * 获得单号最大编号
     * @return String
     */
    public String getOddMaxNo(MaxNum maxNum){
        //获得对象
        MaxNum searchNo = maxNumMehodDaoImpl.searchMaxNum(maxNum);
        StringBuilder max = new StringBuilder();
        //获得前缀
        String manPre = searchNo.getManPre();

        //获得前缀的长度
        int manLength = manPre.length();

        //获得当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String format = df.format(new Date());

        //判断searchNo.getManSort()不为null且长度大于0
        if (null != searchNo.getManSort() && 0 < searchNo.getManSort().length()) {
            //获得最大的编号
            String i = searchNo.getManSort();
            //获得包含日期行
            String substring = i.substring(manLength, 8+manLength);
            //添加前缀和日期
            max.append(manPre + format);

            //判断date等于当天说明已经存在当天的数据否则则无
            if (!format.equals(substring)) {
                //添加后缀
                max.append(searchNo.getManSt());
            } else {
                //获得后缀的长度
                int length = searchNo.getManSt().length();

                //获得不包含日期
                int number = Integer.parseInt(i.substring(manLength+8));
                //累加
                number++;
                //转换为String
                String numberString = number+"";
                //获得数字长度
                int length1 = numberString.length();

                //获得不包含数字的长度添加为0
                int noIncludeNumberLength=length-length1;
                for (int j = 0; j < noIncludeNumberLength; j++) {
                    max.append("0");
                }
                max.append(number);
            }
        }else{//为null
            max.append(manPre+format+searchNo.getManSt());
        }
        return max.toString();

    }

    /**
     *查询普通编号
     * @param maxNum
     * @return
     */
    public String getPuMaxNo(MaxNum maxNum){

        //获得对象
        MaxNum searchNo = maxNumMehodDaoImpl.searchMaxNum(maxNum);

        //声明最大编号
        StringBuilder max = new StringBuilder();

        //获得前缀
        String manPre = searchNo.getManPre();

        //获得后缀
        String manSt = searchNo.getManSt();

        //判断searchNo.getManSort()不为null且长度大于0
        if (null != searchNo.getManSort() && 0 < searchNo.getManSort().length()) {
            //添加前缀
            max.append(manPre);

            //获得最大的编号
            String i = searchNo.getManSort();

            //获得前缀的长度
            int preLenght = manPre.length();

            //获得后缀的长度
            int stLength = manSt.length();

            //获得最大编号中的数字
            int number = Integer.parseInt(i.substring(preLenght))+1;

            //将得到最大编号的数字转换为String
            String numberString = number+"";

            //获得数字长度
            int length1 = numberString.length();

            //获得不包含数字的长度添加为0
            int noIncludeNumberLength=stLength-length1;

            for (int j = 0; j < noIncludeNumberLength; j++) {
                max.append("0");
            }
            max.append(number);
        }else{//为null
            max.append(manPre+manSt);
        }
        return max.toString();
    }
    /**
     * 修改最大编号
     * @param maxNo 条件
     * @return int
     */
    public int updateMax(MaxNum maxNo){
        int rows= maxNumMehodDaoImpl.excuteUpdateRolesMaxNum(maxNo);
        return rows;
    }
}
