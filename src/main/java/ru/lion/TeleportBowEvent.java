package ru.lion;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TeleportBowEvent implements Listener {

    Main plugin;

    public TeleportBowEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBowShoot(ProjectileHitEvent e){
        Player player = (Player) e.getEntity().getShooter();
        Location location = e.getEntity().getLocation();

        e.getEntity().remove();

        location.setYaw(player.getLocation().getYaw());
        location.setPitch(player.getLocation().getPitch());

        player.teleport(location);
        player.playSound(location, Sound.ENTITY_ENDERDRAGON_AMBIENT, 1.0F, 1.0F);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-message")));
    }

}
