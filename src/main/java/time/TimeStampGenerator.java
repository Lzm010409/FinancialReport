package time;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeStampGenerator {

    public int generateTimestamp(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month - 1, day);
        Timestamp timestamp = new Timestamp((calendar.getTime()).getTime());
        return (int) (timestamp.getTime() / 1000);
    }
}
