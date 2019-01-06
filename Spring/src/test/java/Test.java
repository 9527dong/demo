 import javax.sound.midi.Soundbank;
 import java.time.LocalDate;
 import java.time.ZoneId;
 import java.time.temporal.TemporalAdjusters;
 import java.util.*;

 public class Test {
    public static void main(String[] args) throws Exception {
        LocalDate todaydate = LocalDate.now();
//        Date date = Date.from(todaydate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        System.out.println(cal.getTime());
        System.out.println("Months first date in yyyy-mm-dd: " +LocalDate.now()
                .with( TemporalAdjusters.firstDayOfMonth() )
        );

    }

      
}  