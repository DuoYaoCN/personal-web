package self.duo.selfwebsite.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RemainTime {

    private long day;
    private long hour;
    private long minute;
    private long second;

    private Date date;

    public RemainTime() throws ParseException {
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-18 08:30:00");
    }

    public RemainTime(long day, long hour, long min, long  sec) throws ParseException {
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-18 08:30:00");
        this.setDay(day);
        this.setHour(hour);
        this.setMinute(min);
        this.setSecond(sec);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDay() {
        return day;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }


    public void setDay(long day) {
        this.day = day;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public void setMinute(long minute) {
        this.minute = minute;
    }

    public void setSecond(long second) {
        this.second = second;
    }


}
