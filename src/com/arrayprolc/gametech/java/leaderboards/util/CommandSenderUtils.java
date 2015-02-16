package com.arrayprolc.gametech.java.leaderboards.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSenderUtils {

	public static void sendMessage(CommandSender sender, String message) {
		if (sender instanceof Player) {
			sender.sendMessage(message);
			return;
		}
		sender.sendMessage(ChatColor.stripColor(message));
		return;
	}

}
