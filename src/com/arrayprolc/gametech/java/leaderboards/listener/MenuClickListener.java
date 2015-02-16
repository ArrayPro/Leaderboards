package com.arrayprolc.gametech.java.leaderboards.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.arrayprolc.gametech.java.leaderboards.util.UtilOpenMenu;

public class MenuClickListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (!e.getInventory().getTitle().contains("Leaderboard |")) {
			return;
		}

		e.setCancelled(true);

		if (e.getCurrentItem() == null) {
			return;
		}

		if (!e.getCurrentItem().hasItemMeta()) {
			return;
		}

		if (!e.getCurrentItem().getItemMeta().hasDisplayName()) {
			return;
		}

		if (e.getCurrentItem().getItemMeta().hasLore()) {
			String lore = e.getCurrentItem().getItemMeta().getLore().get(0);
			lore = ChatColor.stripColor(lore);
			if (lore.startsWith("Go to page ")) {
				int page = Integer.parseInt(lore.split("Go to page ")[1]);
				page--;
				UtilOpenMenu.openInventory(p, page);
				return;
			}
			if (lore.startsWith("Close menu.")) {
				p.closeInventory();
			}
		}

		String name = e.getCurrentItem().getItemMeta().getDisplayName();

		name = ChatColor.stripColor(name);

		if (name.contains("'s plot")) {

			String playerName = name.split("'s plot")[0];
			String plot = "0";
			
			String command = "plotz home " + playerName;
			
			if (name.contains(" #"))
				plot = name.split(" #")[1];

			if (!plot.equals("0"))
				command = command + " " + plot;

			p.performCommand(command);
		}

	}

}
