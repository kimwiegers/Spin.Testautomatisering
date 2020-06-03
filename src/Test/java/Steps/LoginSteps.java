package Steps;

import Omgevingen.Acceptatie;
import Services.SpinService;
import TestData.GebruikersData;
import cucumber.api.java.nl.Als;


public class LoginSteps {

    private final SpinService _loginservice;
    private final GebruikersData _gebruiker;

    public LoginSteps(SpinService spinService, GebruikersData gebruiker)
    {
        _loginservice = spinService;
        _gebruiker = gebruiker;
    }

    @cucumber.api.java.nl.Gegeven("een medewerker met rechten van Lange Termijn Planner in SPIN")
    public void eenMedewerkerMetRechtenVanLangeTermijnPlannerInSPIN()
    {
        _gebruiker.setGebruikersnaam(Acceptatie.gebruikersnaam);
        _gebruiker.setWachtwoord(Acceptatie.wachtwoord);
    }

    @Als("de medewerker inlogt op de {string} van SPIN")
    public void deMedewerkerInlogtOpDeVanSPIN(String gui) throws Exception
    {
        _loginservice.LogIn(gui);
    }
}
