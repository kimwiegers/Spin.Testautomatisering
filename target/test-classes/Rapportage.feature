# language: nl

Functionaliteit: Rapportage

  @ExportVerkeersstops
  Scenario: Rapportage draaien
    Gegeven een medewerker met rechten van Lange Termijn Planner in SPIN
    Als de medewerker inlogt op de 'interne GUI' van SPIN
    En de medewerker navigeert naar het Rapportage menu
    En de medewerker genereert een rapportage van de verkeersstops van de regio 'Midden-Nederland'
    Dan wordt een csv bestand gegenereert met alle data van de bestaande verkeersstops