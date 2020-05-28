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

    public String GetDatumInToekomstFormatInvoerveld(int aantalDagenInDeToekomst)
    {
        Calendar kalender = Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"));
        kalender.add(Calendar.DAY_OF_YEAR, 7);
        int dag = kalender.get(Calendar.DAY_OF_MONTH);
        int maand = kalender.get(Calendar.MONTH);
        maand += 1;
        int jaar = kalender.get(Calendar.YEAR);

        return dag + "." + maand + "." + jaar + ", 12:00";
    }
}
