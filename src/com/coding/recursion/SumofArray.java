package com.coding.recursion;

public class SumofArray {
	public static int sum(int input[]) {
       
        if(input.length<1){
            return 0;
        }
        int smallInput[]= new int[input.length-1];
        for (int i = 0; i < smallInput.length; i++) 
		   smallInput[i]=input[i];
	    
	    return sum(smallInput)+input[input.length-1];
       
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {1,23,72};
		System.out.println(sum(input));
	}

}
