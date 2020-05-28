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
      En de medewerker opent een bestaande maatregel
      En de medewerker past de route handmatig aan
      Dan worden de wijzigingen automatisch toegapast op de routedata
