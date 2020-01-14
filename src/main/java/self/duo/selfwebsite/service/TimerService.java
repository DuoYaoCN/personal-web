package self.duo.selfwebsite.service;
import self.duo.selfwebsite.domain.RemainTime;

import java.text.ParseException;

public interface TimerService {
    RemainTime getTime() throws ParseException;
}
