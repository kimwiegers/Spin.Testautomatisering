package Services;

import java.util.Calendar;
import java.util.TimeZone;

public class DatesAndTimesService
{
    public String GethuidigeDatumFormatInvoerveld()
    {
        Calendar kalender = Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"));
        int huidigeDag = kalender.get(Calendar.DAY_OF_MONTH);
        int huidigeMaand = kalender.get(Calendar.MONTH);
        int huidigJaar = kalender.get(Calendar.YEAR);

        return (huidigeDag + "." + huidigeMaand + "." + huidigJaar + ", 12:00").toString();
    }
}
