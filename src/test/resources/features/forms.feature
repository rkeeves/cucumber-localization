# language: hu

Jellemző: ToolsQA form kezelés

  Háttér:
    Amennyiben a ToolsQA-ra látogat
    És a "Forms" nevű elemre kattint

  Forgatókönyv vázlat: felhasználó form-ot tölt ki helyesen
    Ha a baloldali menüsáv látszik
    És a "Practice Form" nevű elemre kattint
    Akkor látnia kell egy "Student Registration Form" című űrlapot
    Ha kitolti az alábbi adatokkal
    | vezeteknev | keresztnev | neme | email | mobil |
    | <vezeteknev>   | <keresztnev>     | <neme> | <email> | <mobil> |
    És beadja az űrlapot
    Akkor egy felugró ablaknak kell megjelennie "Thanks for submitting the form" felirattal
    Ha bezárja a felugró ablakot
    Akkor az előbb kitöltött mezők újból üresek lesznek
  Példák:
    | vezeteknev | keresztnev | neme  | email               | mobil       |
    | Teszt      | Elek       | Férfi | teszt.elek@teszt.hu | 1111111111  |
    | Teszt      | Rita       | Nő    | teszt.rita@teszt.hu | 1111111112  |
    | Teszt      | Void       | Egyéb | teszt.void@teszt.hu | 1111111113  |