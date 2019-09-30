


# Rendszerterv

Időjárás előre jelző program
-----

### I. A rendszer célja

Egy nagyon egyszerűen használható, a lehető legátláthatóbb időjárás előrejelzés biztosítása a jelenlegi helyszín, illetve akár egy a felhasználó által megadott helyszín alapján. Alkalmas legyen idős emberek számára, hogy ők saját erejükből képesek legyenek tájékozódni az általuk kiválasztott helység aktuális és várható időjárásával kapcsolatban. Fontos, hogy az öregotthon lakói rendelkezzenek egy olyan időjárás előrejelzés forrással, melyet kényelmesen megtudnak nézni. Ami nagyon fontos, hogy teljesen önállóan képesek legyenek a program használatára anélkül, hogy az alkalmazottakat kérdezgessék mivel az elvonhatja a figyelmüket a munkájukról és így az elvégezetlenül vagy félbehagyva maradhat ami akár súlyos fizikai vagy szellemi károkhoz is vezethet. Ne kelljen az ablakon át a járókelőket zaklassák az időjárással kapcsolatos kérdéseikkel, vagy várniuk egy adott időpontra amikor a TV-ből, illetve Rádióból tájékozódhatnának.

### II. A projekt terv

####  Projekt szerepkörök, felelősségek:

A programunkhoz szükség lesz grafikus tervezőkre, szoftverfejlesztőkre, illetve tesztelőkre. Mivel a
csapatunknak ez az első közös projektje ezért kihasználjuk ezt az alkalmat arra, hogy megtudjuk csapatunkból
ki melyik szerepkörben a legtehetségesebb. Így minden egyes szerepkörben a felelősség egyenlően szétosztódik a csapat tagjai között.

#### Projekt munkások és felelősségeik:

A fejlesztési csapat három személyes. A csapat minden tagjának hasonló képzetségi szintje van a projekthez
szükséges szerepköröket illetően, így a csapat bármely tagja részt vehet a szoftverfejlesztés bármelyik
szakaszába.

#### Ütemterv

|  Sorszám   |  Feladat neve | Kezdés időpontja | Befejezés időpontja |
| :-------------: | :-------------: | :-------------: | :-------------: |
|1|Követelményspecifikáció megírása | 2019.09.17 | 2019. 09.26 |
|2|Funkcionálisspecifikáció megírása| 2019.09.17 | 2019. 09.26 |
|3|Rendszertev megírása             | 2019.09.17 | 2019. 09.30 |
|4|Grafikus felület elkészítése     | 2019.09.24 | 2019. 09.29 |
|5|A szoftver logikájának elkészítése |2019.09.24| 2019. 09.29 |
|6|A program tesztjeinek megírása   | 2019.09.24 | 2019. 09.29 |
|7|A program tesztelése             | 2019.09.24 | 2019. 09.29 |



### III. Az üzleti folyamatok modellje

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/folyamatdiagram.png"/>

### IV. A követelmények

A program felhasználói felülete magyar nyelvű kell, hogy legyen.
Könnyen használható kell legyen azok számára is, akik nem jártassak a számítógépek használatában, így egyszerű és átlátható grafikus felülettel kell rendelkezzen.
Több napos időjáráselőrejelzésre és az aktuális időjárás meghatározására alkalmas kell, hogy legyen.
Alkalmas kell, hogy legyen tetszőleges helyszín kiválasztására.
A program képes kell legyen a kiválasztott helyiség időjárási adatainak megjelenítésére.

### V. A funkcionális terv

A rendszerhez bárki, bármikor, bárhol hozzáférhet, nincsenek jogosultságok.

![alt text](https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/kepernyoTerv.png "Terv")

Ahogy a mintaképen is látható, a felső részen a felhasználó három menüpont közül választhat tetszőlegesen:
- Település
- Irányítószám
- Koordináták

