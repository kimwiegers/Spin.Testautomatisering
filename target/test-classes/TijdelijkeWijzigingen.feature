# language: nl

  Functionaliteit: Tijdelijke Wijzigingen

      Scenario: Goedpad - Tijdelijke Wijziging aanmaken
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker maakt een nieuwe tijdelijke wijziging aan
          Dan is de tijdelijke wijziging aan de tabel Objecten toegevoegd

      Scenario: Verplichte velden tijdelijke wijziging
      Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een nieuwe tijdelijke wijziging opent en alle benodigde informatie geeft
      En de medewerker laat het verplichte veld 'Datum van' leeg
      Dan is het niet mogelijk de locatie op te vragen van de tijdelijke wijziging

      Scenario: Gegenereerde data bij zoeken naar locatie
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een nieuwe tijdelijke wijziging opent en alle benodigde informatie geeft
          Dan wordt automatisch een naam gegenereerd voor de tijdelijke wijziging
          En is de data onder Brondata situatie vooringevuld maar niet bewerkbaar

      Scenario: Zoomfunctie schematische kaart
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een nieuwe tijdelijke wijziging opent en alle benodigde informatie geeft
          En de medewerker volledig uitzoomt op de schematische kaart
          Dan is de schematische kaart uitgezoomd

      Scenario: Onjuiste rijstrook data invullen
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een nieuwe tijdelijke wijziging opent en alle benodigde informatie geeft
          En de medewerker onjuiste data invoert over de rijstroken
          Dan zijn de onjuiste rijstrookgegevens met rood onderstreept

      #ToDo verbetering: Via DB inserts bestaande tijdelijke wijziging aanmaken als beforescenario
      Scenario: Bestaande tijdelijke wijziging bewerken
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een bestaande tijdelijke wijziging selecteert om te bewerken
          En de medewerker volledig uitzoomt op de schematische kaart
          Dan blijft de juiste tijdelijke wijziging geselecteert

    Scenario: foutpad - Begindatum na einddatum
        Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
        Als de medewerker inlogt op de 'interne GUI' van SPIN
        En de medewerker een nieuwe tijdelijke wijziging opent
        En de medewerker voert een begin- en einddatum in met dezelfde datum
        Dan is de onjuiste begindatum met rood onderstreept

      Scenario: foutpad - te hoge kilometrage invullen
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een nieuwe tijdelijke wijziging opent
          En de medewerker voert een te hoge kilometrage in voor de tijdelijke wijziging
          Dan ziet de klant een pop-up met informatie over de kilometrage

          #ToDo Xls versie nog maken
      @ExportTijdelijkeWijziging
      Abstract Scenario: Export van specifieke regio
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker maakt een nieuwe tijdelijke wijziging aan
          En de medewerker een export van de tijdeljke wijzigingen maakt in '<format>'
          Dan wordt een export gegenereerd in een '<format>' bestand
          En zijn alleen de gefilterde tijdelijke wijzigingen meegenomen in de export

    Voorbeelden:
    |format|
    |csv|
    #|xls|

