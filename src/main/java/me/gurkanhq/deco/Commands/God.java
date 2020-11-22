package me.gurkanhq.deco.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("deco.god")) {
                if (player.isInvulnerable()) {
                    player.sendMessage(ChatColor.RED + "You are already invulnerable");
                    return false;
                } else {
                    player.sendMessage(ChatColor.GREEN + "You are now invulnerable.");
                    player.setInvulnerable(true);
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
