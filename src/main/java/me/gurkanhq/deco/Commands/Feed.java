package me.gurkanhq.deco.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("deco.feed")) {
                if (player.getFoodLevel() == 20) {
                    player.sendMessage(ChatColor.RED + "You are already at max food level");
                    return false;
                } else {
                    player.sendMessage(ChatColor.GREEN + "You are now at max food level.");
                    player.setFoodLevel(20);
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
            }

        } else {
            sender.sendMessage("Hey there console, you can't do that");
        }


        return false;
    }
}
