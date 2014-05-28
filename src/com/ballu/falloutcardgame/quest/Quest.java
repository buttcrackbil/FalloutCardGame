package com.ballu.falloutcardgame.quest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.ballu.falloutcardgame.Main;

public class Quest {
	
	public Quest() {
		loadQuest();
	}
	
	public static void loadQuest() {
		File dir = new File(System.getProperty("user.home")
				+ "/Documents/Ball U/FCG");
		
		File file = new File(dir + "/" + Main.user + "/quest.txt");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Created File");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				FileReader fr = new FileReader(file.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (file.exists()) {
			System.out.println("File found");
			try {
				FileReader fr = new FileReader(file.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
