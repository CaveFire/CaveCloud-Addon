package net.cavecloud.gameapi;

import net.cavecloud.gameapi.listeners.PlayerJoinListener;
import net.cavecloud.gameapi.listeners.PlayerQuitListener;
import net.cavecloud.spigot.SpigotApi;
import net.cavecloud.spigot.utils.Server;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private String gamestate;
    private int maxPlayers;
    private String motd;

    @Override
    public void onEnable() {
        loadConfig();

        // Wait a few seconds to be sure, that the api is loaded.
        Bukkit.getScheduler().runTaskLater(this, new Runnable() {
            @Override
            public void run() {
                registerListener();
                updateData();

                System.out.println("CaveCloud Addon loaded!");
            }
        }, 1000 * 2);
    }

    @Override
    public void onDisable() {
        System.out.println("CaveCloud Addon unloaded!");
    }

    public void registerListener() {
        new PlayerJoinListener(this);
        new PlayerQuitListener(this);
    }

    /*
    Loading data from config file.
     */
    public void loadConfig() {
        this.gamestate = getFromConfig("gamestate", "ONLINE");
        this.maxPlayers = Integer.valueOf(getFromConfig("maxPlayers", "0"));
        this.motd = getFromConfig("motd", "Message or Map");
    }

    /*
    Sending updated data to the cloud with the api.
     */
    public void updateData() {
        Server self = SpigotApi.getSelfServer();
        self.getServerData()
                .setPlayers(Bukkit.getOnlinePlayers().size())
                .setGameState(SpigotApi.getGamestate(this.gamestate))
                .setMaxplayers(this.maxPlayers)
                .setMotd(motd);

        SpigotApi.updateSelfServerData();
    }

    /*
    Getting values from config file with default value.
     */
    private String getFromConfig(String path, String defaultValue) {
        if (this.getConfig().contains(path)) {
            return this.getConfig().getString(path);
        } else {
            this.getConfig().set(path, defaultValue);
            this.saveConfig();
            return defaultValue;
        }
    }
}
