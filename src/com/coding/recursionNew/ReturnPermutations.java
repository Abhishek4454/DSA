package com.coding.recursionNew;

import java.util.Arrays;

public class ReturnPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       printPermutations("abc");
       System.out.println(Arrays.toString(returnAllPermutation("abc")));
	}

	private static String[] returnAllPermutation(String input) {
		
		  if(input.length() == 0){
	            String y[] = {""};
	            return y;
	        }
	        String [] ans = returnAllPermutation(input.substring(1));
			String output[] = new String[ans.length*input.length()];
	        
	        int k=0;
	        for(int i=0;i<ans.length;i++){
	            
	            for(int j=0;j<=ans[i].length();j++){
	                output[k++] = ans[i].substring(0,j) + input.charAt(0) + ans[i].substring(j);
	            }
	        }
	        return output;
	}

	private static void printPermutations(String str) {
		
		printPermutations(str,"");
	}

	private static void printPermutations(String str, String output) {
		if(str.isEmpty())
			System.out.println(output);
		
		for (int i = 0; i < str.length(); i++) {
			
			char ch=str.charAt(i);
			
			String leftSide=str.substring(0,i);
			String rightSide=str.substring(i+1);
			String remaing=leftSide+rightSide;
            printPermutations(remaing,output+ch);   
			
		}
		
	}

}
