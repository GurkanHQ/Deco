package me.gurkanhq.deco.Commands;

import me.gurkanhq.deco.Deco;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = Deco.getPlugin(Deco.class);

        String notHungryMSG = plugin.getConfig().getString("notHungryMSG");
        String fedMSG = plugin.getConfig().getString("fedMSG");
        String permissionError = plugin.getConfig().getString("permissionError");

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("deco.feed")) {
                if (player.getFoodLevel() == 20) {
                    player.sendMessage(ChatColor.RED + notHungryMSG);
                    return false;
                } else {
                    player.sendMessage(ChatColor.GREEN + fedMSG);
                    player.setFoodLevel(20);
                }
            } else {
                player.sendMessage(ChatColor.RED + permissionError);
            }

        } else {
            sender.sendMessage("Hey there console, you can't do that");
        }


        return false;
    }
}
