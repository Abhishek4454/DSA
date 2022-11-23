package com.coding.recursion;

public class FirstLastIndexOfNumber {
	static int count=-1;
	public static int firstIndex(int input[], int x) {
		
        if (input.length<=0) {
			return -1;
		}
        int temp=input[0];
        int[] smallInput= new int[input.length-1];
        for (int i = 0; i < smallInput.length; i++) {
			smallInput[i]=input[i+1];
		}
        count++;
        if(temp==x)
        	return count;
		return firstIndex(smallInput, x);
	}
	public static int lastIndex(int input[], int x) {
		 if (input.length<=0)
				return -1;
			
	        int temp=input[input.length-1];
	        int[] smallInput= new int[input.length-1];
	        for (int i = 0; i < smallInput.length; i++)
				smallInput[i]=input[i];
	        count++;
	        if(temp==x)
	        	return input.length-count+1;
			return lastIndex(smallInput, x);
	}
    public static int firstIndexOptimal(int input[], int x,int startIndex) {
    	if(startIndex>=input.length-1)
    		return -1;
    	if(input[startIndex]==x)
    		return startIndex;
    	return firstIndexOptimal(input,x, startIndex+1);
    }
	public static int lastIndexOptimal(int input[], int x,int lastIndex) {
		if(lastIndex<0)
    		return -1;
    	if(input[lastIndex]==x)
    		return lastIndex;
    	return lastIndexOptimal(input,x, lastIndex-1);
	}
	
	public static void main(String[] args) {
		int inputArray[]= {9 ,8 ,4,6,7,10 ,8,8,6,7};
//		System.out.println(firstIndex(inputArray, 8));
//		System.out.println(lastIndex(inputArray, 8));
//		
		System.out.println(firstIndexOptimal(inputArray, 8,0));
		System.out.println(lastIndexOptimal(inputArray, 8,inputArray.length-1));

	}

}
