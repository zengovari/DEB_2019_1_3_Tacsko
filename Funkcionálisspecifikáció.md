# Funkcionális specifikáció
Időjárás előrejelző program
------

#### I. Bevezetés

Egy öregotthon számára kell egy minél egyszerűbben használható időjáráselőrejelző programot készíteni a könyvtári számítógépen való használatra amivel meg tudják nézni az ídőjárást akár több napos előrejelzéssel is, hogy tudják hogyan tervezzék meg a napjaikat, az akkori ídőjárásvisszonyoktól függően.

#### II. Jelenlegi helyzet

Jelenleg az öregotthon lakóinak nincs kényelmes módjuk a jelenlegi időjárás, illetve az 5 napos előrejelzés megtekintésére, hiszen nem mindenki rendelkezik okostelefonnal, a televízióban, illetve rádióban hallható időjárás jelentések csak bizonyos időpontokban érhető el, vagy az is előfordulhat, hogy rossz ídőjáráskörülmények között a rádió nem képes csatornákat fogni, mivel az ídősotthon hegyvidéken található, az internet használata és az azon elérhető weboldalak használata pedig bonyolult számukra, sokan hozzá se mernek nyúlni attól félve, hogy elrontják és majd a hozzátartozóik kell kifezessék. Előfordult már, hogy a lakók el akarták hagyni az otthont egy sétára, vagy találkozni az ismerőseikkel, de mivel nem tudták milyen lesz aznap az időjárás így nem mertek elmenni. A gondozóiknak meg csak útólagosan mesélik el panaszaikat, így sajnos nem tudnak rajtuk segíteni. Ezenkívül ha az alkalmazottakat keresik fel minden alkalommal az időjárással kapcsolatos kérdéseikkel akkor, lehtséges hogy a gondozók hibákat fognak véteni a napi feladataik elvégzésében, komoly anyagi és szellemi károkat okozva. A legrosszabb esetben akár az is megtörténhet hogy az ablakon keresztül próbálják az időjárását megtudakolni az utszán járó emberektől és így áteshetnek az ablakon, ami komoly fizikai sérülésekkel járhat. Így szükség van egy olyan magyar nyelvü szoftverre amelynek kezelése rendkívül egyszerű és minél átláthatóbb módon írja ki a kívánt helyszín (jelenlegi vagy a felhasználó által megadott) jelenlegi időjárását vagy az 5 napos előrejelzését.

#### III. Vágyálomrendszer leírása

Egy olyan programot szeretnénk alkotni amely magyar nyelvű, hiszen a felhasználók nem valószínű hogy tudnak idegennyelven írni, olvasni, illetve használata anyira egyszerü hogy a számítógépek világaban nem járasak is képesek legyenek használni. Fontos szempont lenne hogy a program képes legyen több napos időjáráselőrejelzésre, illetve az aktuális időjárás megállapítására. Opcionális módon lehetséges lenne hogy a szélsőséges időjárásra figyelmeztessen: vihar, jégeső, stb. Nagy segítség lenne a lakóknak, ha minél kevesebb művelettel meg tudnák nézni az ídőjárást, mert gyakran előfordul, hogy abbahagyják amit elkezdtek ha bármilyen kényelmetlenséget éreznek, vagy túlságosan neheznék veszik a feladatot. Megkönnyitené az idősek dolgát ha esetlegesen a képernyővédőn is kiirná az ídőjárást, hogy amikor senki sem használja akkor elég legyen mellette elmenniük az időseknek és egy szimpla ránézéssel láthassák az időjáráselőrejelzést.


#### IV. Jelenlegi üzleti folyamatok modellje

- Megérkeznek a lakók -> Várnak estig az időjárás jelentésig -> Megtudják az időjárást
  
  vagy
  
- Megérkeznek a lakók -> Keresnek egy olyan alkallmazottat akinek okostelefonja van -> megkérdezik tőle az időjárást -> az alkalmazott válaszol
  
  vagy
  
- Megérkeznek a lakók -> Az ablakon át kérdezgetik a járókelőket az időjárásról -> az 5-10 ember közül az egyik lehet hogy válaszol
  
  vagy
  
- Megérkeznek a lakók -> Elinditják a rádiót és megvárják amíg a csatorna tart egy ídőjáráselőrejelzést -> Megtudják az ídőjárást.

#### V. Igényelt üzleti folyamatok modellje

A lakók igénye az, hogy a könyvtárban elérhető számítógépen legyen egy olyan rendkívül egyszerűen használható és áttekinthető szoftver, amely használatával bárki és bármikor megtudja tekinteni a gondózók segítsége nélkül, saját képességeiket felhasználva, a jelenlegi időjárás viszonyokat, illetve az 5 napos előrejelzést annak érdekében, hogy előretudják tervezni a napjaikat, családi programjaikat, utazásaikat.
