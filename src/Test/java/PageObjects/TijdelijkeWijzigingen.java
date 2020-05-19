package PageObjects;
import org.openqa.selenium.By;


public class TijdelijkeWijzigingen
{
    //Elementen onder 'Details'
    public static By Naam = By.name("name");
    public static By DatumVan = By.name("timeFrom");
    public static By DatumVanKalender = By.id("x-auto-709");
    public static By VandaagInVanKalender = By.xpath("//button[contains(text(),'Vandaag')]");
    public static By Wegnummer = By.name("mapLocation.fromRoadNumber");
    public static By WegnummerDropdown = By.id("x-auto-722");
    public static By Wegzijde = By.name("mapLocation.fromRoadSide");
    public static By WegzijdeDropdown = By.id("x-auto-724");
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
    public static By VoegPortalenToePlusKnop = By.id("x-auto-1987");
    public static By VoegPortalenToeOkKnop = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");

    //Elementen in menu
    public static By Actualiseren = By.xpath("/html/body/div[1]/div[3]/div[2]/div/table[7]/tbody/tr[1]/td[2]");
    public static By Bewerken = By.xpath("//*[@id='x-auto-588']/tbody/tr[2]/td[2]/em/button");
    public static By Nieuw = By.xpath("//button[contains(text(),'Nieuw')]");

    //Elementen onder 'Objecten'
    public static By EersteBestaandeTijdelijkeWijziging = By.id("x-auto-606_x-auto-786");
    public static By EersteBestaandeTijdelijkeWijzigingNaam = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[2]/div");


}