A **település fül** alatt a felhasználónak lehetősége lesz az általa választott helység időjárására keresni, azután miután megadta az ország nevét. A felhasználót nagy mértékbe segíti majd a helyszín kiválasztásában az automata kiegészítő, mely a felhasználó által beadott bemenet alapján az arra illeszkedő földrajzi városneveket, illetve országneveket ajánlja fel a felhasználónak, mellyel az egérrel interakcióba lehet lépni, ami után a kiválasztott helyszín neve a szöveg dobozba megjelenik.
Az **irányítószám fül** alatt hasonlóan a program használójának lehetősége lesz az általa választott irányítószám alapján rákeresni az időjárás előrejelzésre, szintúgy az ország nevének megadása után. Ezesetben az automata kiegészítő csak az ország neve esetén nyújt segítségét.
A **koordináta fül** alatt a felhasználónak lehetősége lesz az általa választott szélességi és hosszúsági földrajzi koordináta megadása után rákeresni az 5 napos előrejelzésre.
Minden esetben a **"Kész"** gomb megnyomása után kerül mentése a bemenet.
**Hiba esetén** a képernyőn jelenik meg egy **hibaüzenet**, mely tájékoztatja a felhasználót, hogy mit tévesztett el, így egyszerűen kitudja javítani.
Miután a szoftver használójának sikerült hiba nélküli információt eljuttatni a programnak, **három sor** töltődik majd fel információval.
Az **első sorban** található a dátum, a hét megfelelő napjával és az arra a napra való minimum, illetve maximum hőmérséklettel, mind Kelvinnel, illetve Celsiussal megadva. Ezen "ablakokkal" az egérrel interakcióba lehet lépni, rájuk lehet kattintani, azt, hogy melyik ablakra fogunk kattintani a háttér világossá színeződése jelzi. Miután a felhasználó rákattintott az általa választott napra, a második sor feltöltődik új információval.
A **második sorban** található a kiválasztott napra a 3 óránként való előrejelzés, melyen az alábbi elemek láthatók:
- Az adott óra
- Az adott időpontban várható időjárás az OpenWeather API által szolgáltatott ikonnal szemléltetve
- Az adott időponton várható átlaghőmérséklet.

Szintúgy, mint az első sorban ezen kis ablakok kattinthatók, melynek helyét ugyanúgy a háttér világossá való színeződése jelzi. Miután a felhasználó kiválasztotta az általa kívánt időpontot a harmadik sor töltődik fel újabb információkkal.
A harmadik sorban a választott időpont részletes előrejelzése látható az alábbi elemekkel:
- egy kép, mely a várható időjárást szemlélteti
- a várható maximum, illetve minimum hőmérséklet
- páratartalom
- borultság százalékban megadva (menyire tiszta az ég)
- szélirány
- légnyomás

### VI. A fizikai környezet

