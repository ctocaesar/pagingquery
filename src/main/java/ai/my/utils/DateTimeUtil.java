package ai.my.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static String getSysTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String dateStr = sdf.format(date);

        return dateStr;

    }

    public static String getRandomTime(String startTime, String endTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        long start = 0L;
        long end = 0L;

        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
        start = calendar.getTimeInMillis();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
        end = calendar.getTimeInMillis();

        long millisecond = (long) (Math.random() * (end - start) + start);
        Date dateTime = new Date(millisecond);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dateTime);
    }

}
