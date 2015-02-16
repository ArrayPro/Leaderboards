package com.arrayprolc.gametech.java.leaderboards.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import me.kyle.plotz.obj.Plot;

import org.bukkit.ChatColor;

public class UtilSortPlot {

	@SuppressWarnings("unchecked")
	public static ArrayList<Plot> sortPlots(ArrayList<Plot> input) {
		ArrayList<Plot> output = new ArrayList<Plot>();
		HashMap<Plot, Integer> plots = new HashMap<Plot, Integer>();
		for (Plot p : input) {
			plots.put(p, p.getLikes());
		}
		plots = (HashMap<Plot, Integer>) sortByValue(plots);
		output.addAll(plots.keySet());
		Collections.reverse(output);
		return output;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static Map sortByValue(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			@SuppressWarnings("rawtypes")
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	public static int getID(int row){
		switch(row){
		case 0: return 0;
		case 1: return 1;
		case 2: return 0;
		case 3: return 1;
		default: return 0;
		}
	}
	
	public static ChatColor getChatColor(int current){
		if(current == 0){
			return ChatColor.GOLD;
		}
		return ChatColor.GRAY;
	}

}
