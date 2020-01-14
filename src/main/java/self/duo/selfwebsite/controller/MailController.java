package self.duo.selfwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import self.duo.selfwebsite.domain.Mail;
import self.duo.selfwebsite.service.MailService;

@Controller
public class MailController {

    @Autowired
    MailService service;

    @ResponseBody
    @GetMapping("/mail/{username}/{address}/{domain}/{summary}")
    public void sendMail(@PathVariable String username, @PathVariable String address, @PathVariable String domain, @PathVariable String summary){
        service.sendSimpleMail(new Mail(username, address, domain, summary));
    }
}
