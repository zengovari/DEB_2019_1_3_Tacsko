

# Rendszerterv

Időjárás előrejelző program
-----

### I. A rendszer célja

Egy nagyon egyszerűen használható, a lehető legátláthatóbb időjárás előrejelzés biztosítása a jelenlegi helyszín, illetve akár egy a felhasználó által megadott helyszín alapján. Alkalmas legyen idős emberek számára, hogy ők saját ejükből képesek legyenek tájékozódni az általuk kiválasztott helység aktuális és várható időjárásával kapcsolatban. Fontos hogy az öregotthon lakói rendelkezzenek egy olyan időjáráselőrejelzési forrással, melyet kényelmesen megtudnak nézni. Ami nagyon fontos hogy teljesen önállóan képesek legyenek a program használatára anélkül hogy az alkalmazottakat kérdezgesék mivel az elvonhatja a figyelmüket a munkájukról és így az elvégezetlenül vagy félbehagyva maradhat ami akár súlyos fizikai vagy szellemi károkhaz is vezethet. Ne kelljen az ablakon át a járókelőket zaklassák az időjárással kapcsolatos kérdéseikkel, vagy várniuk egy adott időpontra amikor a TV-ből illetve Rádióból tájákozódhatnának.

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
|4|Grafikus felület elkészitése     | 2019.09.24 | 2019. 09.29 |
|5|A szoftver logikájának elkészitése |2019.09.24| 2019. 09.29 |
|6|A program tesztjeinek megírása   | 2019.09.24 | 2019. 09.29 |
|7|A program tesztelése             | 2019.09.24 | 2019. 09.29 |



### III. Az üzleti folyamatok modellje

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/folyamatdiagram.png"/>

### IV. A követelmények

A program felhasználói felülete magyar nyelvű kell hogy legyen.
Könyen használható kell legyen azok számára is akik nem jártasak a számítógépek használatában, így egyszerű és átlátható grafikus felülettel kell rendelkezzen.
Több napos időjáráselőrejelzésre és az aktuális időjárás meghatározására alkalmas kell hogy legyen.
Alkalmas kell hogy legyen tetszőleges helyszín kiválasztására.
A program képes kell legyen a kiválasztott helyiség időjárási adatainak megjelenítésére.

### V. A funkcionális terv

A rendszerhez bárki, bármikor, bárhol hozzáférhet, nincsenek jogosultságok.

![alt text](https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/kepernyoTerv.png "Terv")

Ahogy a minta képen is látható, a felső részen a felhasználó három menüpont közül választhat tetszőlegesen: 
- Település
- Irányítószám
- Koordináták

A **település fül** alatt a felhasználónak lehetősége lesz az általa választott helység időjárására keresni, azután miután megadta az ország nevét. A felhasználót nagy mértékbe segíti majd a helyszín kiválasztásában az automata kiegészítő, mely a felhasználó által beadott bemenet alapján az arra illeszkedő földrajzi városneveket, illetve országneveket ajánlja fel a felhasználónak, melyel az egérrel interakcióba lehet lépni, amiután a kiválasztott helyszín neve a szöveg dobozba megjelenik. 
Az **irányítószám fül** alatt hasonlóan a program használójának lehetősége lesz az általa választott irányítószám alapján rákeresni az időjárás előrejelzésre, szintúgy az ország nevének megadása után. Ezesetben az automata kiegészítő csak az ország neve esetén nyújt segítségét.
A **koordináta fül** alatt a felhasználónak lehetősége lesz az általa választott szélességi és hosszúsági földrajzi koordináta megadása után rákeresni az 5 napos előrejelzésre.
Minden esetben a **"Kész"** gomb megnyomása után kerül mentése a bemenet.
**Hiba esetén** a képernyőn jelenik meg egy **hibaüzenet**, mely tájékoztatja a felhasználót, hogy mit tévesztett el, így egyszerűen kitudja javítani.
Miután a szoftver használójának sikerült hiba nélküli információt eljutatni a programnak, **három sor** töltődik majd fel információval.
Az **első sorban** található a dátum, a hét megfelelő napjával és az arra a napra való minimum, illetve maximum hőmérséklettel, mind Kelvinnel, illetve Celsiussal megadva. Ezen "ablakokkal" az egérrel interakcióba lehet lépni, rájuk lehet kattintani, azt, hogy melyik ablakra fogunk kattintani a háttér világossá színeződése jelzi. Miután a felhasználó rákattintott az általa válaszott napra, a második sor feltöltődik új információval.
A **második sorban** található a kiválasztott napra a 3 óránként való előrejelzés, melyen az alábbi elemek láthatók:
- Az adott óra
- A az adott időpontban várható időjárás az OpenWeather API által szolgáltatott ikonnal szemléltetve
- Az adott időponton várható átlaghőmérséklet.

