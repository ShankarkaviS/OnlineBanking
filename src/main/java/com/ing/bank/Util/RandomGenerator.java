package com.ing.bank.Util;

import java.util.Random;



public class RandomGenerator {
	public static String getRandomNumber(String name, String gmail,String phone)
	{ String r="";
		int counter=100;
		Random rnum = new Random();
		 for (counter = 1; counter <=1; counter++) {
		 r=name.substring(0,2)+gmail.substring(2,4)+phone.substring(8,9)+ rnum.nextInt(200);
		 }
		 return  r;	
	}
	
	 public static String generatePIN(int PINString) 
	   {
	        int randomPIN = (int)(Math.random()*9000)+1000;
	        return   randomPIN+"";

	    }
}
