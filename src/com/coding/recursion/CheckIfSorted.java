package com.coding.recursion;

public class CheckIfSorted {
    public static boolean ifSorted(int input[]) {
    	if(input.length==1)
    		return true;
    	if (input[0]>input[1]) 
            return false;
    	int smallInput[]=new int[input.length-1];
    	for (int i = 1; i < input.length; i++) 
			smallInput[i-1]=input[i];
		boolean ans=ifSorted(smallInput);
		return ans;
    }
    
    public static boolean ifSorted(int input[],int startIndex) {
    	if(startIndex>=input.length-1)
    		return true;
    	if(input[startIndex]>input[startIndex+1]) 
    		return false;
    	
    	boolean smallAns=ifSorted(input, startIndex+1);
    	
    	return smallAns;
    		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {1,23,72,12};
		//System.out.println(ifSorted(input));
		System.out.println(ifSorted(input,0));

	}

}
