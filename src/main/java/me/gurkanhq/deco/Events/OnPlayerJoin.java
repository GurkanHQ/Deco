package me.gurkanhq.deco.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        final String displayName = e.getPlayer().getDisplayName();

        e.setJoinMessage(ChatColor.AQUA + "Welcome to the server, " + ChatColor.GREEN + "[" + displayName + "]");

    }

}
