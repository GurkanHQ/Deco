package me.gurkanhq.deco.Events;

import me.gurkanhq.deco.Deco;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class OnPlayerLeave implements Listener {

    Plugin plugin = Deco.getPlugin(Deco.class);

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        final String displayName = e.getPlayer().getDisplayName();
        String leaveMSG = plugin.getConfig().getString("leaveMSG");

        e.setQuitMessage(ChatColor.AQUA + leaveMSG + " " + ChatColor.GREEN + "[" + displayName + "]");

    }

}
