#Szarvasmarha állomány nyilvántartása

##Adatszerkezet

1. Egyedek (nyilvántartási számok /használati szám, fülszám, leltári szám/,
  születési idő, tenyészetbe vétel, tenyészetből kivétel, ENÁR regisztráció időpontja,
  születési súly, elválasztási súly,
  szájpadlás, szőrszín, szarvalakulás,
  anya, apa)

2. Ivar és korosztály kapcsolata
   - meddig üsző, honnan tehén?
   - hízóbika státusz: hogyan kerül besorolásra?

3. Legeltetés (kezdőidőpont, záróidőpont, legeltetés módja
  -> legelőterület
  -> egyedek
  - % állategység/ha)

4. Kezelések (dátum, név, -> egyedek)

- Figyeljük-e pl. a kötelező oltásokat?

5. Tenyészetből kivétel (dátum, oka -> egyedek -> bevétel(?))

6. Mérlegelés (dátum, tömeg -> egyedek)

7. Tenyészetkód váltás (dátum, honnan, hova, -> egyedek)

8. Vágás, feldolgozás
    _(Ezen még nem gondolkoztam, hogyan legyen)_

###Segédtáblák

Legelőterületek (név, terület)

Állategység (minimum kor, maximum kor, szorzó)

##Kimenetek

- gazdi napló havi állományalakulás
- anyatehén támogatásra beadható állatok listája (hogyan áll elő?)
- aktuális tenyészetkódokhoz tartozó egyedek listája
- legeltetési napló alapadatai

##Kérdések

Mi legyen a borzderesekkel?

Létezik-e olyan, amikor egy boci kikerül a rendszerből, majd később visszakerül. Ha igen, hogyan kezeljük? Jelenleg a fülszámnak egyedinek kell lennie.

Mi alapján kerülnek az egyes legelőterületekre az állatok (korcsoport, ivar, borjas tehenek a borjaikkal, stb.)?

Kényszervágás, pusztulás legyen-e elkülönítve?

##Hibák, fejlesztések

1. Escape osztály ne legyen null, egyelőre kérdés, hogy hogyan.
2. CauseOfEscape is legyen enum.
3. A gazdálkodási napló breed értéke a Breed osztályban ne szövegesen legyen beállítva. A fajták kezelésére ki kell találni a jó megoldást.
4. Validációk kellenek
- szülők nem lehetnek azonosak (de ismeretlen szülők lehetnek)
- szülők fülszáma nem lehet azonos a borjú fülszámával
- nagyállategység kimenet legelőterületeknél: jogszabályoknak való megfelelés ellenőrzése 
5. Algorimusok pontosítása
- Korosításoknál nyílt, vagy zárt intervallumok vannak? (pl. 24. vagy 25. hónap elején válik felnőtté)?
- Hogyan számoljuk ki a legeltetési nyomást? Kezdőidőpont, záróidőpont, esetleg minden nap átlaga?
  Jelenleg ez utóbbi, illetve egy megadható dátum alapján van implementálva.
6. Az állományváltozás metódusaira további tesztek kellenek.