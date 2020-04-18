package ru.lion;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic

        //Setup Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("tpbow").setExecutor(new TeleportBowCommand(this));

        getServer().getPluginManager().registerEvents(new TeleportBowEvent(this), this);
        getServer().getPluginManager().registerEvents(new SpawnEvent(this), this);
    }

    public void giveBow(Player player){
        ItemStack teleport_bow = new ItemStack(Material.BOW);
        ItemMeta meta = teleport_bow.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("bow-name")));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("bow-description")));
        meta.setLore(lore);
        teleport_bow.setItemMeta(meta);
        teleport_bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 666);
        player.getInventory().addItem(teleport_bow);
    }}