Szintúgy mint az első sorban ezen kis ablakok kattinhatók, melynek helyét ugyanúgy a háttér világossá való színeződése jelzi. Miután a felhasználó kiválasztotta az általa kívánt időpontot a harmadik sor töltődik fel újabb információkkal. 
A harmadik sorban a választott időpont részletes előrejelzése látható az alábbi elemekkel: 
- egy kép, mely a várható időjárást szemlélteti
- a várható maximum, illetve minimum hőmérséklet
- páratartalom
- borultság százalékban megadva (menyire tiszta az ég)
- szélirány
- légnyomás

### VI. A fizikai környezet

A programozási nyelv a Java 11 lesz. A választás azért esett a Java programozási nyelvre, mivel a felhasználó felület megvalósításához JavaFX 12-t használunk, amivel rendkívül gyorsan és egyszerűen tudunk grafikus felülettel rendlező alkalmazásokat készíteni köszönhetően a sceen buildernek, illetve számos olyan opció van benne mely megkönnyiti a fejlesztési folyamatokat. Az OpenWeather API (https://openweathermap.org/), aminek fő választási oka az volt, hogy képes nem csak a jelenlegi időjárási körülményeket megadni hanem képes több napos előrejelzést is nyújtani, ingyenes licencét használva hozzáférhetünk a megadott helyszín (név, ID, koordináta, irányítószám formájában megadható) jelenlegi időjárására, illetve 5 napos előlejelzésére. Az API válaszul egy JSON fájlt küld vissza, melyet a Google Gson (nyílt forráskódú Java könyvtár mely Java objektumot képes JSON filá, illetve JSON fájlt képes Java objektummá alakítani), segítségével olvasunk be, így a feldolgozásuk sokkal egyszerűbb és gyorsabb. A jelenlegi időjáráshoz szükséges request formája: https://samples.openweathermap.org/data/2.5/weather?q=HELYSZÍN&appid=API_KEY, az 5 napos előrejelzéshez szükséges request formája: https://samples.openweathermap.org/data/2.5/forecast?q=HELYSZÍN&appid=API_KEY, az API_KEY-t az OpenWeather API biztosítja. A JSON fájlra a mellékletben található egy példa (example.json).
Az API által küldött JSON fájl rengeteg hasznos információt szolgáltat számunkra, melyek közül az alábbiakat használjuk:
- Maximum hőmérséklet, minimum hőmérséklet, jelenlegi hőmérséklet
- Nyomás
- Páratartalom
- Szélsebesség, szélirány
- Felhősség (százalékban megadva)
- Naplemente, napnyugta
- 5 napos előrejelzés
- Ikon ami a jelenlegi időjárást szemlélteti

A program rendszerű működéséhez állandó internethozzáférés szükséges.

### VII. Architekturális terv

A fejlesztés során az MVC (Model-View-Control) szoftverfejlesztési módsztertant alkalmazzuk.

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/MVC-Process.png" width="300" />

A WeatherData osztály lesz a rendszerünk "Model"-je, azaz ez lesz az az osztály ami a "Controller" osztályunkról megkapja az információt, amelyet továbbít majd a "View"-nak.
A Controller osztályunk, egy olyan osztály lesz melynek funckiói között megtaláható lesz:
- API request küldése, a megkapott JSON fájl feldolgozása
- Az adatbázisban való keeresés

### VIII. Implementációs terv

#### Perzisztencia osztályok:

A projektünkben az MVC (Model-View-Controller) szoftverfejlesztési módszertant használjuk, így tehát az összes perzisztencia osztályunk a Model packagen belül lesz megtalálható.
A Model packagen belül lesz még két különböző package. Az egyik az a CurrentWeather osztály lesz amely arra fog szolgálni, hogy az aznapi ídőjárás előrejelzéssel kapcsolatos információkat legyen mibe tároljuk. A másik package pedig a ForecastWeather osztály lesz aminek az lesz a szerepe, hogy az elkövetkezendő napokkal kapcsolatos ídőjárás előrejelzést tárolja.

##### A CurrentWeather packagen belül a következő perzisztencia osztályok lesznek megtalálhatóak:

A City osztály ami a város OpenWeatherAPI-n belüli ID-t, a város nevét, az ország nevét amiben tartózkodik, illetve a város koordinátáit fogja tárolni.

Clouds osztály ami a az időjárás előrlejelzésből a felhősséget fogja tárolni.

A Coords osztály ami a helység földrajzi szélességi és hosszúsági koordinátáit fogja eltárolni.

Egy Main nevű osztály ami az ídőjárással kapcsolatos legfontosabb információkat fogja eltárolni pl. átlag hőmérsékletet, légnyomást, páratartalmat, maximum illetve minimum hömérsékleteket.

A Sys osztály ami tárolni fogja, a helység a tipusát (község, falú, város), illetve a virradat és alkonyat ídőpontjait .

Weather osztály ami a jelenlegi ídőjárással kapcsolatos informáciokat fogja tárolni. Az id az OpenWeatherAPI-s azonosítót fogja tárolni. A main az ídőjárás kategóriáját tárolja, a description meg a kategórián belüli ídőjárási típust fogja eltárolni. Végül pedig az icon-ba lesz eltárolva az OpenWeatherAPI által nyújtott olyan icon amely a description-nek megfelel.

A Wind osztály fogja eltárolni a szél sebességet és a szél írányt.

A CurrentWeatherData osztály lesz a végső tároló ami összegyűjti a többi osztály által tárolt adatokat és amin keresztül lekérdezzük őket.

##### A ForeCastWeather packagen belül a következő  perzisztencia osztályok lesznek megtalálhatóak:

A City, Clouds, Coords, Main, Sys, Weather, Wind osztályok hasonló informáciokat fognak tárolni mint a CurrentWeather package változatuk, néhány helyen kibővitett információval.

A City osztály ami a város OpenWeatherAPI-n belüli ID-t, a város nevét, az ország nevét amiben tartózkodik, a város koordinátáit, népességét, ídőzonáját, illetve a napkelte és a napnyugta ídőpontjait fogja tárolni.

Clouds osztály ami a az időjárás előrlejelzésből a felhősséget fogja tárolni.

A Coords osztály ami a helység földrajzi szélességi és hosszúsági koordinátáit fogja eltárolni.

Egy Main nevű osztály ami az ídőjárással kapcsolatos legfontosabb információkat fogja eltárolni pl. átlag hőmérsékletet, légnyomást, páratartalmat, maximum illetve minimum hömérsékleteket. Illetve még tárolni fogja a tengerszintet, csapadékosságot, illetve a légnyomást tengerszinten is.

A Sys osztály ami tárolni fogja, a helység a tipusát (község, falú, város), illetve a virradat és alkonyat ídőpontjait .

Weather osztály ami a jelenlegi ídőjárással kapcsolatos informáciokat fogja tárolni. Az id az OpenWeatherAPI-s azonosítót fogja tárolni. A main az ídőjárás kategóriáját tárolja, a description meg a kategórián belüli ídőjárási típust fogja eltárolni. Végül pedig az icon-ba lesz eltárolva az OpenWeatherAPI által nyújtott olyan icon amely a description-nek meg fog felelni.

A Wind osztály fogja eltárolni a szél sebességet és a szél írányt.

ForecastWeather osztály a többi osztály által tárolt adatokat fogja eltárolni, ezek az adatok csak egy napra elegendő informáciokat tartalmaznak.

A ForecastWeatherData fogja eltárolni az öt napos ídőjárás előrejelzéssel kapcsolatos adatokat a list nevű változóba ami egy ForecastWeather típusú lista lesz.

##### Handler packageben a következő perzisztencia osztályok lesznek megtalálhatóak:

A CurrentWeatherHandler osztály lesz felelős a jelenlegi ídőjárás előrelejzés beolvasásáért lakcím, zip code vagy földrajzi szélességi és hosszúsági koordináták alapján.

A ForeCastWeatherHandler lesz felelős az elkövetkezendő ídőjárás előrejelzések beolvasásáért lakcím, zip code vagy földrajzi szélességi és hosszúsági koordináták alapján.

A Handler osztály lesz felelős az OpenWeather API oldaltól kapott JSON adatok beolvasására.

Az ImageHandler osztály az óránkénti ídőjárás előrejelzéseknek megfelelő képek betöltéséért lesz felelős.

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

Mivel Google Gsont használunk, így szükséges, hogy a JSON fájlba az olyan elemek amelyek több paraméterrel rendelkeznek Java osztályként jelenjenek meg a kódunkban, így rendkívül könnyen kezelhetővé, hozzáférhetővé válik minden API által. szolgáltatott információ.

<img src="https://raw.githubusercontent.com/zengovari/DEB_2019_1_3_Tacsko/master/WeatherData.png" width="600" height="400" />

Annak érdekében, hogy minél egyszerűbb legyen dolgozni vele, a JSON-ben található neveket használjuk tovább, így sokkal átláthatóbb lesz a rendszer.


Mivel a legjobbat szeretnénk a felhasználónak, így biztosítünk egy olyan funkciót amely a beírt input alapján kiegészíti az országok nevét, illetve a kívánt helyszín földrajzi nevét. Ehhez az OpenWeather egy JSON fájlt szolgáltat számunkra, mely az alábbi formátomú: 

```json
 {
    "id": 707860,
    "name": "Hurzuf",
    "country": "UA",
    "coord": {
      "lon": 34.283333,
      "lat": 44.549999
    }
```

Ebben a JSON fájlban a világ összes települése megtalálható. Ezen városokat egy Map<String, ArrayList<String>> formátomú Map-ben tároljuk, ahol a String az ország neve, az ArrayList<String> pedig az adott országhoz kapcsolódo országok. A controlsfx (https://github.com/controlsfx/controlsfx) segítségével nagyon egyszerűen létrehozhatjuk ezt az automatikusan kiegészülő listát, ugyanis egy bindAutoCompletion(TextField, Collection<T>) metódust szolgáltat nekünk, ahol az első paraméter az a textField ahová a felhasználó éppen ír, a második pereméter pedig az ajánlásokból álló adat struktúra, az ajánlásokat a létrehozott Mappünkből szedjuk majd ki.  

####  Kliensoldal osztályai:

A Controller packageben található Weather osztály lesz felelős a felhasználókkal való interakciókért. Ez az osztály reagál a felhasználó változtatásaira. Itt fognak meghívásra kerülni a betöltő folyamatok, a törlő folyamatok, illetve a kiíró folyamatok.

### IX. Tesztterv

| Leírás        									|  Várt eset    |
| :-------------:									|:-------------:|
| A felhasználó hibás értéket ad meg bemenetnek (minden esetre)     | Az oldal 404-es hibát dob vissza, a felhasználó tudomást szerez a hibásan beírt értékről |
| A felhasználó meg akarja nyitni az egyik nap részletes adatait | a kiválasztott nap adatait várjuk és nem egy másik napét |
| új    									| új   |   

### X. Telepítési terv

A program platform független. A program futtatásához sükséges hogy telepítve legyen a számítógépre a Java 11.

