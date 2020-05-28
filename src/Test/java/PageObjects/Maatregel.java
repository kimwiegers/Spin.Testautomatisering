package PageObjects;

import org.openqa.selenium.By;

public class Maatregel
{
    //Elementen in menu
    public static By Bewaren = By.xpath("//button[contains(text(),'Bewaren')]");
    public static By Sluiten = By.xpath("//button[contains(text(),'Sluiten')]");

    //Elementen onder algemene eigenschappen
    public static By Startdatum = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div[1]/div[1]/div/img");
    public static By Einddatum = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div[2]/div[1]/div/img");
    public static By EinddatumInputfield = By.name("end");
    public static By VandaagInVanKalender = By.xpath("//button[contains(text(),'Vandaag')]");
    public static int LaatstMogelijkeEinddatumX = 575;
    public static int LaatstMogelijkeEinddatumY = 910;

    public static By Wegwerktype = By.name("roadworkType");
    public static By WegwerktypeDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[3]/td/div/div[1]/div[1]/div/img");
    public static By Wegbeheerder = By.name("managingDistrict");
    public static By WegbeheerderDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[3]/td/div/div[4]/div[1]/div/img");
    public static By Besteknummer = By.name("bestekId");
    public static By BesteknummerDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By VanWegnummer = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/input");
    public static By TotWegnummer = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/input");
    public static By VanWegnummerDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/img");
    public static By TotWegnummerDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/img");

    public static By VanWegzijde = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/input");
    public static By TotWegzijde = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/input");
    public static By VanWegzijdeDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/img");
    public static By TotWegzijdeDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/img");

    public static By VanKilometer = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div[1]/div/input");
    public static By TotKilometer = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div[1]/div/input");

    public static By ToonRoute = By.xpath("//button[contains(text(),'Toon route')]");

    //Elementen onder Verkeer
    public static By Verkeershinderklasse = By.name("trafficHindranceClass");
    public static By VerkeershinderklasseDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[1]/div[1]/div/img");
    public static By Afzetsysteem = By.name("roadblockType");

    public static By CompleteWegafsluitingNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    public static By Dwarsprofiel1 = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div[3]/div[1]/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/em/button/img");
    public static By Dwarsprofiel1PijlOmhoog = By.xpath("/html/body/div[5]/div[2]/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/em/button/img");

    public static By Breedte = By.name("widthConstraint");
    public static By HoogteNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By LengteNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    public static By FilegevoeligNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[7]/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By WeergevoeligNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[8]/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By SnelheidslimietNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    //Elementen onder aannemer
    public static By Verkeersloket = By.name("trafficDesk");
    public static By VerkeersloketDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[1]/div[1]/div/img");

    public static By OpmerkingToevoegen = By.xpath("//button[contains(text(),'Toevoegen')]");

    //Elementen in popup 'Opmerking toevoegen'
    public static By OpmerkingInput = By.name("content");
    public static By OpmerkingToevoegenOk = By.xpath("//button[contains(text(),'Ok')]");

    //Elementen in popup 'Locatie bewerken'
    public static By ZoomOut = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div[2]/div[8]/img");

    public static By LocatieBewerkenVanWegnummer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/form/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/input");
    public static By EindPuntPlaatsen = By.xpath("/html/body/div[8]/div/div[8]/a");

    public static By LocatieOpslaan = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");
}
