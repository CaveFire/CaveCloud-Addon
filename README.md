# CaveCloud-Addon
CaveCloud Addon - Compatible with CaveCloud Version 2.0 or newer.

**Purpose:**

Submit gamedata such as playercount, motd and maxplayers to the cloud with the GameAPI.

**Config file:**

Set the values in the config file, which creates it self, after running the server with the plugin installed.

**Default config:**

```yaml
# Name of the gamestate, which you can add / edit in the "Signs" tab in the webinterface.
gamestate: ONLINE
# Number of max players.
maxPlayers: 10
# Custom message like mapname.
motd: 'Message or map'
```

**Compile it your own and change it:**

First you have to download the api, which you get while typing "api download" in the console of your Cloud. A zip with a file called "Spigot.jar" will be downloaded.
This file you have to link to your project as a libary.

Also you have to link a Bukkit, Spigot, etc. server jar file as a libary as well.