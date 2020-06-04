package PageObjects;

import org.openqa.selenium.By;

public class Hoofdpagina {
    //Configuratiemenu & submenu's
    public static By Configuratie = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]");

    public static int BestandX = 55;
    public static int BestandY = 190;

    public static By Overzicht = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div[2]");

    public static By Extra = By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div[3]");

    //Filters
    public static By RegioDropdown = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div" +
            "[1]/form/div/div/div[1]/div/div[1]/div/img");
    public static By ModusDropdown = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div" +
            "[1]/form/div/div/table/tbody/tr[2]/td[2]/em");

    public static By ActiefVan = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div[1" +
            "]/form/div/div/div[2]/div/div[1]/div/input");
    public static By ActiefVanDropdown = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2" +
            "]/div[1]/form/div/div/div[2]/div/div[1]/div/img");

    public static By ActiefTot = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div[1" +
            "]/form/div/div/div[3]/div/div[1]/div/input");
    public static By ActiefTotDropdown = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[2" +
            "]/div[1]/form/div/div/div[3]/div/div[1]/div/img");

    public static By VandaagInKalender = By.xpath("//button[contains(text(),'Vandaag')]");
    public static By FilterToepassen = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/table[2" +
            "]/tbody/tr[2]/td[2]/em/button");
    public static By FilterWissen = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/div/div/table[3]/tbody" +
            "/tr[2]/td[2]/em/button");

    public static By StartMaatregel = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");

    public static By BeeindigMaatregel = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/table[2]/tbody/tr[2" +
            "]/td[2]/em/button");

    public static By ZetMaatregelOpNietUitgevoerd = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div/table[3" +
            "]/tbody/tr[2]/td[2]/em/button");

    //Elementen onder popup 'Maatregel niet uitgevoerd'
    public static By OpmerkingenveldMaatregelNietUitgevoerd = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div" +
            "/div/div[1]/div/div[2]/div[1]/form/div[2]/div[1]/div/textarea");

    public static By MaatregelNietUitgevoerdBevestiging = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div" +
            "/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");

    public static By FoutmeldingMaatregelStartenInHetVerleden = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div" +
            "/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button");

    //Uitloggen
    public static By Uitloggen = By.id("x-auto-22");

    //Menu onderin het scherm
    public static By LaatstePagina = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[9]/table/tbody/tr[2]/td[2]/em/button/img");

    //Elementen in overzicht tabel
    public static By EersteWerkOpLaatstePagina = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]");
    public static By KorteProjectNaam = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[4]/div/span");
    public static By FaseNaam = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[3]/div");
    public static int FaseX = 200;
    public static int FaseY = 30;

    public static By KlapEersteWerkOpEerstePaginaOpen = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]/div/div/div/img[2]");
    public static By EersteFaseOnderEersteWerkEerstePagina = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div/div/span[2]");
    public static int EersteFaseOnderEersteWerkEerstePaginaX = 200;
    public static int EersteFaseOnderEersteWerkEerstePaginaY = 310;
    public static By KlapEersteFaseOnderEersteWerkOpen = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div/div/img[2]");
    public static int KlapEersteFaseOnderEersteWerkOpenX = 35;
    public static int KlapEersteFaseOnderEersteWerkOpenY = 310;
    public static int EersteMaatregelOnderEersteFaseX = 200;
    public static int EersteMaatregelOnderEersteFaseY = 330;

    public static By EersteMaatregelStatus = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div" +
            "/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[24]/div/span");

    public static By KlapMaatregelInformatieOpen = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div/div/img[2]");
    public static By MaatregelWegVan = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[12]/div");
    public static By MaatregelSoortWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[23]/div/span");

    public static By Opgeslagen = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div/div/table/tbody/tr/td[6]/div/span");

    public static By BegindatumEersteWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div" +
            "/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[7]/div");
    public static By EinddatumEersteWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div" +
            "[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[8]/div");
    public static By AanvragendeDienstEersteWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1" +
            "]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[27]/div");

    public static By BegindatumTweedeWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div" +
            "/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[7]/div");
    public static By EinddatumTweedeWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div" +
            "[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[8]/div");
    public static By AanvragendeDienstTweedewerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1" +
            "]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[27]/div");

    public static By BegindatumDerdeWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div" +
            "[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[7]/div");
    public static By EinddatumDerdeWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div" +
            "[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[8]/div");
    public static By AanvragendeDienstDerdeWerk = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1" +
            "]/div/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[27]/div");

    public static By EersteMaatregelIcoon = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div" +
            "/div[1]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[1]/div/div/div/img[3]");

    //Elementen in context menu
    public static By VerwijderWerk = By.xpath("/html/body/div[6]/div[2]/div[14]/a");

    //Elementen oder popup 'Werkelijk verwijderen'
    public static By BevestigVerwijderenWerk = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");
    public static By BevestigVerwijderenMaatregel = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[1]/tbody/tr[2]/td[2]/em/button");

}
