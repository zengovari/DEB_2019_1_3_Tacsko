# Funkcionális specifikáció
Időjárás előre jelző program
------

#### I. Bevezetés

Egy öregotthon számára kell egy minél egyszerűbben használható időjárás előre jelző programot készíteni a könyvtári számítógépen való használatra, amivel meg tudják nézni az időjárást akár több napos előrejelzéssel is, hogy tudják hogyan tervezzék meg a napjaikat, az akkori időjárás viszonyoktól függően.

#### II. Jelenlegi helyzet

Jelenleg az öregotthon lakóinak nincs kényelmes módjuk a jelenlegi időjárás, illetve az 5 napos előrejelzés megtekintésére, hiszen nem mindenki rendelkezik okostelefonnal, a televízióban, illetve rádióban hallható időjárás jelentések csak bizonyos időpontokban érhető el, vagy az is előfordulhat, hogy rossz időjárás körülmények között a rádió nem képes csatornákat fogni, mivel az idős otthon hegyvidéken található, az internet használata és az azon elérhető weboldalak használata pedig bonyolult számukra, sokan hozzá se mernek nyúlni attól félve, hogy elrontják és majd a hozzátartozóik kell kifizessék. Előfordult már, hogy a lakók el akarták hagyni az otthont egy sétára, vagy találkozni az ismerőseikkel, de mivel nem tudták milyen lesz aznap az időjárás így nem mertek elmenni. A gondozóiknak meg csak utólagosan mesélik el panaszaikat, így sajnos nem tudnak rajtuk segíteni. Ezenkívül, ha az alkalmazottakat keresik fel minden alkalommal az időjárással kapcsolatos kérdéseikkel akkor, lehetséges, hogy a gondozók hibákat fognak véteni a napi feladataik elvégzésében, komoly anyagi és szellemi károkat okozva. A legrosszabb esetben akár az is megtörténhet, hogy az ablakon keresztül próbálják az időjárását megtudakolni az utcán járó emberektől és így áteshetnek az ablakon, ami komoly fizikai sérülésekkel járhat. Így szükség van egy olyan magyar nyelvű szoftverre, amelynek kezelése rendkívül egyszerű és minél átláthatóbb módon írja ki a kívánt helyszín (jelenlegi vagy a felhasználó által megadott) jelenlegi időjárását vagy az 5 napos előrejelzését.

#### III. Vágyálomrendszer leírása

Egy olyan programot szeretnénk alkotni, amely magyar nyelvű, hiszen a felhasználók nem valószínű, hogy tudnak idegennyelven írni, olvasni, illetve használata annyira egyszerű, hogy a számítógépek világában nem jártasok is képesek legyenek használni. Fontos szempont lenne, hogy a program képes legyen több napos időjáráselőrejelzésre, illetve az aktuális időjárás megállapítására. Opcionális módon lehetséges lenne, hogy a szélsőséges időjárásra figyelmeztessen: vihar, jégeső, stb. Nagy segítség lenne a lakóknak, ha minél kevesebb művelettel meg tudnák nézni az időjárást, mert gyakran előfordul, hogy abbahagyják, amit elkezdtek, ha bármilyen kényelmetlenséget éreznek, vagy túlságosan nehéznek vélik a feladatot. Megkönnyítené az idősek dolgát, ha esetlegesen a képernyővédőn is kiírná az időjárást, hogy amikor senki sem használja akkor elég legyen mellette elmenniük az időseknek és egy szimpla ránézéssel láthassák az időjáráselőrejelzést.


#### IV. Jelenlegi üzleti folyamatok modellje

- Megérkeznek a lakók -> Várnak estig az időjárás jelentésig -> Megtudják az időjárást

  vagy

- Megérkeznek a lakók -> Keresnek egy olyan alkalmazottat, akinek okostelefonja van -> megkérdezik tőle az időjárást -> az alkalmazott válaszol

  vagy

- Megérkeznek a lakók -> Az ablakon át kérdezgetik a járókelőket az időjárásról -> az 5-10 ember közül az egyik lehet, hogy válaszol

  vagy

- Megérkeznek a lakók -> Elindítják a rádiót és megvárják amíg a csatorna tart egy időjárás előrejelzést -> Megtudják az időjárást.

#### V. Igényelt üzleti folyamatok modellje

A lakók igénye az, hogy a könyvtárban elérhető számítógépen legyen egy olyan rendkívül egyszerűen használható és áttekinthető szoftver, amely használatával bárki és bármikor megtudja tekinteni a gondozók segítsége nélkül, saját képességeiket felhasználva, a jelenlegi időjárás viszonyokat, illetve az 5 napos előrejelzést annak érdekében, hogy előre tudják tervezni a napjaikat, családi programjaikat, utazásaikat.
