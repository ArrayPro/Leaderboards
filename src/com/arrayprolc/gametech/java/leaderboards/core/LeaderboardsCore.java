package com.arrayprolc.gametech.java.leaderboards.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.arrayprolc.gametech.java.leaderboards.command.CommandLeaderboard;
import com.arrayprolc.gametech.java.leaderboards.listener.MenuClickListener;

public class LeaderboardsCore extends JavaPlugin {

	private static LeaderboardsCore instance;

	public void onEnable() {
		instance = this;
		getConfig();
		setupListeners();
		setupCommands();
	}
	
	public void setupListeners(){
		Bukkit.getServer().getPluginManager().registerEvents(new MenuClickListener(), this);
	}
	
	public void setupCommands(){
		getCommand("leaderboard").setExecutor(new CommandLeaderboard());
	}

	public static LeaderboardsCore getInstance() {
		return instance;
	}

	public String getPlotWorld() {
		if (LeaderboardsCore.getInstance().getConfig().getString("world") == null) {
			LeaderboardsCore.getInstance().getConfig()
					.set("world", "plotworld");
			return "plotworld";
		}
		return LeaderboardsCore.getInstance().getConfig().getString("world");
	}

}
