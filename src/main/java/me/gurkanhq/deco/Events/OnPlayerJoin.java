package me.gurkanhq.deco.Events;

import me.gurkanhq.deco.Deco;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class OnPlayerJoin implements Listener {

    Plugin plugin = Deco.getPlugin(Deco.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        final String displayName = e.getPlayer().getDisplayName();
        String joinMSG = plugin.getConfig().getString("joinMSG");

        e.setJoinMessage(ChatColor.AQUA + joinMSG + " " + ChatColor.GREEN + "[" + displayName + "]");

    }

}
