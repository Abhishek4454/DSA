package com.coding.recursion;

import java.util.Arrays;

public class FindSubsequence {

	public static void main(String[] args) {
		String str="xyz";
		
		System.out.println(Arrays.toString(findSubsequence(str)));
	}

	private static String[] findSubsequence(String str) {
		// TODO Auto-generated method stub
		if(str.length()==0)
		{
			String ans[]= {""};
			return ans;
		}
		
		String smallAns[]=findSubsequence(str.substring(1));
		
		String ans[]= new String[2*smallAns.length];
		int k=0;
		for (int i = 0; i < smallAns.length; i++) {
			ans[k]=smallAns[i];
			k++;
		}
		
		for (int i = 0; i < smallAns.length; i++) {
			ans[k]=str.charAt(0)+ smallAns[i];
			k++;
		}
		
		return ans;
	}

}
