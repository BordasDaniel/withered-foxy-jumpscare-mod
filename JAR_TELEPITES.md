# JAR Fájl Telepítési Útmutató

## ⚠️ FONTOS - Ne nevezd át a ZIP fájlt JAR-ra!

A repository ZIP fájlját **nem lehet** egyszerűen átnevezni JAR-ra. A JAR fájlt a Gradle build rendszerrel kell elkészíteni.

## 📦 Módszer 1: Saját építés (Ajánlott)

### Előkövetelmények:
- Java 21 vagy újabb ([Letöltés](https://adoptium.net/))
- Internetkapcsolat
- Git (opcionális)

### Lépések:

1. **Töltsd le a repository-t**
   - Kattints a zöld "Code" gombra a GitHub-on
   - Válaszd a "Download ZIP" opciót
   - Csomagold ki egy mappába (pl. `C:\withered-foxy-jumpscare`)

2. **Ellenőrizd a Java verziót**
   ```cmd
   java -version
   ```
   Minimum Java 21 szükséges!

3. **Navigálj a projekt mappába**
   ```cmd
   cd C:\withered-foxy-jumpscare
   ```

4. **Cseréld le a placeholder fájlokat** (MIELŐTT építesz!):
   - `src/main/resources/assets/withered_foxy_jumpscare/textures/gui/jumpscare.png`
     → A saját jumpscare képed (PNG formátum)
   - `src/main/resources/assets/withered_foxy_jumpscare/sounds/jumpscare.ogg`
     → A saját jumpscare hangod (OGG Vorbis formátum, NEM MP3!)

5. **Építsd meg a JAR fájlt**
   
   Windows:
   ```cmd
   gradlew.bat build
   ```
   
   Linux/Mac:
   ```bash
   ./gradlew build
   ```

6. **Keresd meg a kész JAR fájlt**
   
   A JAR fájl itt lesz:
   ```
   build/libs/withered-foxy-jumpscare-1.0.0.jar
   ```

7. **Másold a Minecraft mods mappába**
   ```
   C:\Users\<Felhasználónév>\AppData\Roaming\.minecraft\mods\
   ```
   vagy az ATLauncher esetében:
   ```
   C:\Users\<Felhasználónév>\AppData\Roaming\ATLauncher\instances\<instance_név>\mods\
   ```

## 🤖 Módszer 2: GitHub Actions (Automatikus)

Ha nem szeretnél helyben építeni, használd a GitHub Actions-t:

1. Fork-old a repository-t a saját GitHub fiókodba
2. Cseréld le a placeholder fájlokat a web felületen keresztül
3. Menj a "Actions" fülre
4. Kattints a "Build Fabric Mod" workflow-ra
5. Kattints "Run workflow" → "Run workflow"
6. Várj pár percet amíg lefut
7. Töltsd le a JAR fájlt az Artifacts szekcióból

## 🔧 Hibaelhárítás

### "Could not resolve net.fabricmc:fabric-loom"
- Ellenőrizd az internetkapcsolatot
- Próbáld újra később (a Fabric Maven szerver néha lassú)
- Használj VPN-t ha a domain blokkolva van

### "java: error: invalid source release: 21"
- Frissítsd a Java-t 21-re vagy újabbra
- Futtasd: `java -version` hogy ellenőrizd

### "Process finished with exit code 1"
- Nézd meg a teljes hibaüzenetet
- Ellenőrizd, hogy a placeholder fájlok helyesek-e
- Futtasd újra: `gradlew.bat clean build`

## 📝 Miért nem működik az átnevezés?

Egy JAR fájl egy speciális ZIP formátum, ami tartalmazza:
- Lefordított Java osztályokat (.class fájlok)
- Erőforrás fájlokat
- META-INF/MANIFEST.MF metaadatokat
- Fabric mod metaadatokat

A nyers forráskód ZIP-je ezeket nem tartalmazza - csak a Java forrás fájlokat (.java). A Gradle build folyamat:
1. Lefordítja a Java kódot
2. Becsomagolja az erőforrásokat
3. Létrehozza a megfelelő metaadatokat
4. Elkészíti a végleges JAR fájlt

## ✅ Ellenőrzés

Hogy megbizonyosodj, hogy jó JAR fájlod van:
1. A fájl mérete nagyobb, mint 50 KB
2. A fájl neve: `withered-foxy-jumpscare-1.0.0.jar`
3. ZIP programmal megnyitva látod a `com/bordas/withered_foxy_jumpscare/*.class` fájlokat
4. Minecraft betöltésnél nem jelenik "zip END header not found" hiba

## 📞 További Segítség

Ha továbbra sem működik:
1. Ellenőrizd, hogy Java 21+ van telepítve
2. Futtasd: `gradlew.bat clean` majd `gradlew.bat build`
3. Nézd meg a teljes build log-ot hibák után kutatva
4. Győződj meg róla, hogy internetkapcsolatod van
