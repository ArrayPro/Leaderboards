package com.arrayprolc.gametech.java.leaderboards.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.arrayprolc.gametech.java.leaderboards.util.CommandSenderUtils;
import com.arrayprolc.gametech.java.leaderboards.util.UtilOpenMenu;
import com.arrayprolc.gametech.java.leaderboards.util.UtilPermission;

public class CommandLeaderboard implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player target = null;
		if (sender instanceof Player) {
			if (args.length == 0) {
				if (!UtilPermission.hasPermission((Player) sender, "open")) {
					sender.sendMessage("§4§lERROR: §7You do not have permission to do that!");
					return true;
				}
				target = ((Player) sender);
			} else {
				if (!UtilPermission.hasPermission((Player) sender,
						"open.others")) {
					sender.sendMessage("§4§lERROR: §7You do not have permission to do that!");
					return true;
				}
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

		if (target == null) {
			CommandSenderUtils.sendMessage(sender,
					"§4§lERROR: §7That is not a valid player!");
			return false;
		}

		UtilOpenMenu.openInventory(target, 0);

		return false;
	}

}
