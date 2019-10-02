
## Tesztelési jegyzőkönyv

Az alábbi dokumentum azt a célt szolgálja, hogy teszteljük azt, hogy hogyan reagál a projektünk más felhasználói környezetekben, és, hogy ezeknek a teszteknek az eredményét rögzitsük le.

### Ubuntu 18.04.3 64 bit

-   Java verzió: OpenJDK 11
-   Maven verzió: Apache Maven 3.6.0
-   CPU: Intel Core i5-7200U
-   RAM: 2 GB

| Sorszám | Teszt leírása | Eredmény |
|:-------------:|:-------------:|:-------------:|
|1|A felhasználó fullscreenbe nyitotta meg az alkalmazást. | A grafikus felületen elhelyezett elemek megfelelően látszódtak. |
|2|A felhasználó ablakos üzemmódba nyitotta meg az alkalmazást. | A grafikus felületen elhelyezett elemek megfelelően látszódtak. |
|3|A felhasználó hibás helyszínt adott meg. | A grafikus felületen megjelent egy hibaüzenet ami tájékoztatta a felhasználót a hibásan beírt helyszínről. |
|4|A felhasználó hibás irányítószámot adott meg.| A grafikus felületen megjelent egy hibaüzenet ami tájékoztatta a felhasználót a hibásan beírt irányítószámról. |
|5|A felhasználó hibás földrajzi koordinátákat ad meg. | A grafikus felületen megjelent egy hibaüzenet ami tájékoztatta a felhasználót a hibásan beírt koordinátákról.|
|6| A felhasználó megnyitotta az egyik nap részletes adatait.| A kiválasztott nap adatai megjelentek és nem egy másik napé. |
|7| A felhasználó megnyitotta az egyik óra részletes adatait.| A kiválasztott óra részletes adatai megjelentek és nem egy másik óráe. |
|8 | A felhasználó egy új települést adott meg, felülírva a régit. | A grafikus felületen az ablakok frissültek az új helyszínnek megfelelően. |
|9| A felhasználó egy új irányitószámot adott meg, felülírva a régit.| A grafikus felületen az ablakok frissültek az új helyszínnek megfelelően. |
|10 | A felhasználó egy új koordinátát adott meg, felülírva a régit.| A grafikus felületen az ablakok frissültek az új helyszínnek megfelelően. |
