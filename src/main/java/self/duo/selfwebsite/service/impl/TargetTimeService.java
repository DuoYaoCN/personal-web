package self.duo.selfwebsite.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import self.duo.selfwebsite.domain.RemainTime;
import self.duo.selfwebsite.service.TimerService;
import java.util.Date;


@Service
public class TargetTimeService implements TimerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public RemainTime getTime(){
        RemainTime time;
        try{
            time = new RemainTime();
            Date date = time.getDate();
            Date parse = new Date();
            long between = date.getTime() - parse.getTime();
            long day = between / (24 * 60 * 60 * 1000);
            long hour = (between / (60 * 60 * 1000) - day * 24);
            long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            logger.info("获取剩余时间成功");
            return new RemainTime(day, hour, min, s);
        }
        catch (Exception e){
            logger.error("==========ERROR==========");
            logger.error("获取时间失败");
            logger.error(e.getMessage());
            logger.error("=========================");
            return null;
        }
    }
}
