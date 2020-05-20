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

      #ToDo Scenario: Ook volledig inzoomen
