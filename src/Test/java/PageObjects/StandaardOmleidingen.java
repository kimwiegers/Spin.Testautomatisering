package PageObjects;

import org.openqa.selenium.By;

public class StandaardOmleidingen
{
    public static By Nieuw = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder Omleidingsgegevens
    public static By BlokkadeStartpuntDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By BlokkadeEindpuntDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[3]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By BlokkadeWegzijdeVanDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By BlokkadeWegzijdeTotDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[3]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By BlokkadeVanKilometer = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By BlokkadeTotKilometer = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[3]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");

    public static By OmleidingStartpuntDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[5]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingEindpuntDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[6]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingWegzijdeVanDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[5]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingWegzijdeTotDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[6]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingVanKilometer = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[5]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingTotKilometer = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[6]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingVanPlekDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[7]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingTotPlekDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/form/div/div[1]/div[7]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By Bewaren = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[4]/div/table[4]/tbody/tr[2]/td[2]/em/button");

    public static By FoutmeldingNaOpslaan = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder Zoek filters op Omleidig en/of blokkade
    public static By FilterOmleidingWegnummerDropdown = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/div/table/tbody/tr/td/div/div[2]/div[1]/form/div[2]/div/div[1]/div[1]/div/img");
    public static By FilterOmleidingWegzijde = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/div/table/tbody/tr/td/div/div[2]/div[1]/form/div[2]/div/div[2]/div[1]/div/img");
    public static By FilterOmleidingVanKilometer = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/div/table/tbody/tr/td/div/div[2]/div[1]/form/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td/div/div/div[1]/div[1]/div/input");
    public static By FilterOmleidingTotKilometer = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/div/table/tbody/tr/td[1]/div/div/div/table/tbody/tr/td/div/div[2]/div[1]/form/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td/div/div/div[2]/div[1]/div/input");

    public static By Zoeken = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[2]/div[1]/form/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td[2]/em/button");

    public static int DatumVanLaatstebewerkingDropdownX = 1128;
    public static int DatumVanLaatsteBewerkingDropdownY = 280;

    public static By GevondenOmleidingVanPlek = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[7]/div");
    public static By GevondenOmleidingTotPlek = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[8]/div");

    public static By GeenGevondenOmleidingen = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div");
}
