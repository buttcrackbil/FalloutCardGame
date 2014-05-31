package com.ballu.falloutcardgame.user;

import java.io.File;

public class User {
	
	public static String[] loadUser(String user) {
		File dir = new File(System.getProperty("user.home")
				+ "/Documents/Ball U/FCG/" + user);
		File file = new File(dir + "/quest.txt");
		String[] strings = new String[1];
		if (!file.exists()) {
			
		}
		if (file.exists()) {
			
		}
		
		return strings;
	}
}
