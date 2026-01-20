# Withered Foxy Jumpscare Mod

Egy Minecraft 1.21.1 Fabric mod, amely véletlenszerű Withered Foxy jumpscare mechanikát valósít meg.

## Funkciók

- **Véletlenszerű megjelenés**: 1/1000 esély másodpercenként a jumpscare aktiválódására
- **Teljes képernyős GIF megjelenítés**: A jumpscare aktiválásakor teljes képernyős overlay jelenik meg
- **Hangeffekt**: OGG hangfájl lejátszása a jumpscare során
- **Automatikus bezárás**: 4 másodperc után automatikusan bezáródik (vagy ESC billentyűvel manuálisan)

## Telepítés

1. Telepítsd a [Fabric Loader](https://fabricmc.net/use/installer/)-t Minecraft 1.21.1-hez
2. Telepítsd a [Fabric API](https://modrinth.com/mod/fabric-api)-t
3. Töltsd le a mod JAR fájlját
4. Helyezd a JAR fájlt a `.minecraft/mods` mappába
5. **FONTOS**: Cseréld le a placeholder fájlokat a saját jumpscare asseteiddel (lásd lentebb)

## Saját Jumpscare Beállítása

A mod alapértelmezetten placeholder fájlokat tartalmaz. A valódi jumpscare élményhez cseréld le ezeket a saját fájljaidra:

### 1. Jumpscare Kép Lecserélése

1. Nyisd meg a mod JAR fájlt egy ZIP programmal (pl. WinRAR, 7-Zip)
2. Navigálj ide: `assets/withered_foxy_jumpscare/textures/gui/`
3. Cseréld le a `jumpscare.png` fájlt a saját jumpscare képeddel
   - **Formátum**: PNG
   - **Ajánlott méret**: Minél nagyobb, annál jobb (pl. 1920x1080 vagy nagyobb)
   - **Megjegyzés**: A mod automatikusan átméretezi teljes képernyőre

### 2. Jumpscare Hang Lecserélése

1. Nyisd meg a mod JAR fájlt egy ZIP programmal
2. Navigálj ide: `assets/withered_foxy_jumpscare/sounds/`
3. Cseréld le a `jumpscare.ogg` fájlt a saját jumpscare hangfájloddal
   - **Formátum**: OGG Vorbis (kötelező!)
   - **Konvertálás**: Használd az [Audacity](https://www.audacityteam.org/)-t vagy online konvertert MP3-ról OGG-re
   - **Ajánlott hossz**: 3-5 másodperc

### Alternatív Módszer: Forráskód Szerkesztése

Ha módosítani szeretnéd a modot újrafordítás előtt:

1. Klónozd a repository-t
2. Cseréld le a fájlokat itt:
   - Kép: `src/main/resources/assets/withered_foxy_jumpscare/textures/gui/jumpscare.png`
   - Hang: `src/main/resources/assets/withered_foxy_jumpscare/sounds/jumpscare.ogg`
3. Építsd újra a modot: `./gradlew build`
4. A kész JAR a `build/libs/` mappában lesz

## Beállítások Módosítása

A jumpscare gyakoriságát és időtartamát a forráskódban módosíthatod:

### Gyakoriság módosítása
`WitheredFoxyJumpscareClient.java` fájlban:
```java
private static final int JUMPSCARE_CHANCE = 1000; // Változtasd ezt az értéket
// Kisebb szám = gyakoribb jumpscare (pl. 100 = 1/100 esély)
// Nagyobb szám = ritkább jumpscare (pl. 5000 = 1/5000 esély)
```

### Időtartam módosítása
`JumpscareScreen.java` fájlban:
```java
private static final int DISPLAY_DURATION = 80; // 80 tick = 4 másodperc
// 20 tick = 1 másodperc
// Példa: 100 = 5 másodperc, 60 = 3 másodperc
```

## Fordítás

```bash
# Windows
gradlew.bat build

# Linux/Mac
./gradlew build
```

A lefordított mod JAR fájl a `build/libs/` mappában található.

## Rendszerkövetelmények

- Minecraft Java Edition 1.21.1
- Fabric Loader 0.16.0 vagy újabb
- Fabric API
- Java 21 vagy újabb

## Használat Játékban

- A jumpscare véletlenszerűen aktiválódik játék közben (1/1000 esély másodpercenként)
- Csak akkor aktiválódik, ha aktívan játszol (nem szüneteltetés alatt)
- Az ESC billentyűvel bármikor bezárhatod a jumpscare képernyőt
- A mod nem befolyásolja a játékmenetet, csak vizuális/hang effekt

## Hibakeresés

### A hang nem játszódik le
- Ellenőrizd, hogy a hangfájl OGG Vorbis formátumú-e (nem MP3!)
- Próbáld újrakonvertálni Audacity-vel: File → Export → Export as OGG

### A kép nem jelenik meg
- Ellenőrizd, hogy a kép PNG formátumú-e
- Próbálj kisebb méretű képet használni (max 4096x4096)

### A jumpscare nem aktiválódik
- Ez normális - 1/1000 esély másodpercenként, tehát átlagosan ~16 percenként egyszer
- Teszteléshez csökkentsd a `JUMPSCARE_CHANCE` értékét 10-re a kódban

## Licenc

MIT License - szabadon használható, módosítható és terjeszthető.

## Készítette

BordasDaniel

## Köszönetnyilvánítás

- Fabric fejlesztőcsapat a Fabric API-ért
- Minecraft modding közösség
