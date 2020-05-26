package PageObjects;

import org.openqa.selenium.By;

public class Werk
{
    //Elementen in Menu
    public static By Verkeershinder = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/ul/li[2]/a[2]/em/span/span");

    public static By Bewaren = By.xpath("//button[contains(text(),'Bewaren')]");
    public static By Sluiten = By.xpath("//button[contains(text(),'Sluiten')]");

    //Elementen onder Eigenschappen
    public static By Startdatum = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/div[2]/div[1]/div/img");
    public static By Einddatum = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/div/div[1]/div/img");
    public static By VandaagInVanKalender = By.xpath("//button[contains(text(),'Vandaag')]");
    public static int LaatstMogelijkeEinddatumX = 575;
    public static int LaatstMogelijkeEinddatumY = 910;

    public static By AanvragendeDienstDropdown = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[1]/div/div/div/div[1]/div/img");
    public static int MiddenNederlandX = 260;
    public static int MiddenNederlandY = 490;

    public static By KorteProjectNaam = By.name("description");

    public static By SoortWerk = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[3]/td/div/div/div[2]/div[1]/div/img");
    public static int AanlegAansluitingX = 260;
    public static int AanlegAansluitingY = 530;

    public static By Werkzaamheden = By.name("activities");

    public static By OpenBesteknummers = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[4]/td/div/table/tbody/tr/td/div/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button/img");

    public static By WegnummerVan = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[3]/div/table/tbody/tr[3]/td/div/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/img");
    public static int VanA12X = 630;
    public static int VanA12Y = 690;

    public static By Wegzijde = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[3]/div/table/tbody/tr[3]/td/div/div/div/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/img");
    public static int RechtsX = 650;
    public static int RechtsY = 560;

    public static By VanKilometer = By.name("location.fromMeter");

    public static By WegnummerTot = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[3]/div/table/tbody/tr[3]/td/div/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[1]/div[1]/div/img");
    public static int TotA12X = 1000;
    public static int TotA12Y = 690;

    public static By WegzijdeTot = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td[3]/div/table/tbody/tr[3]/td/div/div/div/table/tbody/tr/td[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[2]/div[1]/div/img");
    public static int TotRechtsX = 1000;
    public static int TotRechtsY = 560;

    public static By TotKilometer = By.name("location.toMeter");

    //Elementen onder Besteknummer pop-up
    public static By EersteBesteknummer = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div/div[2]/div[1]/form/div/div[1]/table/tbody/tr/td[1]/div/div/div[1]");
    public static By VoegBesteknummerToe = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div/div[2]/div[1]/form/div/div[1]/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/div");
    public static By BevestigBesteknummer = By.xpath("//button[contains(text(),'Ok')]");

    //Elementen onder 'Verkeershinder'
    public static By HinderperiodeVan = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/div/div/div[1]/div/img");
    public static By HinderperiodeTot = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/div/div[1]/div/img");
    public static int LaatstMogelijkeHinderperiodeX = 495;
    public static int LaatstMogelijkeHinderperiodeY = 870;

    public static By VerkeershinderCategorie = By.xpath("/html/body/div[1]/div[3]/div[3]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/div/div/div[2]/div[1]/div/img");
    public static int CategorieDCoordinaatX = 290;
    public static int CategorieDCoordinaatY = 850;
}
