package com.zhaijisong.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

@Component("eMail")
public class EMail {

    // 发件人的邮箱地址和密码

    public static String sendEmailAccount = "1163054595@qq.com";

    //如果有授权码，此处填写授权码

    public static String sendEmailPassword = "cnxghujdhbiefijj";

    // 发件人邮箱的 SMTP 服务器地址, 可以登录web邮箱查询

    public static String sendEmailSMTPHost = "smtp.qq.com";

    // 收件人邮箱地址
    //public static String receiveMailAccount = "2622323615@qq.com";

    public static void main(String[]args){
      /*try {
          StringBuffer theMessage = new StringBuffer();
          theMessage.append("<h4>晚上好！龚成：</h4>");
          theMessage.append("<p style=\"text-indent: 2em;\">展信佳！当您打开这封邮件的时候,我们已经收到您关于\"+s1[2]+\"的反馈,我们一定会加强培训,提高服务质量。同时便意味着您已经成为了我们宅急送优质服务的对象。</p>\n");
          theMessage.append("<p>感谢您对我们宅急送物流提出宝贵的建议。我们将秉承有则改之,无则加勉原则,提取出广大客户的建议,在我司内部进探讨并用行动证明。让您的建议有参考性、有实用性。</p>\n");
          theMessage.append("<p>在您的生活中有这样一群人,于一日之计载满行囊,驶入车潮的川流不息,穿过街巷的熙熙攘攘,迎着清晨的第一缕阳光叩响您的家门,为您带来足不出户的物流便捷与快乐。</p>\n");
          theMessage.append("<p>做心怀感恩、有爱心、有社会责任感、有正义感的公司，才会让我们走的更远，飞的更高。诚信快递,于口中是时效承诺,于肩上是安全责任,于双手是服务质量,于脚下是\n");
          theMessage.append("<p>派送效率。我们只有把诚信刻在脑中,挂在心上,才能全身联动,出拳有力,双脚生风。诚信速递,我们在路上。诚信经营，我们整装再发！</p>\n");
          theMessage.append("<br/><br/>\n");
          theMessage.append("<p style=\"float: right\">Author:LBJ cheng</p>\n");
          new EMail().Qemail("1526458023@qq.com","hello",theMessage.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/



    }
    public  void Qemail(String receiveMailAccount,String title, String content) throws Exception {
            // 参数配置

            Properties props = new Properties();

            props.setProperty("mail.transport.protocol", "smtp");

            props.setProperty("mail.smtp.host", sendEmailSMTPHost);

            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            props.setProperty("mail.smtp.port", "25");


            props.setProperty("mail.smtp.socketFactory.port", "25");


            // 根据配置创建会话对象, 用于和邮件服务器交互

            Session session = Session.getDefaultInstance(props);

            session.setDebug(true);   // 设置为debug模式, 可以查看详细的发送 log

            Multipart mul=new MimeMultipart();
            //新建一个MimeMultipart对象来存放多个BodyPart对象
            BodyPart mdp=new MimeBodyPart();
            //新建一个存放信件内容的BodyPart对象
            mdp.setContent(content,"text/html;charset=GBK");
            mul.addBodyPart(mdp);

            // 创建一封邮件

            Message message = createMimeMessage(session, sendEmailAccount, receiveMailAccount,title,mul);

            // 根据 Session 获取邮件传输对象

            Transport transport = session.getTransport();

            // 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则会报错

            transport.connect(sendEmailAccount, sendEmailPassword);

            // 发送邮件

            transport.sendMessage(message, message.getAllRecipients());

            // 关闭连接

            transport.close();


    }

    /**

     * 创建一封简单邮件

     */

    private static Message createMimeMessage(Session session, String sendMail, String receiveMail,String title,Multipart mul) throws Exception {

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sendMail));

        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));

        // 设置邮件标题

        message.setSubject(title);

        // 设置邮件正文

        message.setContent(mul);

        message.setSentDate(new Date());

        //保存设置

        message.saveChanges();
        return message;

    }

}
//右击运行此测试程序，控制台打印出"message successfully delivered to mail server"表示发送成功