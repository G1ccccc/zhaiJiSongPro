package com.zhaijisong.handler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.zhaijisong.dao.impl.ExcelDemoDaoImpl;

import com.zhaijisong.pojo.ExcelDemo;
import com.zhaijisong.pojo.MaxNum;
import com.zhaijisong.util.MaxNumMethod;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("excel")
public class ExcelHandle {
    @Resource(name = "excelDemoDaoImpl")
    private ExcelDemoDaoImpl excelDemoDaoImpl = null;
    public void setExcelDemoDaoImpl(ExcelDemoDaoImpl excelDemoDaoImpl) {
        this.excelDemoDaoImpl = excelDemoDaoImpl;
    }

    @Resource(name = "maxNumMethod")
    private MaxNumMethod maxNumMethod = null;
    public void setExcelDemoDaoImpl(MaxNumMethod maxNumMethod) {
        this.maxNumMethod = maxNumMethod;
    }

    @RequestMapping(value = "/excelDemo.action")
    public @ResponseBody
    List<ExcelHandle> getExcelList(){
        List<ExcelHandle> list =  excelDemoDaoImpl.getExcelList();
        return list;
    }
    @RequestMapping(value = "/excelDemo1.action")
    public @ResponseBody int getExcelList1(String data){
        //将数据表格json格式转换为list集合
        List<ExcelDemo> list = JSONArray.toList(JSONArray.fromObject(data),new ExcelDemo(),new JsonConfig());
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getBorndatestr());
        }
        return 1;
    }
    @RequestMapping(value = "/maxnotest.action")
    public @ResponseBody int getExcelList2(){
        //获取用户反馈表普通主键
        MaxNum maxNum =new MaxNum("receipts",1);
        String useropinionID=maxNumMethod.getPuMaxNo(maxNum);
        System.out.println(useropinionID);

        //更改销售单据明细表 普通主键ID
        MaxNum maxNo1=new MaxNum("receipts",useropinionID,1);
        int fh1=maxNumMethod.updateMax(maxNo1);



        //获取最大单号
        MaxNum maxNum1 =new MaxNum("receipts",2);
        String useropinionID1=maxNumMethod.getOddMaxNo(maxNum1);
        System.out.println(useropinionID1);

        MaxNum maxNo2=new MaxNum("receipts",useropinionID1,2);
        int fh2=maxNumMethod.updateMax(maxNo2);
        return 1;
    }

}