A programozási nyelv a Java 11 lesz. A választás azért esett a Java programozási nyelvre, mivel a felhasználó felület megvalósításához JavaFX 12-t használunk, amivel rendkívül gyorsan és egyszerűen tudunk grafikus felülettel rendelkező alkalmazásokat készíteni köszönhetően a sceen buildernek, illetve számos olyan opció van benne mely megkönnyíti a fejlesztési folyamatokat. Az OpenWeather API (https://openweathermap.org/), aminek fő választási oka az volt, hogy képes nem csak a jelenlegi időjárási körülményeket megadni, hanem képes több napos előrejelzést is nyújtani, ingyenes licencét használva hozzáférhetünk a megadott helyszín (név, ID, koordináta, irányítószám formájában megadható) jelenlegi időjárásához, illetve 5 napos előrejelzéséhez. Az API válaszul egy JSON fájlt küld vissza, melyet a Google Gson (nyílt forráskódú Java könyvtár mely Java objektumot képes JSON fájllá, illetve JSON fájlt képes Java objektummá alakítani), segítségével olvasunk be, így a feldolgozásuk sokkal egyszerűbb és gyorsabb. A jelenlegi időjáráshoz szükséges request formája: https://samples.openweathermap.org/data/2.5/weather?q=HELYSZÍN&appid=API_KEY, az 5 napos előrejelzéshez szükséges request formája: https://samples.openweathermap.org/data/2.5/forecast?q=HELYSZÍN&appid=API_KEY, az API_KEY-t az OpenWeather API biztosítja. A JSON fájlra a mellékletben található egy példa (example.json).
Az API által küldött JSON fájl rengeteg hasznos információt szolgáltat számunkra, melyek közül az alábbiakat használjuk:
- Maximum hőmérséklet, minimum hőmérséklet, jelenlegi hőmérséklet
- Nyomás
- Páratartalom
- Szélsebesség, szélirány
- Felhősség (százalékban megadva)
- Naplemente, napnyugta
- 5 napos előrejelzés
- Ikon, ami a jelenlegi időjárást szemlélteti

A program rendszerű működéséhez állandó internethozzáférés szükséges.

### VII. Architekturális terv

A fejlesztés során az **MVC** (Model-View-Control) szoftverfejlesztési módsztertant alkalmazzuk.

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/MVC-Process.png" width="300" />

A rendszerünk **"MODEL"**-je egy CurrentWeatherData, egy ForecastWeatherData és Handler osztályokból fog állni. A **"VIEW"** egy App nevű osztályból fog állni. A **"CONTROLLER"** egy Weather nevű osztályból lesz felépítve.
A Handler osztályok JSON fájlokat, illetve képeket olvasnak be, ezeknek a JSON fájloknak a tartalmát WeatherData objektumokban tároljuk.
Az App osztály egy fxml fájl használatával jeleníti meg a grafikus felületet, és ezzel az interakciót a Weather osztály végzi, ami magával a **"MODEL"**-el is kommunikál.

### VIII. Implementációs terv

Az OpenWeather Application Programming Interface, abban az esetben, ha helyes értéket kap (földrajzi név, irányítószám, koordináták) a következő JSON fájlt küldi válaszul. (ezesetben a helyszínünk a Japánban található Shuenzji).

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

Mivel Google Gsont használunk, így szükséges, hogy a JSON fájlba az olyan elemek, amelyek több paraméterrel rendelkeznek Java osztályként jelenjenek meg a kódunkban, így rendkívül könnyen kezelhetővé, hozzáférhetővé válik minden API által. szolgáltatott információ.

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/WeatherData.png" width="600" height="400" />

Annak érdekében, hogy minél egyszerűbb legyen dolgozni vele, a JSON-ben található neveket használjuk tovább, így sokkal átláthatóbb lesz a rendszer.


Mivel a legjobbat szeretnénk a felhasználónak, így biztosítunk egy olyan funkciót, amely a beírt input alapján kiegészíti az országok nevét, illetve a kívánt helyszín földrajzi nevét. Ehhez az OpenWeather egy JSON fájlt szolgáltat számunkra, mely az alábbi formátumú:

```json
 {
    "id": 707860,
    "name": "Hurzuf",
    "country": "UA",
    "coord": {
      "lon": 34.283333,
      "lat": 44.549999
    }
  }
```

Ebben a JSON fájlban a világ összes települése megtalálható. Ezen városokat egy Map<String, ArrayList<String>> formátumú Map-ben tároljuk, ahol a String az ország neve, az ArrayList<String> pedig az adott országhoz kapcsolódó országok. A controlsfx (https://github.com/controlsfx/controlsfx) segítségével nagyon egyszerűen létrehozhatjuk ezt az automatikusan kiegészülő listát, ugyanis egy bindAutoCompletion(TextField, Collection<T>) metódust szolgáltat nekünk, ahol az első paraméter az a textField ahová a felhasználó éppen ír, a második pereméter pedig az ajánlásokból álló adat struktúra, az ajánlásokat a létrehozott Mapunkból szedjük majd ki.  

#### Perzisztencia osztályok:

A projektünkben az MVC (Model-View-Controller) szoftverfejlesztési módszertant használjuk, így tehát az összes perzisztencia osztályunk a Model packagen belül lesz megtalálható.
A Model packagen belül lesz még két különböző package. Az egyik az a CurrentWeather osztály lesz, amely arra fog szolgálni, hogy az aznapi időjárás előrejelzéssel kapcsolatos információkat legyen mibe tároljuk. A másik package pedig a ForecastWeather osztály lesz, aminek az lesz a szerepe, hogy az elkövetkezendő napokkal kapcsolatos időjárás előrejelzést tárolja.

##### A CurrentWeather packagen belül a következő perzisztencia osztályok lesznek megtalálhatóak:

A City osztály, ami a város OpenWeatherAPI-n belüli ID-t, a város nevét, az ország nevét, amiben tartózkodik, illetve a város koordinátáit fogja tárolni.

Clouds osztály, ami az időjárás előrejelzésből a felhősséget fogja tárolni.

A Coords osztály, ami a helység földrajzi szélességi és hosszúsági koordinátáit fogja eltárolni.

Egy Main nevű osztály, ami az időjárással kapcsolatos legfontosabb információkat fogja eltárolni pl. átlag hőmérsékletet, légnyomást, páratartalmat, maximum, illetve minimum hőmérsékleteket.

A Sys osztály, ami tárolni fogja, a helység a típusát (község, falú, város), illetve a virradat és alkonyat időpontjait.

Weather osztály, ami a jelenlegi időjárással kapcsolatos információkat fogja tárolni. Az id az OpenWeatherAPI-s azonosítót fogja tárolni. A main az időjárás kategóriáját tárolja, a description meg a kategórián belüli időjárási típust fogja eltárolni. Végül pedig az icon-ba lesz eltárolva az OpenWeatherAPI által nyújtott olyan icon, amely a description-nek megfelel.

A Wind osztály fogja eltárolni a szélsebességet és a szélirányt.

A CurrentWeatherData osztály lesz a végső tároló, ami összegyűjti a többi osztály által tárolt adatokat és amin keresztül lekérdezzük őket.

##### A ForeCastWeather packagen belül a következő perzisztencia osztályok lesznek megtalálhatóak:

A City, Clouds, Coords, Main, Sys, Weather, Wind osztályok hasonló információkat fognak tárolni, mint a CurrentWeather package változatuk, néhány helyen ki bővített információval.

A City osztály, ami a város OpenWeatherAPI-n belüli ID-t, a város nevét, az ország nevét, amiben tartózkodik, a város koordinátáit, népességét, időzónáját, illetve a napkelte és a napnyugta időpontjait fogja tárolni.

Clouds osztály, ami az időjárás előrejelzésből a felhősséget fogja tárolni.

A Coords osztály, ami a helység földrajzi szélességi és hosszúsági koordinátáit fogja eltárolni.

Egy Main nevű osztály, ami az időjárással kapcsolatos legfontosabb információkat fogja eltárolni pl. átlag hőmérsékletet, légnyomást, páratartalmat, maximum, illetve minimum hőmérsékleteket. Illetve még tárolni fogja a tengerszintet, csapadékot, illetve a légnyomást tengerszinten is.

A Sys osztály, ami tárolni fogja, a helység a típusát (község, falú, város), illetve a virradat és alkonyat időpontjait.

Weather osztály, ami a jelenlegi időjárással kapcsolatos információkat fogja tárolni. Az id az OpenWeatherAPI-s azonosítót fogja tárolni. A main az időjárás kategóriáját tárolja, a description meg a kategórián belüli időjárási típust fogja eltárolni. Végül pedig az icon-ba lesz eltárolva az OpenWeatherAPI által nyújtott olyan icon, amely a description-nek meg fog felelni.

A Wind osztály fogja eltárolni a szélsebességet és a szélirányt.

ForecastWeather osztály a többi osztály által tárolt adatokat fogja eltárolni, ezek az adatok csak egy napra elegendő információkat tartalmaznak.

A ForecastWeatherData fogja eltárolni az öt napos időjárás előrejelzéssel kapcsolatos adatokat a list nevű változóba, ami egy ForecastWeather típusú lista lesz.

##### Handler packageben a következő perzisztencia osztályok lesznek megtalálhatóak:

A CurrentWeatherHandler osztály lesz felelős a jelenlegi időjárás előrejelzés beolvasásáért lakcím, zip code vagy földrajzi szélességi és hosszúsági koordináták alapján.

A ForeCastWeatherHandler lesz felelős az elkövetkezendő időjárás előrejelzések beolvasásáért lakcím, zip code vagy földrajzi szélességi és hosszúsági koordináták alapján.

A Handler osztály lesz felelős az OpenWeather API oldaltól kapott JSON adatok beolvasására.

Az ImageHandler osztály az óránkénti időjárás előrejelzéseknek megfelelő képek betöltéséért lesz felelős.

####  Kliensoldal osztályai:

A Controller packageben található Weather osztály lesz felelős a felhasználókkal való interakciókért. Ez az osztály reagál a felhasználó változtatásaira. Itt fognak meghívásra kerülni a betöltő folyamatok, a törlő folyamatok, illetve a kiíró folyamatok.

### IX. Tesztterv

| Leírás        									|  Várt eset    |
| :-------------:									|:-------------:|
| A felhasználó hibás értéket ad meg bemenetnek (minden esetre)    | Az oldal 404-es hibát dob vissza, a felhasználó tudomást szerez a hibásan beírt értékről |
| A felhasználó meg akarja nyitni az egyik nap részletes adatait | a kiválasztott nap adatait várjuk és nem egy másik napét |
### X. Telepítési terv

A program platform független. A program futtatásához szükséges, hogy telepítve legyen a számítógépre a Java 11.
