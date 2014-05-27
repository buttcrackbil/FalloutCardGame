package com.ballu.falloutcardgame.quest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Quest {
	
	public Quest() {
		loadQuest();
	}
	
	public static void loadQuest() {
		File dir = new File(System.getProperty("user.home")
				+ "/Documents/Ball U/FCG/Users");
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		File file = new File(dir + "/quest.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (file.exists()) {
			System.out.println("File found");
			try {
				FileReader fr = new FileReader(file.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
