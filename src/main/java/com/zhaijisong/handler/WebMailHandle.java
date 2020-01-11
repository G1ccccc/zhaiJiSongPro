package com.zhaijisong.handler;

import com.zhaijisong.dao.impl.ExcelDemoDaoImpl;
import com.zhaijisong.dao.impl.WebMailDaoImpl;
import com.zhaijisong.pojo.ExcelDemo;
import com.zhaijisong.pojo.MaxNum;
import com.zhaijisong.pojo.UserMsg;
import com.zhaijisong.util.EMail;
import com.zhaijisong.util.MaxNumMethod;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("webMailHandle")
public class WebMailHandle {
    @Resource(name = "webMailDaoImpl")
    private WebMailDaoImpl webMailDaoImpl = null;
    public void setExcelDemoDaoImpl(WebMailDaoImpl webMailDaoImpl) {
        this.webMailDaoImpl = webMailDaoImpl;
    }

    @Resource(name = "maxNumMethod")
    private MaxNumMethod maxNumMethod = null;
    public void setMaxNumMethod(MaxNumMethod maxNumMethod) {
        this.maxNumMethod = maxNumMethod;
    }

    @Resource(name = "eMail")
    private EMail eMail = null;
    public void setEMail(EMail eMail) {
        this.eMail = eMail;
    }

    @RequestMapping(value = "/user_msg.action",method = RequestMethod.POST)
    public @ResponseBody int getExcelList1(String msg) throws UnsupportedEncodingException {
        //解决中文乱码
        try {
            msg = new String(msg.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //获取用户反馈表普通主键
        MaxNum maxNum =new MaxNum("useropinion",0);
        String useropinionID=maxNumMethod.getPuMaxNo(maxNum);
        //获取用户反馈信息 用户信息
        final String[] s1=msg.split(" ");
        //保存至数据库
        UserMsg userMsg =new UserMsg(useropinionID,s1[0],s1[1],s1[2],new Timestamp((new Date()).getTime()),"测试");
        try {
            //发送管理员
            eMail.Qemail("1526458023@qq.com","来自"+s1[0]+"的反馈",s1[2]);
            //回复客户(定时10秒)
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run(){
                    replayUser(s1);
                }
            };
            timer.schedule(task, 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int fh=webMailDaoImpl.insertUserMasg(userMsg);
        if(fh!=0){
            //更改销售单据明细表 普通主键ID
            MaxNum maxNo1=new MaxNum("useropinion",userMsg.getOpId(),0);
            int fh1=maxNumMethod.updateMax(maxNo1);
        }
        return fh;
    }
    public void replayUser(String[] s1){
        //获取当前时间(时)
        int nowTime =Integer.valueOf((new Date().getHours() < 10 ? "0" + new Date().getHours() : new Date().getHours()).toString());
        //拼接回复信息
        StringBuffer replymsg = new StringBuffer();
        //判断问候语
        if(nowTime>12&&nowTime<19){
            replymsg.append("<h4>下午好！"+s1[0]+"：</h4>");
        }else if (nowTime>0&&nowTime<12){
            replymsg.append("<h4>上午好！"+s1[0]+"：</h4>");
        }else{
            replymsg.append("<h4>晚上好！"+s1[0]+"：</h4>");
        }
        replymsg.append("<p style=\"text-indent: 2em;\">展信佳！当您打开这封邮件的时候,我们已经收到您关于"+s1[2]+"的反馈,我们一定会加强培训,提高服务质量。同时便意味着您已经成为了我们宅急送优质服务的对象。</p>\n");
        replymsg.append("<p>感谢您对我们宅急送物流提出宝贵的建议。我们将秉承有则改之,无则加勉原则,提取出广大客户的建议,在我司内部进探讨并用行动证明。让您的建议有参考性、有实用性。</p>\n");
        replymsg.append("<p>在您的生活中有这样一群人,于一日之计载满行囊,驶入车潮的川流不息,穿过街巷的熙熙攘攘,迎着清晨的第一缕阳光叩响您的家门,为您带来足不出户的物流便捷与快乐。</p>\n");
        replymsg.append("<p>做心怀感恩、有爱心、有社会责任感、有正义感的公司，才会让我们走的更远，飞的更高。诚信快递,于口中是时效承诺,于肩上是安全责任,于双手是服务质量,于脚下是\n");
        replymsg.append("<p>派送效率。我们只有把诚信刻在脑中,挂在心上,才能全身联动,出拳有力,双脚生风。诚信速递,我们在路上。诚信经营，我们整装再发！</p>\n");
        replymsg.append("<br/><br/>\n");
        replymsg.append("<p style=\"float: right\">Author:G1ccccc</p>\n");
        try {
            eMail.Qemail(s1[1],"宅急送",replymsg.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@RequestMapping(value = "/user_msg1.action",method = RequestMethod.POST)
    public @ResponseBody int getExcelList() throws UnsupportedEncodingException {
        Map<String, String[]> map = request.getParameterMap();
        //获取表单中特定的参数也可以根据表单中对应输入框的id进行取值
        String check = request.getParameter("check");
        return 1;
    }*/
}
