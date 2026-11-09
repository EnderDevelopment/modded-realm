# Minecraft Server Mod: Modded Realm

Modded Realm is a server-side Fabric Minecraft mod for Minecraft 1.21.1 that adds spawn management commands and a welcome message. Players can use `/spawn` to return to the overworld spawn point, operators can use `/setspawn` to update it, and clients do not need the mod installed.

## Install

1. Install Minecraft 1.21.1 with Fabric Loader 0.16.5 or newer.
2. Install Fabric API 0.107.0+1.21.1 or newer on the server.
3. Make sure the server uses Java 21.
4. Build the mod from the project directory:

   ```bash
   ./gradlew build
   ```

5. Copy the generated `build/libs/server-toolkit-1.0.0.jar` file into the server's `mods` folder.
6. Start or restart the server.

## Use

1. Join the server. The mod sends players a welcome message explaining the `/spawn` command.
2. Use `/spawn` as a player to teleport to the overworld spawn point.
3. Stand at the desired location and use `/setspawn` as an operator with permission level 2 or higher.
4. Players can use `/spawn` to return to the updated spawn location.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/c3a99ed0-1f24-4aa6-bf52-6f3ed9ce6146?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=c3a99ed0-1f24-4aa6-bf52-6f3ed9ce6146
