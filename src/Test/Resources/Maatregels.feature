# language: nl

Functionaliteit: Maatregels

  Scenario: Goedpad - Maatregel aanmaken
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker een nieuwe maatregel aanmaakt en deze sluit
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

  @ExportVerkeersstops
  Scenario: Verkeersstop toevoegen aan maatregel en exporteren
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker opent een nieuwe maatregel onder een bestaande fase
    En de medewerker voegt een verkeersstop toe aan de maatregel
    Dan is de verkeersstop te zien in het tabblad Verkeersstop
    Als de medewerker een export maakt van de verkeersstop
    Dan wordt een csv bestand gegenereert met alle data van de geselecteerde verkeersstops
    En komt de data overeen met de aangemaakte verkeersstop

  Scenario: Omleiding toevoegen aan een maatregel
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker opent een nieuwe maatregel onder een bestaande fase
    En de medewerker voegt een omleiding toe aan de maatregel
    Dan is de omleiding te zien in het tabblad Omleiding

  Scenario: Standaard omleiding toevoegen aan een maatregel
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    En er is een standaard omleiding aanwezig
    Als de medewerker opent een nieuwe maatregel onder een bestaande fase
    En de medewerker voegt een standaard omleiding toe aan de maatregel
    Dan is de omleiding te zien in het tabblad Omleiding

  Scenario: Versionering maatregel
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker een nieuwe maatregel aanmaakt en deze geopend houdt
    En de medewerker wijzigingen aanbrengt en de maatregel opnieuw opslaat
    Dan is het versienummer van de maatregel opgehoogd
    Als de medewerker navigeert naar de vorige versie van de maatregel
    Dan wordt de vorige versie getoond

  Scenario: Maatregel goedkeuren
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker een nieuwe maatregel aanmaakt en deze geopend houdt
    En de medewerker de maatregel beoordeelt en hierbij de schematische kaart bekijkt
    Dan toont de schematische kaart de juiste maatregel
    Als de medewerker de maatregel indient
    Dan is de status van de maatregel aangepast naar Goedgekeurd

  Scenario: Toevoegingen aan schematische kaart
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker een nieuwe maatregel aanmaakt en deze geopend houdt
    En de medewerker de schematische kaart opent
    En de medewerker informatieborden en matrixsignaalgevers toevoegt aan de schematische kaart
    Dan zijn de wijzigingen aan de schematische kaart opgeslagen

  Scenario: Maatregel starten
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker een nieuwe maatregel aanmaakt en deze sluit
    En de medewerker de bestaande maatregel start
    Dan is de status van de maatregel veranderd naar 'In Uitvoering'

  Scenario: Actieve maatregel voorbij einddatum
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    En er is een maatregel aanwezig met een einddatum in het verleden en de status In uitvoering
    Als de medewerker de maatregel bekijkt in het overzicht
    Dan is het icoon van de maatregel rood gekleurd

  Scenario: Maatregel beeindigen
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    En er is een maatregel aanwezig met de status In uitvoering
    Als de medewerker de maatregel beeindigt
    Dan is de status van de maatregel veranderd naar 'Gerealiseerd'

  Scenario: Maatregel op Niet uitgevoerd  zetten
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    En er is een maatregel aanwezig met de status In uitvoering
    Als de medewerker de maatregel op niet uitgevoerd zet
    Dan is de status van de maatregel veranderd naar 'Niet uitgevoerd'

