package com.util;

import java.util.Random;

public class RandomGenerator {
	
	public static int generate(){
		int num=0;
		Random r=new Random();
		num=r.nextInt(2500);
		return num;
	}

}
