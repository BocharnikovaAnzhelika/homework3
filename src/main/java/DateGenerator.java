import sun.util.resources.LocaleData;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateGenerator {

        public GregorianCalendar getRandomBirthday() {

            GregorianCalendar gc = new GregorianCalendar();

            int year = randBetween(1900, 1999);

            gc.set(gc.YEAR, year);

            int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

            gc.set(gc.DAY_OF_YEAR, dayOfYear);

            System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));

            return gc;
        }

        private int randBetween(int start, int end) {
            return start + (int)Math.round(Math.random() * (end - start));
        }

        public int getAge(GregorianCalendar birthday) {
            GregorianCalendar today = new GregorianCalendar();
//            GregorianCalendar bday = new GregorianCalendar();
            GregorianCalendar bdayThisYear = new GregorianCalendar();

//            bday.setTime(birthday);
//            bdayThisYear.setTime(birthday);
            bdayThisYear.set(Calendar.YEAR, today.get(Calendar.YEAR));

            int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

            if(today.getTimeInMillis() < bdayThisYear.getTimeInMillis())
                age--;

            return age;
        }
}
