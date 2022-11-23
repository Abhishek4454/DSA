package com.coding.recursion;

public class CheckNumberinArray {
	public static boolean checkNumber(int input[], int x) {
        int smallInput[]= new int[input.length-1];
        int temp=input[0];
        
        for (int i = 1; i < input.length; i++) 
		   smallInput[i-1]=input[i];
        if(temp==x) {
        	return true;
        }
        if (input.length<=1) {
			return false;
		}
        
        return checkNumber(smallInput,x);
		
	}
	public static void main(String[] args) {
		int input[]= {1,23,72};
		System.out.println(checkNumber(input, 47));

	}

}
