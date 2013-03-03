package com.mutinycraft.jigsaw.FactionsExtra;

import java.io.File;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDataTask extends BukkitRunnable {

	File directory;

	public PlayerDataTask(File d) {
		this.directory = d;
	}

	@Override
	public void run() {
		File file = new File(directory + File.separator + "users");
		if (file.exists() && file.isDirectory()) {
			for (File f : file.listFiles()) {
				f.delete();
			}
		}
	}
}
