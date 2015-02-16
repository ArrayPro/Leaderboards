package com.arrayprolc.gametech.java.leaderboards.util;
public class UtilItem {

	public static byte[] getData(int page){
		switch(page){
		case 1: return new byte[] { 13, 5 };
		case 2: return new byte[] { 1, 4 };
		case 3: return new byte[] { 11, 3 };
		case 4: return new byte[] { 10, 2 };
		case 5: return new byte[] { 14, 6 };
		default: return new byte[] { 13, 5 };
		}
	}
	
}
