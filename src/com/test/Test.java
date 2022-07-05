package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	
	public static void main(String args[]) {
		
		List<String> list = new ArrayList<String>();
		list.add("HELLO");
		list.add("HOW");
		list.add("aRe");
		list.add("YOU");
		/*
		 * Collections.reverse(list); System.out.println("Reverse order Output" +
		 * list.toString()) ;
		 */
		System.out.println("Input" + list.toString()) ;
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				System.out.println("arg0  "  + arg0 + "   arg1  "+arg1);
				return arg0.toLowerCase().compareTo(arg1.toLowerCase());
			}
			
				
		});
	
		System.out.println("Output" + list.toString()) ;
		/*
		 * Collections.sort(list,Collections.reverseOrder());
		 * System.out.println("Reverse order Output" + list.toString()) ;
		 */

	}

}
