package com.arrayprolc.gametech.java.leaderboards.util;

import org.bukkit.entity.Player;

import com.arrayprolc.gametech.java.leaderboards.core.LeaderboardsCore;

public class UtilPermission {

	private static String prefix = "leaderboards.";

	public static boolean hasPermission(Player p, String permission) {
		if (p.isOp()) {
			return true;
		}
		if (p.hasPermission("leaderboards.*")) {
			return true;
		}
		try {
			String list = LeaderboardsCore.getInstance().getConfig()
					.getString("allowedDefault");
			String[] allowed = list.split(",");
			for (String s : allowed) {
				if (s.equalsIgnoreCase("leaderboards.*")) {
					return true;
				}
				if (s.equalsIgnoreCase(permission)) {
					return true;
				}
			}
		} catch (Exception ex) {
			// It's probably a NPE, that's okay.
			// Also, info.* isn't currently a viable permission, but it's mainly
			// there as a placeholder at the moment.
			LeaderboardsCore.getInstance().getConfig()
					.set("allowedDefault", "open");
			LeaderboardsCore.getInstance().saveConfig();
			if (permission.equalsIgnoreCase("open")) {
				return true;
			}
		}
		return p.hasPermission(prefix + permission);

	}
}
