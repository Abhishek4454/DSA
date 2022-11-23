package com.coding.recursionNew;

public class CheckNumberArray {

	public static boolean checkNumber(int input[], int x) {
		if(input.length==0)
			return false;
		
        int temp[] = new int[input.length - 1];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = input[i + 1];
		}
		if(input[0]==x)
			return true;
		
		return checkNumber(temp, x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,8,9};
		System.out.println(checkNumber(arr,7));
	}

}
