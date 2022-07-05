package com.test;

import java.util.Arrays;

public class ArraySpecialProduct {
	
	//Implement a function which given an array of integers returns a new array for which every index carries the product of the remaining 
	//elements
	//Example
	//Given array [1,3,2,4,5] will return [120,40,60,30,24]
	//Given array [4,10,3] will return [30,12,40]
	
	
	public static void main(String args[]) {
		ArraySpecialProduct arraySpecialProduct = new ArraySpecialProduct();
		int[] inparr = {1,3,2,4,5};
		
		int[] outputarr= arraySpecialProduct.getOutput(inparr);
		
		for(int i=0;i<outputarr.length;i++) {
			System.out.println(outputarr[i]);

		}
	}
	
	public int[] getOutput(int [] arr) {
		
		int leftprod[] = new int[arr.length+1];
		int rightprod[] = new int[arr.length+1];
		int finalprod[] = new int[arr.length];
		
		Arrays.fill(leftprod, 1);
		Arrays.fill(rightprod, 1);
	
		
		for(int i=1;i<=arr.length;i++) {
			leftprod[i] = arr[i-1]*leftprod[i-1];
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			rightprod[i] = arr[i]*rightprod[i+1];
		}
		
		for(int i=0;i<=arr.length-1;i++) {
			finalprod[i] = leftprod[i]*rightprod[i+1];
		}
		

		return finalprod;
	}

	static int[] findSpecialProduct(int[] input)
	{
		int leftProduct[] = new int[input.length+1];
		int rightProduct[] = new int[input.length+1];
		int output[] = new int[input.length];
		
		Arrays.fill(leftProduct, 1);
		Arrays.fill(rightProduct,1);
		
		
		for(int i = 1; i <= input.length; i++)
		{
			leftProduct[i] = input[i-1] * leftProduct[i-1];
		}
		
		for(int i = input.length-1; i >=0; i--)
		{
			rightProduct[i] = input[i] * rightProduct[i+1];
		}
		
		for(int i = 0; i < input.length; i++)
		{
			output[i] = leftProduct[i] * rightProduct[i+1];
		}
		
		return output;
	}
	
}
