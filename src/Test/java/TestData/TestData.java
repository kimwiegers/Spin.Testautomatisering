package TestData;

import java.io.File;

public class TestData
{
    public static String Testomschrijving = "Testautomation Test";

    private String tijdelijkeWijzigingNaam;
    private File Exportbestand;
    private String Regio;

    public void setTijdelijkeWijzigingNaam(String tijdelijkeWijzigingNaam){
        this.tijdelijkeWijzigingNaam = tijdelijkeWijzigingNaam;
    }

    public String getTijdelijkeWijzigingNaam(){
        return this.tijdelijkeWijzigingNaam;
    }

    public String getRegio()
    {
        return this.Regio;
    }

    public void setExportbestand(File TijdelijkeWijzigingExportbestand){
        this.Exportbestand = TijdelijkeWijzigingExportbestand;
    }

    public File getExportbestand( )
    {
        return this.Exportbestand;
    }

    public void setRegio(String regio)
    {
        this.Regio = regio;
    }
}
