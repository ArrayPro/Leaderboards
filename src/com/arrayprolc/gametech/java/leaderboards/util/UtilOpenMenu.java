package com.arrayprolc.gametech.java.leaderboards.util;

import java.util.ArrayList;

import me.kyle.plotz.api.Plotz;
import me.kyle.plotz.obj.Plot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.arrayprolc.gametech.java.leaderboards.core.LeaderboardsCore;

public class UtilOpenMenu {

	/**
	 * Open the gadget inventory to a specific page!
	 * 
	 * @param p
	 *            The player you want to open the inventory
	 * @param page
	 *            The page you want to use.
	 * @return the inventory the player just opened
	 */
	public static Inventory openInventory(Player p, int page) {

		if (page == 0) {
			page = 1;
		} else {
			page++;
		}
		Inventory i = Bukkit.createInventory(null, 9 * 6, "Leaderboard | page "
				+ page);
		int starting = (page - 1) * UtilMenu.getAllowedSlots().length;
		for (int counter = 0; counter < UtilMenu.getAllowedSlots().length; counter++) {
			try {
				ArrayList<Plot> plots = new ArrayList<Plot>();

				for (OfflinePlayer p2 : Bukkit.getOfflinePlayers()) {
					plots.addAll(Plotz.getAllPlots(p2.getUniqueId(),
							LeaderboardsCore.getInstance().getPlotWorld()));
				}
				plots = UtilSortPlot.sortPlots(plots);
				Plot obj = plots.get(starting + counter);
				i.setItem(UtilMenu.getAllowedSlots()[counter], ItemUtils
						.setNameAndLore(
								new ItemStack(Material.STONE),
								"§b" + obj.getOwnerName() + "§7's plot #"
										+ obj.getHomeNumber(), "§7Likes: §9"
										+ obj.getLikes()));
			} catch (Exception ex) {
			}
		}
		if (page != 1) {
			i.setItem(48, ItemUtils.setNameAndLore(
					new ItemStack(Material.ARROW), "§c<§c§m--§c Go Back",
					"§7Go to page " + (page - 1)));
		} else {
			i.setItem(48, ItemUtils.setNameAndLore(
					new ItemStack(Material.ARROW), "§c<§c§m--§c Go Back",
					"§7Close menu."));
		}
		if (i.getItem(43) == null) {
			i.setItem(50, ItemUtils.setNameAndLore(
					new ItemStack(Material.ARROW), "§cNext page §c§m--§c>",
					"§7Close menu."));
		} else {
			i.setItem(50, ItemUtils.setNameAndLore(
					new ItemStack(Material.ARROW), "§cNext page §c§m--§c>",
					"§7Go to page " + (page + 1)));
		}

		p.openInventory(i);
		return i;
	}

}
