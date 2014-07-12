package com.thieding.tyler;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SimplisticSpawn extends JavaPlugin
{
	Logger log;
	 
	public void onEnable()
	{
		log = this.getLogger();
		log.info("SimplisticLocation Has Been Enabled Successfully!");
		log.info("This plugin is a Christmas gift to my friend, zyptie.");
	}
 
	public void onDisable()
	{
		log.info("SimplisticLocation Has Been Disabled Successfully!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("spawn"))
		{
			if(sender instanceof Player)
			{
				Player spawner = (Player) sender;
				Location spawnarea = spawner.getPlayer().getWorld().getSpawnLocation();
				spawnarea.setY(spawnarea.getY() + 2);
				spawner.getWorld().createExplosion(spawner.getLocation(), 0);
				spawner.teleport(spawnarea);
				sender.sendMessage("You have been smokescreened to spawn!");
			}
			else
			{
				log.info("This is a player-only command as the server cannot move!");
			}
		}
		if (cmd.getName().equalsIgnoreCase("bed"))
		{
			if (sender instanceof Player)
			{
				Player spawner = (Player) sender;
				if(spawner.getBedSpawnLocation() != null)
				{
					World world = spawner.getWorld();
					sender.sendMessage("You have been smokescreened to your bed!");
					Location bedarea = spawner.getBedSpawnLocation();
					bedarea.setY(bedarea.getY() + 2);
					world.createExplosion(spawner.getLocation(), 0);
					spawner.teleport(bedarea);
				}
				else
				{
					sender.sendMessage("Error: You do not have a set bed");
				}
			}
			else
			{
				sender.sendMessage("This is a player-only command as the server cannot move!");
			}		
		}
		return true;
	}
}
