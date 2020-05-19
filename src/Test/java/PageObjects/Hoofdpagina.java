package PageObjects;

import org.openqa.selenium.By;

public class Hoofdpagina {
    //Configuratiemenu & submenu's
    public static By Configuratie = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]");

    public static By Databeheer = By.id("x-auto-900");

    public static By TijdelijkeWijzigingen = By.xpath("/html/body/div[8]/div/div[2]/a");

    //Uitloggen
    public static By Uitloggen = By.id("x-auto-22");
}
