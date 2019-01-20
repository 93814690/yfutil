package top.liyf.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

/**
 * @author liyf
 * Created in 2019-01-20
 */
public class TestTimeUtil {

    @Test
    public void intervalDays() {

        LocalDate date = LocalDate.of(2019, 1, 20);
        LocalDate date1 = LocalDate.of(2019, 2, 5);
        assertEquals(16, TimeUtil.intervalDays(date, date1));

        ZonedDateTime time = ZonedDateTime.of(date, LocalTime.now(), ZoneIdUtil.get());
        ZonedDateTime time1 = ZonedDateTime.of(date1, LocalTime.MIN, ZoneIdUtil.get());
        assertEquals(16, TimeUtil.intervalDays(time, time1));

    }
}