package PageObjects;

import org.openqa.selenium.By;

public class Maatregel
{
    //Elementen in menu
    public static By Bewaren = By.xpath("//button[contains(text(),'Bewaren')]");
    public static By Sluiten = By.xpath("//button[contains(text(),'Sluiten')]");
    public static By Beoordelen = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/table[4]/tbody/tr[2]/td[2]/em" +
            "/button");
    public static By SchematischeKaart = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/table[3]/tbody/tr[2]/td[2" +
            "]/em/button");

    public static By Versienummer = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/div[2]/div/label");
    public static By NavigeerNaarVorigeVersie = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/div[2]/div/div[2]");

    //Elementen onder algemene eigenschappen
    public static By Startdatum = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div[1]/div[1]/div/img");
    public static By EinddatumInputfield = By.name("end");
    public static By VandaagInVanKalender = By.xpath("//button[contains(text(),'Vandaag')]");

    public static By WegwerktypeDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[3]/td/div/div[1]/div[1]/div/img");
    public static By Wegbeheerder = By.name("managingDistrict");
    public static By WegbeheerderDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[3]/td/div/div[4]/div[1]/div/img");
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

    public static By MaatregelInTijdvak = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[2]/em/button");

    public static By Status = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[1]/div" +
            "[2]/div[1]/div/div/div/div[1]/table/tbody/tr/td[1]/div/table/tbody/tr[3]/td/div/div[5]/div[1]/div/input[1]");

    //Elementen onder Verkeer
    public static By VerkeershinderklasseDropdown = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[1]/div[1]/div/img");
    public static By Afzetsysteem = By.name("roadblockType");

    public static By CompleteWegafsluitingNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div[2]/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    public static By Dwarsprofiel1 = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div[3]/div[1]/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/em/button/img");
    public static By Dwarsprofiel1PijlOmhoog = By.xpath("/html/body/div[5]/div[2]/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/em/button/img");

    public static By Breedte = By.name("widthConstraint");
    public static By HoogteNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By LengteNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    public static By FilegevoeligNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[7]/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By FilegevoeligJa = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div" +
            "[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[7]/div[1]/div/table/tbody/tr/td[1]/div/input");
    public static By FilegevoeligJaFrame = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[7]/div[1]/div/table/tbody/tr/td[1]/div");
    public static By WeergevoeligNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div[8]/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By SnelheidslimietNee = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div/div[1]/div/table/tbody/tr/td[2]/div/input");

    public static By VerkeersstopTabblad = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[1]/div[1]/ul/li[3]/a[2]/em/span/span");
    public static By VerkeersstopAanmaken = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button/img");
    public static By VerkeersstopWegnummer = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[3]/div");
    public static By VerkeersstopWegzijde = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[4]/div");
    public static By VerkeersstopVanKilometer = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[5]/div/span");

    public static By OmleidingTabblad = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[1]/div[1]/ul/li[4]/a[2]/em/span/span");
    public static By OmleidingToevoegen = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/em/button");
    public static By OmleidingVan = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[2]/div");
    public static By OmleidingTot = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[3]/div");
    public static By VolgRoute = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div[2]/div[1]/form/div/div[3]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[3]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[6]/div");

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

    //Elementen in popups na opslaan
    public static By MaatregelBuitenTIjdvakFase = By.xpath("//button[contains(text(),'Ok')]");
    public static By MaatregelDesondanksOpgeslagen = By.xpath("//button[contains(text(),'Ok')]");

    //Elementen in popup 'Maatregel in tijdvak'
    public static By MaatregelInTijdvakSluiten = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button");
    public static By BekijkMaatregel = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[7]");

    public static By WegnummerConflict = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/form/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/input");
    public static By WegzijdeConflict = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/form/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/input");
    public static By VanKilometerConflict = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/form/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div[1]/div/input");

    //Elementen onder pop-up 'Verkeersstops'
    public static By NieuweVerkeersstop = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[3]/div/table[1]/tbody/tr[2]/td[2]/em/button");
    public static By Datum = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div/img");
    public static By Weg = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[3]/div[1]/div/img");
    public static By Zijde = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[4]/div[1]/div/img");
    public static By Kilometer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[5]/div[1]/div/input");
    public static By Duur = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[6]/div[1]/div/img");
    public static By AantalWISAangevraagd = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[7]/div[1]/div/input");
    public static By AlternatiefMogelijkNee = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[13]/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By ToelichtingAannemer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/form/div/div[14]/div[1]/div/textarea");

    public static By Toepassen = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[3]/div/table[7]/tbody/tr[2]/td[2]/em/button");
    public static By VerkeersstopsSluiten = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[3]/div/table[5]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder popup 'Omleidingen'
    public static By NieuweOmleiding = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button");
    public static By OmleidingAanmakenOmleidingVan = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[5]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingAanmakenOmleidingTot = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[5]/table/tbody/tr/td[5]/div/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By OmleidingWegnummerVan = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[2]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingWegummerVanDropdown = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[2]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By OmleidingWegnummerTot = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[3]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingWegnummerTotDropdown = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[3]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By OmleidingWegzijdeVan = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[2]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingWegzijdeVanDropdown = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[2]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/img");

    public static By OmleidingWegzijdeTot = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingWegzijdeTotDropdown = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By OmleidingVanKilometer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[2]/table/tbody/tr/td[5]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By OmleidingTotKilometer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[3]/table/tbody/tr/td[5]/div/table/tbody/tr/td/div/div/div[1]/div/input");

    public static By OmvangRouteKleinschalig = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[6]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/input");
    public static By SoortRouteAdviesroute = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[7]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/input");
    public static By OmleidingAanmakenVolgRoute = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div[8]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/input");

    public static int SchematischeKaartX = 600;
    public static int SchematischeKaartY = 500;

    public static By OmleidingToepassen = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[3]/div/table[5]/tbody/tr[2]/td[2]/em/button");
    public static By OmleidingSluiten = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[3]/div/table[2]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder 'Zoek filters op omleiding en / of blokkade'
    public static By StandaardOmleidingWegnummerDropdown = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[1]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By StandaardOmleidingWegzijdeDropdown = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By StandaardOmleidingVanKilometer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[3]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By StandaardOmleidingTotKilometer = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div/div[1]/div/input");
    public static By StandaardOmleidingZoeken = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/form/div[2]/table/tbody/tr/td[5]/div/table/tbody/tr/td/div/div/table[2]/tbody/tr[2]/td[2]/em/button");

    public static By GevondenStandaardOmleiding = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/div/div/table/tbody/tr/td[3]/div");
    public static By StandaardOmleidingGebruiken = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");

    public static By BlokkadeLocatie = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div[1]/div/table/tbody/tr/td[2]/div/input");
    public static By StandaardOmleidingRaakvlak = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div/div[1]/div/table/tbody/tr/td[1]/div/input");

    //Elementen onder popup Beoordelen
    public static By BeoordelenSchematischeKaart = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[1]/div/div[2" +
            "]/div/table[3]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder popup Schematische Kaart
    public static By Maatregeldata = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[2]/div[1" +
            "]/label[7]");

    public static By Volgende = By.xpath("//button[contains(text(),'Volgende')]");
    public static By Goedkeuren = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[1]/div/div[2]/div/div" +
            "[3]/table/tbody/tr/td[5]/table/tbody/tr[2]/td[2]/em/button");

    //Elementen onder popup Schematische kaart
    public static By KaartBewerken = By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[2]/div/div[2" +
            "]/div[1]/div/div[1]/input");
    public static By KaartOpslaan = By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div" +
            "[1]/div/table/tbody/tr[2]/td[2]/em/button");
    public static By KaartOpslaanBevestigen = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[2]/div" +
            "/table/tbody/tr[2]/td[2]/em/button");
    public static By KaartOpslaanBevestigenTekst = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div/div/div/div[1" +
            "]/div");

    //In menu
    public static By Pictogrammen  = By.xpath("/html/body/div[1]/div[3]/div[3]/div[4]/div[2]/div[1]/div/div[1]/div[1" +
            "]/ul/li[3]/a[2]/em/span/span");
    public static By ZestigBord = By.xpath("/html/body/div[1]/div[3]/div[3]/div[4]/div[2]/div[1]/div/div[2]/div[2" +
            "]/div/div[1]/div[2]/div[1]/img[11]");

    public static By Informatieborden = By.xpath("/html/body/div[1]/div[3]/div[3]/div[4]/div[2]/div[1]/div/div[2]/div" +
            "[2]/div/div[6]/div[1]/span");
    public static By RechtsInvoegenBord = By.xpath("/html/body/div[1]/div[3]/div[3]/div[4]/div[2]/div[1]/div/div[2" +
            "]/div[2]/div/div[6]/div[2]/div[1]/img[2]");

    //In kaart
    public static By BordPlaatsen = By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div[2]/div[1]/img[1]");

    public static int MatrixSignaalgeverX = 870;
    public static int MatrixSignaalgeverY = 615;

    public static int LocatieOmBordTePlaatsenX = 840;
    public static int LocatieOmBordTePlaatsenY = 530;

    public static int LocatieOmRechtsInvoegenBordTePlaatsenX = 835;
    public static int LocatieOmRechtsInvoegenBordTePlaatsenY = 530;






}
