# Building the Mod

## Prerequisites

- Java 21 or newer
- Internet connection (for downloading dependencies)
- Gradle 8.8 (included via wrapper)

## Standard Build Process

```bash
# Linux/Mac
./gradlew build

# Windows
gradlew.bat build
```

The compiled JAR file will be in `build/libs/`

## Network Issues

If you encounter network issues accessing `maven.fabricmc.net`, this is typically a DNS or firewall issue. Try:

1. **Check your internet connection**
2. **Use a VPN** if the domain is blocked in your region
3. **Wait and retry** - sometimes the Maven repository is temporarily unavailable
4. **Use a mirror** (advanced): Configure a Fabric mirror in your Gradle settings

## Build Output

After a successful build, you'll find:
- `withered-foxy-jumpscare-1.0.0.jar` - The main mod file
- `withered-foxy-jumpscare-1.0.0-sources.jar` - Source code archive

## Troubleshooting

### "Could not resolve net.fabricmc:fabric-loom"
This means Gradle cannot access the Fabric Maven repository. Ensure you have internet access and the domain is not blocked.

### Java version errors
Make sure you're using Java 21 or newer:
```bash
java -version
```

### Gradle daemon issues
Try with:
```bash
./gradlew build --no-daemon
```

## IDE Setup

### IntelliJ IDEA
1. Open the project folder
2. IDEA will automatically detect it as a Gradle project
3. Wait for dependency download to complete
4. Run configurations will be created automatically

### Eclipse
1. Install the Buildship Gradle plugin
2. Import → Existing Gradle Project
3. Select the project folder
4. Wait for dependency download

### VS Code
1. Install the Java Extension Pack
2. Install the Gradle for Java extension
3. Open the project folder
4. Gradle will sync automatically

## Development

To run Minecraft with the mod for testing:
```bash
./gradlew runClient
```

This will launch Minecraft with the mod loaded.
