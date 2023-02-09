package Handlers;

import java.util.Random;

public class Utils {
	public static String genUid() {
		
		String uid = "";
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			int randomNumber = r.nextInt();
			uid += randomNumber;
		}
		
		return uid;
	}
}
