package TestData;

public class GebruikersData
{
    public static String DownloadFolder = "C:\\Users\\rws\\Downloads";

    public static String Gebruiker = "Kim Wiegers";

    private String gebruikersnaam;
    private String wachtwoord;

    public void setGebruikersnaam(String gebruikersnaam){
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setWachtwoord(String wachtwoord){
        this.wachtwoord = wachtwoord;
    }

    public String getGebruikersnaam(){
        return this.gebruikersnaam;
    }

    public String getWachtwoord(){
        return this.wachtwoord;
    }
}
