package com.test;

import java.util.HashMap;
import java.util.Map;

public class HashmapTest {
	
	public static void main(String args[]) {
		
		Map<String, Integer> positionHm = new HashMap<String, Integer>();
		positionHm.put("REL",10);
		positionHm.put("REL",20);
		
		for(Map.Entry<String, Integer> output: positionHm.entrySet()) {
			System.out.println("Security Code::  " +output.getKey()+ "   Position::  " +output.getValue());
		}
		
	}
	
	

}
