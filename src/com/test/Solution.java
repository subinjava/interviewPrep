package com.test;

import java.util.*;
class Solution{
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

public static void main(String ar[])
{
	int a[] = {1,2,3,4,5};
	int[] output= findSpecialProduct(a);
	
	for(int i = 0; i < output.length; i++)
	{
		System.out.println(output[i]);
	}
	
}
}

