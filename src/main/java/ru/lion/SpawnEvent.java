package ru.lion;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnEvent implements Listener {

    Main plugin;

    public SpawnEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawnEvent(PlayerJoinEvent e){
        if (plugin.getConfig().getBoolean("give-bow-on-join")){
            Player player = e.getPlayer();
            if (player.hasPermission("tpbow.join")) {
                plugin.giveBow(player);
            }
        }
    }

}
