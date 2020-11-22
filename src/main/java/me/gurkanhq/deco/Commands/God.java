package me.gurkanhq.deco.Commands;

import me.gurkanhq.deco.Deco;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = Deco.getPlugin(Deco.class);

        String alreadyInvulnerable = plugin.getConfig().getString("alreadyInvulnerable");
        String nowInvulnerable = plugin.getConfig().getString("nowInvulnerable");
        String permissionError = plugin.getConfig().getString("permissionError");

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("deco.god")) {
                if (player.isInvulnerable()) {
                    player.sendMessage(ChatColor.RED + alreadyInvulnerable);
                    return false;
                } else {
                    player.sendMessage(ChatColor.GREEN + nowInvulnerable);
                    player.setInvulnerable(true);
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
