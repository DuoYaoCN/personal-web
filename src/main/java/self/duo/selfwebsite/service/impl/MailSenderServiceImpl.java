package self.duo.selfwebsite.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import self.duo.selfwebsite.domain.Mail;
import self.duo.selfwebsite.service.MailService;

import javax.mail.internet.MimeMessage;

@Service
public class MailSenderServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Override
    public void sendSimpleMail(Mail mail) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try{
            messageHelper = new MimeMessageHelper(message, true); //true表示支持复杂类型
            messageHelper.setFrom(mail.getSendFrom());//邮件发信人
            messageHelper.setTo(mail.getSendTo());//邮件收信人
            messageHelper.setSubject(mail.getDomain());//邮件主题
            String messageTest = "发信:\t" + mail.getUsername() + "\n邮箱:\t" + mail.getAddress() + "\n\n\n" + mail.getSummary();
            messageHelper.setText(messageTest);//邮件内容
            mailSender.send(messageHelper.getMimeMessage());//正式发送邮件
            logger.info("用户\t" + mail.getUsername() + "\t邮件发送成功");
        } catch (Exception e) {
            logger.error("==========ERROR==========");
            logger.error("用户" + mail.getUsername() + "邮件发送失败");
            logger.error(e.getMessage());
            logger.error("=========================");
        }
    }
}
