package com.controller;

import java.io.File;

public class Test1 {

	
	public static String test11(){
		
		String userDirectory = new File("").getAbsolutePath();
		//System.out.println(userDirectory);
		return userDirectory;
		
	}
	
}
