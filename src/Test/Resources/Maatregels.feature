# language: nl

Functionaliteit: Maatregels

  Scenario: Goedpad - Maatregel aanmaken
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker maakt een nieuwe maatregel aan
    Dan is de maatregel getoond in het overzicht

    Scenario: Route aanpassen bestaande maatregel
      Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
      Als de medewerker inlogt op de 'interne GUI' van SPIN
      En de medewerker opent een nieuwe maatregel onder een bestaande fase
      En de medewerker past de route handmatig aan
      Dan worden de wijzigingen automatisch toegapast op de routedata

      @MaatregelOnderBestaandeFase
      Scenario: Conflict getoond met andere maatregel
        Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
        Als de medewerker inlogt op de 'interne GUI' van SPIN
        En de medewerker maakt een nieuwe maatregel aan met hetzelfde tijdvak als een bestaande maatregel
        En de medewerker bekijkt de maatregelen in hetzelfde tijdvak
        Dan ziet de medewerker dat er een conflict is met een andere maatregel in hetzelfde tijdvak

        Scenario: Verkeersstop toevoegen aan maatregel
          Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
          Als de medewerker inlogt op de 'interne GUI' van SPIN
          En de medewerker opent een nieuwe maatregel onder een bestaande fase
          En de medewerker voegt een verkeersstop toe aan de maatregel
          Dan is de verkeersstop te zien in het tabblad Verkeersstop

          Scenario: Omleiding toevoegen aan een maatregel
            Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
            Als de medewerker inlogt op de 'interne GUI' van SPIN
            En de medewerker opent een nieuwe maatregel onder een bestaande fase
            En de medewerker voegt een omleiding toe aan de maatregel
            Dan is de omleiding te zien in het tabblad Omleiding