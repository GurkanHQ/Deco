package me.gurkanhq.deco.Events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        final Location location = e.getEntity().getLocation();
        final String playerName = e.getEntity().getDisplayName();
        e.getEntity().sendMessage(ChatColor.AQUA + "Hey ["  + playerName + "], " + "your death location is: " + location);



    }

}
