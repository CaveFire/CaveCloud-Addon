package net.cavecloud.gameapi.listeners;

import net.cavecloud.gameapi.Main;
import net.cavecloud.spigot.SpigotApi;
import net.cavecloud.spigot.utils.Server;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private Main main;

    public PlayerQuitListener(Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent playerQuitEvent) {
        Server self = SpigotApi.getSelfServer();
        self.getServerData().setPlayers(Bukkit.getOnlinePlayers().size());

        SpigotApi.updateSelfServerData();
    }
}
