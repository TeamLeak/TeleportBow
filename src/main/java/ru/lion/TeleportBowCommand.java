package ru.lion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportBowCommand implements CommandExecutor {

    Main plugin;

    public TeleportBowCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("tpbow.spawnbow")){
                plugin.giveBow(player);
            }else{
                player.sendMessage("You do not have the permissions required to execute this.");
            }
        }

        return true;
    }
}
