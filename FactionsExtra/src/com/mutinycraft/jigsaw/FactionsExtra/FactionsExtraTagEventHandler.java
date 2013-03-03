package com.mutinycraft.jigsaw.FactionsExtra;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

public class FactionsExtraTagEventHandler implements Listener {

	private FactionsExtra plugin;

	public FactionsExtraTagEventHandler(FactionsExtra pl) {
		this.plugin = pl;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	// Tag Event

	@EventHandler
	public void factionTag(PlayerReceiveNameTagEvent event) {
		FPlayer namedPlayer = FPlayers.i.get(event.getNamedPlayer());
		FPlayer seeingPlayer = FPlayers.i.get(event.getPlayer());

		if (namedPlayer.getFaction().isPeaceful()) {
			event.setTag(ChatColor.GOLD + event.getNamedPlayer().getName());
		} else if (namedPlayer.getRelationTo(seeingPlayer).isEnemy()) {
			event.setTag(ChatColor.RED + event.getNamedPlayer().getName());
		} else if (namedPlayer.getRelationTo(seeingPlayer).isAlly()) {
			event.setTag(ChatColor.DARK_GREEN
					+ event.getNamedPlayer().getName());
		} else if (namedPlayer.getRelationTo(seeingPlayer).isMember()) {
			event.setTag(ChatColor.GREEN + event.getNamedPlayer().getName());
		}
	}
}
