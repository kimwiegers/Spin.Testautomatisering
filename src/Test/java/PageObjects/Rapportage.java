package PageObjects;

import org.openqa.selenium.By;

public class Rapportage
{
    //Elementen in menu
    public static By VerzendRapportage = By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/table/tbody/tr[2]/td[2" +
            "]/em/button");

    //Elementen onder menu Rapportages
    public static By VerkeersstopsDetails = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div[1]/div[5]/div[1]");

    public static By AlleVerkeersstops = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1" +
            "]/div/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td/div");

    //Elementen onder Opties
    public static By MNDistrictNoord = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div/div/div" +
            "/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/div/div[1]/span/span");

    public static By MNDistrictZuid= By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div/div/div" +
            "/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/div/div[2]/span/span");

    public static By RegioToevoegenAanRapportage = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1" +
            "]/div/div/div/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div");

    public static By StatusGoedgekeurd = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div/div" +
            "/div/div[2]/div[2]/div[1]/form/div[3]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/div/div[4]/span/span");

    public static By StatusToevoegenAanRapportage = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1" +
            "]/div/div/div/div[2]/div[2]/div[1]/form/div[3]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div");

    public static By BegindatumVerkeersstop = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div" +
            "/div/div/div[2]/div[2]/div[1]/form/div[4]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By EinddatumVerkeersstop = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[2]/div[1]/div" +
            "/div/div/div[2]/div[2]/div[1]/form/div[4]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div/div[1]/div/img");

    public static By VandaagInKalender = By.xpath("//button[contains(text(),'Vandaag')]");

    public static int LaatstmogelijkeEinddatumX = 990;
    public static int LaatstMogelijkeEinddatumY = 975;
}
