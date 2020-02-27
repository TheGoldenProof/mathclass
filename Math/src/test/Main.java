package test;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		int r = new Random().nextInt(10);
		
		for (int j = 0; j < r; j++) {
			
			String s = "";
			
			for (int i = r; i > j; i--) s+=i;
			
			System.out.println(s);
			
		}
		
	}
	
}
