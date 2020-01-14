package self.duo.selfwebsite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import self.duo.selfwebsite.domain.RemainTime;
import self.duo.selfwebsite.service.TimerService;


import java.text.ParseException;


@Controller
public class TimerController {

    @Autowired
    private TimerService service;

    @GetMapping("/time")
    @ResponseBody
    public RemainTime getTime() throws ParseException {
        return service.getTime();
    }

    @GetMapping("/404")
    public String get_404(){
        return "404";
    }
}
