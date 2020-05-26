package TestData;

import java.io.File;

public class TestData
{
    public static String Testomschrijving = "Testautomation Test";

    private String tijdelijkeWijzigingNaam;
    private File tijdelijkeWijzigingExportbestand;

    public void setTijdelijkeWijzigingNaam(String tijdelijkeWijzigingNaam){
        this.tijdelijkeWijzigingNaam = tijdelijkeWijzigingNaam;
    }

    public String getTijdelijkeWijzigingNaam(){
        return this.tijdelijkeWijzigingNaam;
    }

    public void setTijdelijkeWijzigingExportbestand(File TijdelijkeWijzigingExportbestand){
        this.tijdelijkeWijzigingExportbestand = TijdelijkeWijzigingExportbestand;
    }

    public File getTijdelijkeWijzigingExportbestand( )
    {
        return this.tijdelijkeWijzigingExportbestand;
    }
}
