package com.mutinycraft.jigsaw.FactionsExtra;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.massivecraft.factions.Faction;
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
				String fName = null;
				try{
					Faction f = Factions.i.getByTag(args[0]);
					score = plugin.getFactionScore(f.getId());
					tier = plugin.getFactionTier(f.getId());
					fName = f.getTag();
				}catch(Exception e){
					score = 0;
					tier = 0;
					fName = null;
				}
				if (tier >= 1){
					sender.sendMessage(ChatColor.GREEN + fName + " has " + score 
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
