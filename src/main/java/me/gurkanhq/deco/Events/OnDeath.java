package me.gurkanhq.deco.Events;

import me.gurkanhq.deco.Deco;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class OnDeath implements Listener {

    Plugin plugin = Deco.getPlugin(Deco.class);

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        String deathLocationMsg = plugin.getConfig().getString("deathLocationMsg");

        final Location location = e.getEntity().getLocation();
        final String playerName = e.getEntity().getDisplayName();
        e.getEntity().sendMessage(ChatColor.AQUA + "[" + playerName + "], " + deathLocationMsg + " " + location);



    }

}
