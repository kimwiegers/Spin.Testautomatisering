package PageObjects;

import org.openqa.selenium.By;

public class Fase
{
    //Elementen in menu
    public static By Verkeershinder = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/ul/li[2]/a[2]/em/span/span");
    public static By Achtergrondinformatie = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/ul/li[3]/a[2]/em/span/span");

    public static By Bewaren = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[2]/div/table[3]/tbody/tr[2]/td[2]/em/button");
    public static By Sluiten = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[2]/div/table[4]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder Eigenschappen
    public static By Naam = By.name("name");

    public static By TijdslotVanToepassingNee = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[3]/div/table/tbody/tr[1]/td/div/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    //Elementen onder Verkeershinder
    public static By Verkeershinderklasse = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div/div[1]/div[1]/div/img");
    public static int Hinderklasse0CoordinaatX = 210;
    public static int Hinderklasse0CoordinaatY = 730;

    public static By VerkeershinderCategorie = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div/div[2]/div[1]/div/img");
    public static int HindercategorieACoordinaatX = 210;
    public static int HindercategorieACoordinaatY = 750;

    //Elementen onder Achtergrondinformatiie
    public static By Wat = By.xpath(" /html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[3]/div/div[2]/div[1]/form/div/div[2]/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/div/div[1]/div[1]/div/img");
    public static int GrootschaligeWerkzaamhedenX = 210;
    public static int GrootschaligeWerkzaamhedenY = 780;
}
