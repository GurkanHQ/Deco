package me.gurkanhq.deco.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLeave implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        final String displayName = e.getPlayer().getDisplayName();

        e.setQuitMessage(ChatColor.AQUA + "Hope we see you sometime soon, " + ChatColor.GREEN + "[" + displayName + "]");

    }

}
