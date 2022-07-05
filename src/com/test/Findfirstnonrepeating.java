package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Findfirstnonrepeating {
	
	public static void main(String args[]) {
	//	Findfirstnonrepeating obj = new Findfirstnonrepeating();
		char[] inparr = {'A','A','C','B','B','Z'};
		
		findnonrepeating(inparr);

	}
	
	static char findnonrepeating(char[] inparr) {
		
		char ch = ' ';
		int count =0;
		Map<Character, Integer> tm = new TreeMap<Character, Integer>();
		
		for(int i=0; i <= inparr.length-1; i++) {
			
		//	if(inparr[i]==inparr[i+1]) {
			if(tm.containsKey(inparr[i])) {
				//System.out.println(inparr[i]);
				tm.put(inparr[i],tm.get(inparr[i])+1);
			}
			else {
			//	ch = inparr[i];
				tm.put(inparr[i],1);
		//		System.out.println(inparr[i]);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : tm.entrySet()) {
			if(entry.getValue()==1) {
			System.out.println("[" +entry.getKey()+ "," +entry.getValue()+ "]");
			break;
			}
		}
		
		return ch;
		
	}

}
