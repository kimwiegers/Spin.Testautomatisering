# language: nl

  Functionaliteit: Tijdelijke Wijzigingen

      Scenario: Verplichte velden tijdelijke wijziging
      Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
      Als de medewerker inlogt op de 'interne GUI' van SPIN
      En de medewerker maakt een nieuwe tijdelijke wijziging aan
      En de medewerker laat het verplichte veld 'Datum van' leeg
      Dan is het niet mogelijk de locatie op te vragen van de tijdelijke wijziging

      Scenario: Gegenereerde data bij zoeken naar locatie
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker maakt een nieuwe tijdelijke wijziging aan
          Dan wordt automatisch een naam gegenereerd voor de tijdelijke wijziging
          En is de data onder Brondata situatie vooringevuld maar niet bewerkbaar

      Scenario: Zoomfunctie schematische kaart
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker maakt een nieuwe tijdelijke wijziging aan
          En de medewerker volledig uitzoomt op de schematische kaart
          Dan is de schematische kaart uitgezoomd

      #Scenario: Ook volledig inzoomen

      Scenario: Onjuiste rijstrook data invullen
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker maakt een nieuwe tijdelijke wijziging aan
          #En de medewerker de tijdelijke wijzigingsdata invult
          En de medewerker onjuiste data invoert over de rijstroken
          Dan zijn de onjuiste rijstrookgegevens met rood onderstreept

      #ToDo verbetering: Via DB inserts bestaande tijdelijke wijziging aanmaken als beforescenario
      Scenario: Bestaande tijdelijke wijziging bewerken
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker een bestaande tijdelijke wijziging selecteert om te bewerken
          En de medewerker volledig uitzoomt op de schematische kaart
          Dan blijft de juiste tijdelijke wijziging geselecteert
