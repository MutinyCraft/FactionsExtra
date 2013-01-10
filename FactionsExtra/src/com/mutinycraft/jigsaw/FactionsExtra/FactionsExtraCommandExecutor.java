package com.mutinycraft.jigsaw.FactionsExtra;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.massivecraft.factions.Factions;

public class FactionsExtraCommandExecutor implements CommandExecutor{

	FactionsExtra plugin;
	
	public FactionsExtraCommandExecutor(FactionsExtra pl) {
		plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("factionscore")){
			if(args.length == 1){
				int score = 0;
				int tier = 0;
				try{
					score = plugin.getFactionScore(Factions.i.getByTag(args[0]).getId());
					tier = plugin.getFactionTier(Factions.i.getByTag(args[0]).getId());
				}catch(Exception e){
					score = 0; 
				}
				if (tier >= 1){
					sender.sendMessage(ChatColor.GREEN + args[0] + " has " + score 
							   + " points and is a tier " + tier + " faction." );
				}
				else{
					sender.sendMessage(ChatColor.GREEN + "The score of that faction is not recorded.");
				}
				return true;
			}
			else{
				sender.sendMessage(ChatColor.RED + "Usage: /factionscore [Faction Name]");
				return true;
			}
		}
		return false;
	}
}
