package me.gurkanhq.deco;

import me.gurkanhq.deco.Commands.Feed;
import me.gurkanhq.deco.Commands.God;
import me.gurkanhq.deco.Commands.Kill;
import me.gurkanhq.deco.Commands.VaultCommand;
import me.gurkanhq.deco.Events.OnDeath;
import me.gurkanhq.deco.Events.OnPlayerJoin;
import me.gurkanhq.deco.Events.OnPlayerLeave;
import me.gurkanhq.deco.Events.RestrictPlayerMove;
import org.bukkit.plugin.java.JavaPlugin;

public final class Deco extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("[Deco] Welcome to Deco!");
        // Events
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new RestrictPlayerMove(), this);
        // Commands
        getCommand("god").setExecutor(new God());
        getCommand("feed").setExecutor(new Feed());
        getCommand("kill").setExecutor(new Kill());
        getCommand("vault").setExecutor(new VaultCommand());
        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("[Deco] Shutting down.");
    }
}
