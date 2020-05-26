package PageObjects;
import org.openqa.selenium.By;


public class TijdelijkeWijzigingen
{
    //Elementen onder 'Details'
    public static By Naam = By.name("name");
    public static By DatumVan = By.name("timeFrom");
    public static By DatumVanKalender = By.id("x-auto-709");
    public static By DatumTotKalender = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/form/div/div[1]/div[2]/div[1]/form/div/div/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr/td/div/div[4]/div[1]/div/img");
    public static By VandaagInVanKalender = By.xpath("//button[contains(text(),'Vandaag')]");

    public static By Wegnummer = By.name("mapLocation.fromRoadNumber");
    public static int WegnummerX = 831;
    public static int WegnummerY = 500;

    public static By WegnummerDropdown = By.id("x-auto-722");
    public static By Wegzijde = By.name("mapLocation.fromRoadSide");

    public static int WegzijdeDropdownX = 925;
    public static int WegzijdeDropdownY = 320;
    public static int WegzijdeRechtsX = 860;
    public static int WegzijdeRechtsY = 350;

    public static By VanKilometer = By.name("mapLocation.fromMeter");
    public static By TotKilometer = By.name("mapLocation.toMeter");

    public static By ZoekLocatie = By.xpath("//button[contains(text(),'Zoek locatie')]");

    //Elementen onder 'Brondata situatie'
    public static By RijstrokenBestaand = By.name("FLD_LLO_SD");
    public static By PortalenBestaand = By.name("FLD_MTM_SD");

    //Elementen in schematische kaart onder 'Bron situatie'
    public static By ZoomUitKnop = By.xpath("//*[@id='OpenLayers.Control.PanZoomBar_969_zoomout_innerImage']");
    public static By MiddelsteKilometerSchaalAanduider = By.xpath("//*[@id='OpenLayers.Control.ScaleBar_467']/div/div[3]/div[2]");
    public static By LaatsteKilometerSchaalAanduider = By.xpath("//*[@id='OpenLayers.Control.ScaleBar_467']/div/div[3]/div[3]");

    //Elementen onder 'Tijdelijke Wijzigingssituatie'
    public static By RijstrokenNieuw = By.name("laneLayout");
    public static By Signaalgevers = By.name("signalPosts");
    public static By Beschrijving = By.name("description");

    public static int PortalenPlusKnopX = 1425;
    public static int PortalenPlusKnopY = 575;

    public static int PortalenOkKnopX = 900;
    public static int PortalenOkKnopY = 630;

    //Elementen in menu
    public static By Actualiseren = By.xpath("/html/body/div[1]/div[3]/div[2]/div/table[7]/tbody/tr[1]/td[2]");
    public static By Bewerken = By.xpath("//*[@id='x-auto-588']/tbody/tr[2]/td[2]/em/button");
    public static By Nieuw = By.xpath("//button[contains(text(),'Nieuw')]");
    public static By Bewaren = By.xpath("/html/body/div[1]/div[3]/div[2]/div/table[8]/tbody/tr[2]/td[2]/em/button");
    public static By Verwijderen = By.xpath("/html/body/div[1]/div[3]/div[2]/div/table[3]/tbody/tr[2]/td[2]/em/button");
    public static By Exporteren = By.xpath("//*[@id='x-auto-591']/tbody/tr[2]/td[2]/em/button");

    //Elementen onder 'Objecten'
    public static By EersteBestaandeTijdelijkeWijziging = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[2]/div");
    public static By EersteBestaandeTijdelijkeWijzigingNaam = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[2]/div");

    public static By NieuweWijziging = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[2]/div");

    //Elementen in menu onder 'Objecten'
    public static int DatumVanDropdownX = 249;
    public static int DatumVanDropdownY = 250;

    public static int DatumVanAflopendSorterenX = 260;
    public static int DatumVanAflopendSorterenY = 302;

    //Elementen in pop-up 'Betrokken Maatregelen'
    public static By BetrokkelMaatregelenPopup = By.id("x-auto-15716");
    public static int BetrokkenMaatregelenAccepterenX = 1150;
    public static int BetrokkenMaatregelenAccepterenY = 825;

    //Elementen in pop-up 'Werkelijk verwijderen?'
    public static int MaatregelVerwijderenX = 1100;
    public static int MaatregelVerwijderenY = 720;

    //Elementen in pop-up 'Check maximaal toonbaar bereik'
    public static By MaximaalKilometrageTekst = By.xpath("//*[@id='x-auto-8284']/tbody");

    //Elementen in popup 'Exporteren'
    public static By BestandsformaatDropdown = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[1]/div/div[2]/div[1]/form/div/table/tbody/tr/td/div/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div/div[1]/div/img");
    public static By ExporterenOk = By.xpath("//button[contains(text(),'Ok')]");

    public static int XlsX = 920;
    public static int XlsY = 630;
    public static int CsvX = 910;
    public static int CsvY = 580;

    //Elementen onder Filter
    public static By FilterWegnummerDropdown = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div[1]/div[1]/div/img");
    public static int FilterA12X = 200;
    public static int FilterA12Y = 670;

    public static By FilterWegzijdeDropdown = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[4]/div/table/tbody/tr/td/div/div[2]/div[1]/div/img");
    public static int FilterRechtsX = 200;
    public static int FilterRechtsY = 530;

    public static By FilterZoeken = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div[1]/table/tbody/tr[2]/td[2]/em/button");
}