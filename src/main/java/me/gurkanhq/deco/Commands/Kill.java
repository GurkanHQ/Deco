package me.gurkanhq.deco.Commands;

import me.gurkanhq.deco.Deco;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Kill implements CommandExecutor {

    Plugin plugin = Deco.getPlugin(Deco.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getPlayerExact(args[0]);

        String killSelf = plugin.getConfig().getString("killSelf");
        String killTargetNull = plugin.getConfig().getString("killTargetNull");
        String targetKillMessage = plugin.getConfig().getString("targetKillMessage");
        String playerKilledTarget = plugin.getConfig().getString("playerKilledTarget");
        String permissionError = plugin.getConfig().getString("permissionError");
        String senderDisplayName = player.getDisplayName();
        String targetDisplayName = target.getDisplayName();

        if (sender instanceof Player) {

            if (player.hasPermission("deco.kill")) {

                if (args.length == 0) {
                    player.sendMessage(ChatColor.AQUA + killSelf);
                    player.setHealth(0);
                } else {

                    if (target instanceof Player) {
                        target.sendMessage(ChatColor.RED + targetKillMessage + " " + senderDisplayName);
                        target.setHealth(0);
                        player.sendMessage(ChatColor.RED + targetDisplayName + " " + playerKilledTarget);
                    } else {
                        player.sendMessage(ChatColor.RED + killTargetNull);
                    }
                }

            } else {
                player.sendMessage(permissionError);
            }




        }

        return false;
    }
}
