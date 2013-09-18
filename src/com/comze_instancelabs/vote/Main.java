package com.comze_instancelabs.vote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
//import org.bukkit.material.Sign;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;



/**
 * 
 * @author instancelabs
 *
 */

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		//getConfig().addDefault("link", ""); // bit.ly/17LrwBq
		getConfig().options().header("You can add unlimited lines");
		getConfig().addDefault("info0", "§"); 
		
		getConfig().options().copyDefaults(true);
		//this.saveDefaultConfig();
		this.saveConfig();
		
		getLogger().info("hey, finished");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("votes")){
			Player p = (Player) sender;
			if(args.length > 0){
				String action = args[0];
				if(action.equalsIgnoreCase("info")){
					ArrayList<String> keys = new ArrayList<String>();
			        keys.addAll(getConfig().getKeys(false));
			        keys.remove("link");
			        for(int i = 0; i < keys.size(); i++){
			            p.sendMessage(getConfig().getString("info" + Integer.toString(i)));
			        }
				}else if(action.equalsIgnoreCase("reload")){
					if(sender.hasPermission("votes.reload")){
						this.reloadConfig();
						sender.sendMessage("§2Votes config successfully reloaded.");
					}else{
						sender.sendMessage("§4Votes config successfully reloaded.");
					}
				}
			}else{
				ArrayList<String> keys = new ArrayList<String>();
		        keys.addAll(getConfig().getKeys(false));
		        keys.remove("link");
		        for(int i = 0; i < keys.size(); i++){
		            p.sendMessage(getConfig().getString("info" + Integer.toString(i)));
		        }
			}
			
			/*p.sendMessage("§eReward: 500D, 2 Diamonds and 820 XP");
			p.sendMessage("§2http://bit.ly/DrVoteMCMP");
			p.sendMessage("§2http://bit.ly/DrVoteMcss");
			p.sendMessage("§2http://bit.ly/DrVoteMs");
			p.sendMessage("§2http://bit.ly/17VY8Jp");
			p.sendMessage("§2http://bit.ly/13Jnr0i");
			p.sendMessage("§2http://bit.ly/DrVoteMCSL");*/
        	
			return true;
		}
		return false;
	}
}
