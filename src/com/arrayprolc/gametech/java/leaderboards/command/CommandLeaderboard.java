package com.arrayprolc.gametech.java.leaderboards.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.arrayprolc.gametech.java.leaderboards.util.CommandSenderUtils;

public class CommandLeaderboard implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player target = null;
		if (sender instanceof Player) {
			if (args.length == 0) {
				target = ((Player) sender);
			} else {
				target = Bukkit.getPlayer(args[0]);
			}
		} else {
			if (args.length == 0) {
				sender.sendMessage("You must specify a player when running from console");
				return true;
			} else {
				target = Bukkit.getPlayer(args[0]);
			}
		}
		
		if(target == null){
			CommandSenderUtils.sendMessage(sender, "§4ERROR: §7That is not a valid player!");
		}

		return false;
	}

}
