# Rendszerterv

Időjárás előrejelző program
-----

#### I. A rendszer célja

A rendszer célja egy nagyon egyszerűen használható, a lehető legátlátóbb időjárás előrejelzés biztosítása a jelenlegi helyszín, illetve akár egy a felhasználó által megadott helyszín alapján olyan emberek számára akiknek nincs más kényelmes módjuk az elkövetkezendő időjárás megtekintéséhez.

#### II. A projekt terv

#### III. Az üzleti folyamatok modellje

#### IV. A követelmények

#### V. A funkcionális terv

A rendszerhez bárki, bármikor, bárhol hozzáférhet, nincsenek jogosultságok. 

![alt text](https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/terv.png "Terv")

Ahogy a minta képen is látható, a bal felső sarokban helyezkedik el magának a jelenlegi vagy a felhasználó által választott helyszínnek a neve, az alatt pedig a jelenlegi időjárás részletesen taglalva:

- jelenlegi időjárás az OpenWeather API által szolgáltatott ikonnal szemléltetve
- hőmérséklet
- szélsebesség
- szélirány
- borultság százalékban megadva
- nyomásp
- páratartalom

A felhasználónak a grafikus felület jobb felső oldalán van lehetősége más helyszín választására, melyet többféleképpen is megtehet: 
- a helyszín földrajzi neve
- irányítószám
- földrajzi koordináták

A rendszer segítséget kínál majd fel a helyszín kitörlésére az esetleges hibák, elgépelések elkerülése érdekében. Abban az esetben ha hibás értéket kapna bemenetnek a rendszer az oldal egy egyszerű 404-es hibát dob vissza, ezesetben, a rendszernek tájékoztatni kell a felhasználót, hogy nem megfelelő értéket adott meg.
A jelenlegi időjárás alatt, 5 egymástól elkülönített kis ablakaban jelenik meg az 5 napos előrejelzés rövidített változata, annak érdekében hogy kiférjen a szűk térre:
- időjárás ikonnal szemléltetve 
- hőmérséklet 
- csapadék

Ezen kis ablakokkal az egérrel interakcióba lehet lépni, kattintás után pedig a megfelelő nap részletes előrejelzését láthatja a felhasználó, ahol ugyanazon adatok lesznek láthatók mint a jelenlegi időjárásnál.

#### VI. A fizikai környezet

A programozási nyelv a Java 11 lesz. A választás azért esett a Java programozási nyelvre, mivel a felhasználó felület megvalósításához JavaFX 12-t használunk, amivel rendkívül gyorsan és egyszerűen tudunk grafikus felülettel rendlező alkalmazásokat készíteni köszönhetően a sceen buildernek, illetve számos olyan opció van benne mely megkönnyiti a fejlesztési folyamatokat.  
Az OpenWeather API (https://openweathermap.org/), aminek fő választási oka az volt, hogy képes nem csak a jelenlegi időjárási körülményeket megadni hanem képes több napos előrejelzést is nyújtani,
 ingyenes licencét használva hozzáférhetünk a megadott helyszín (név, ID, koordináta, irányítószám formájában megadható) jelenlegi időjárására, illetve 5 napos előlejelzésére. Az API válaszul egy JSON fájlt küld vissza, melyet a Google Gson (nyílt forráskódú Java könyvtár mely Java objektumot képes JSON filá, illetve JSON fájlt képes Java objektummá alakítani), segítségével olvasunk be,
 így a feldolgozásuk sokkal egyszerűbb és gyorsabb. 
 A jelenlegi időjáráshoz szükséges request formája: https://samples.openweathermap.org/data/2.5/weather?q=HELYSZÍN&appid=API_KEY,
az 5 napos előrejelzéshez szükséges request formája: https://samples.openweathermap.org/data/2.5/forecast?q=HELYSZÍN&appid=API_KEY,
az API_KEY-t az OpenWeather API biztosítja. A JSON fájlra a mellékletben található egy példa (example.json).
Az API által küldött JSON fájl rengeteg hasznos információt szolgáltat számunkra, melyek közül az alábbiakat használjuk:
- Maximum hőmérséklet, minimum hőmérséklet, jelenlegi hőmérséklet
- Nyomás
- Páratartalom
- Szélsebesség, szélirány
- Felhősség (százalékban megadva)
- Naplemente, napnyugta
- 5 napos előrejelzés
- Ikon ami a jelenlegi időjárást szemlélteti

#### VII. Absztrakt domain modell

#### VIII. Architekturális terv

A fejlesztés során az MVC (Model-View-Control) szoftverfejlesztési módsztertant alkalmazzuk.


Az OpenWeather Abstract Programming Interface, azesetben, ha helyes értéket kap (földrajzi név, irányítószám, koordináták) a következő JSON fájlt küldi válaszul. (ezesetben a helyszínünk a Japánban található Shuenzji) 

```json
{"coord": { "lon": 139,"lat": 35},
  "weather": [
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01n"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 289.92,
    "pressure": 1009,
    "humidity": 92,
    "temp_min": 288.71,
    "temp_max": 290.93
  },
  "wind": {
    "speed": 0.47,
    "deg": 107.538
  },
  "clouds": {
    "all": 2
  },
  "dt": 1560350192,
  "sys": {
    "type": 3,
    "id": 2019346,
    "message": 0.0065,
    "country": "JP",
    "sunrise": 1560281377,
    "sunset": 1560333478
  },
  "timezone": 32400,
  "id": 1851632,
  "name": "Shuzenji",
  "cod": 200
}

```

Mivel Google Gsont használunk, így szükséges, hogy a JSON fájlba az olyan elemek amelyek több paraméterrel rendelkeznek Java osztályként jelenjenek meg a kódunkban, így rendkívül könnyen kezelhetővé, hozzáférhetővé válik minden API által. szolgáltatott információ.

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/WeatherData.png" width="600" height="400" />

Annak érdekében, hogy minél egyszerűbb legyen dolgozni vele, a JSON-ben található neveket használjuk tovább, így sokkal átláthatóbb lesz a rendszer. 

A WeatherData osztály lesz a rendszerünk "Model"-je, azaz ez lesz az az osztály ami a "Controller" osztályunkról megkapja az információt, amelyet továbbít majd a "View"-nak. 
A Controller osztályunk, egy olyan osztály lesz melynek funckiói között megtaláható lesz: 
- API request küldése, a megkapott JSON fájl feldolgozása
- Az adatbázisban való keeresés

#### IX. Adatbázis terv

![alt text](https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/cities.png "Cities")

A rendszer adatbázisában a városok neveit tároljuk annak érdekében, hogy mikor a felhasználó elkezdi gépelni egy adott város nevét a grafikus felület jobb oldalába lévő részre, a program automatikus kiegészítse azt, a felhasználót ezzel nagy mértékben segítve, illetve a  hibás requestek számának csökkentése érdekében.

- city_name: a város neve
- counry_name: az ország neve

#### X. Implementációs terv

#### XI. Tesztterv

| Leírás        									|  Várt eset    | 
| :-------------:									|:-------------:| 
| A felhasználó hibás értéket ad meg bemenetnek (minden esetre)     | Az oldal 404-es hibát dob vissza, a felhasználó tudomást szerez a hibásan beírt értékről |
| új    									| új   |   

#### XII. Telepítési terv

#### XIII. Karbantartási terv
