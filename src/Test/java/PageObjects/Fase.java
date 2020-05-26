package PageObjects;

import org.openqa.selenium.By;

public class Fase
{
    //Elementen in menu
    public static By Verkeershinder = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/ul/li[2]/a[2]/em/span/span");
    public static By Achtergrondinformatie = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/ul/li[3]/a[2]/em/span/span");

    //Elementen onder Eigenschappen
    public static By Naam = By.name("name");

    public static By TijdslotVanToepassingNee = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[3]/div/table/tbody/tr[1]/td/div/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    //Elementen onder Verkeershinder
    public static By Verkeershinderklasse = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div/div[1]/div[1]/div/img");
    public static int Hinderklasse0CoordinaatX = 210;
    public static int Hinderklasse0CoordinaatY = 900;

    public static By VerkeershinderCategorie = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div/div[2]/div[1]/div/img");
    public static int HindercategorieACoordinaatX = 500;
    public static int HindercategorieACoordinaatY = 900;
}
