package Services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;

public class DatesAndTimesService
{
    public String GetCurrentDateWithoutTime()
    {
        Calendar kalender = Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"));
        int huidigeDag = kalender.get(Calendar.DAY_OF_MONTH);
        int huidigeMaand = kalender.get(Calendar.MONTH) + 1;
        int huidigJaar = kalender.get(Calendar.YEAR);

        return (huidigeDag + "." + huidigeMaand + "." + huidigJaar);
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

    public LocalDate TransformStringIntoDate(String dateTime)
    {
        String[] dateAndTimeSeparated = dateTime.split(",");
        String date = dateAndTimeSeparated[0];
        String[] dayMonthYear = date.split("\\.");
        int day = Integer.parseInt(dayMonthYear[0]);
        int month = Integer.parseInt(dayMonthYear[1]);
        int year = Integer.parseInt(dayMonthYear[2]);

        return LocalDate.of(year, month, day);
    }
}
