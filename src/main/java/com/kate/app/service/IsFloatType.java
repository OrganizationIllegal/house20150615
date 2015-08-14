package com.kate.app.service;

import java.util.regex.Pattern;

public class IsFloatType {
	public static boolean isDouble(String str) {    
	    Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");    
	    return pattern.matcher(str).matches();    
	  }
}
