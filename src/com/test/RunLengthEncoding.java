package com.test;

public class RunLengthEncoding {
	
	
	public static void main(String args[]) {
		
		String input = "aabbbcaad";
		RunLengthEncoding encoding = new RunLengthEncoding();
		System.out.println("output "+encoding.getOutput(input));
	}
		
	private String getOutput(String input) {
		StringBuffer buffer = new StringBuffer();
		String output = null;
		char arr[] = input.toCharArray();
		int count=0;
		
		System.out.println(arr.length);
		
		for (int i=0; i<= arr.length-1; i++){
			System.out.println("Character "+arr[i]);
			
			if( i<arr.length-1 && arr[i] != arr[i+1]) {
				buffer.append(arr[i]).append(count+1); 
				count=0;
		
				
			}else {
				count++;
				if(i==arr.length-1) {
					//count++;
					buffer.append(arr[i]).append(count); 
				}
				//buffer.append(arr[i]);
			}

			
			//count=0;
		}
		output = buffer.toString();
		return output;
	}
		
}
