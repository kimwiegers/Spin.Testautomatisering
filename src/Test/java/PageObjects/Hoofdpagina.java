package PageObjects;

import org.openqa.selenium.By;

public class Hoofdpagina {
    //Configuratiemenu & submenu's
    public static By Configuratie = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]");

    public static By Databeheer = By.id("x-auto-900");

    public static By TijdelijkeWijzigingen = By.xpath("/html/body/div[8]/div/div[2]/a");

    //Bestand menu en submenu's
    public static By Bestand = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div[1]");
    public static int BestandX = 55;
    public static int BestandY = 190;

    //Uitloggen
    public static By Uitloggen = By.id("x-auto-22");

    //Menu onderin het scherm
    public static By LaatstePagina = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[9]/table/tbody/tr[2]/td[2]/em/button/img");

    //Elementen in overzicht tabel
    public static By EersteWerkOpLaatstePagina = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]");
    public static By KorteProjectNaam = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[4]/div/span");

    public static By Opgeslagen = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div/div/table/tbody/tr/td[6]/div/span");

    //Elementen in context menu
    public static By VerwijderWerk = By.xpath("/html/body/div[6]/div[2]/div[14]/a");

    //Elementen oder popup 'Werkelijk verwijderen'
    public static By BevestigVerwijderenWerk = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");

}
