package me.xemu.ridejoeenderpearl;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.projectiles.ProjectileSource;

public final class RideJoeEnderpearl extends JavaPlugin implements CommandExecutor, Listener {

    @Override public void onEnable()
    {

        getLogger().info("Plugin was enabled");

        getServer().getPluginManager().registerEvents(this, this);

    };

    @Override public void onDisable()
    {

        getLogger().info("Plugin was disabled");

    };

    @EventHandler public void onInteractEvent(ProjectileLaunchEvent e)
    {

        Entity enderpearl = (EnderPearl) e.getEntity();

        ProjectileSource projectileSource = e.getEntity().getShooter();
        if(projectileSource instanceof Player)
        {
            Player player = (Player) projectileSource;
            enderpearl.addPassenger(player);
        };

    };

};
