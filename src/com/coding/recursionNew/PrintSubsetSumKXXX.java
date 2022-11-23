package com.coding.recursionNew;

import java.util.Arrays;

public class PrintSubsetSumKXXX {

	public static void printSubsetsSumTok(int input[], int target) {
		
		printSubsetsSumTok(input,0,0,"",  target);
	}
    public static int[][] subsetsSumK(int input[], int k) {
    	 return helper(input,k,0);
    }

	public static int[][] helper(int input[], int k, int si) {
		if (si == input.length) {
			if (k == 0)
				return new int[1][0];
			else
				return new int[0][0];
		}
		int op1[][] = helper(input, k - input[si], si + 1);////////////
		int op2[][] = helper(input, k, si + 1);
		int output[][] = new int[op1.length + op2.length][];////////////////
		int l = 0;
		for (int i = 0; i < op2.length; i++) {
			output[i] = new int[op2[i].length];
			for (int j = 0; j < op2[i].length; j++)
				output[l][j] = op2[i][j];////////
			l++;
		}
		for (int i = 0; i < op1.length; i++) {
			output[i + l] = new int[op1[i].length + 1];
			output[i + l][0] = input[si];
			for (int j = 1; j <= op1[i].length; j++) {
				output[i + l][j] = op1[i][j - 1];
			}
		}
		return output;

	}
	private static void printSubsetsSumTok(int[] input, int index, int sum, String set, int target) {
		// TODO Auto-generated method stub
		if(index==input.length) {
			if(sum==target)
			System.out.println(set);
			return;
		}
		
		printSubsetsSumTok(input, index+1, sum+input[index], set+input[index]+" ", target);
		printSubsetsSumTok(input, index+1, sum, set, target);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {5, 12, 3, 17, 1 ,18, 15, 3, 17 };
        printSubsetsSumTok(input, 6);
        for (int i = 0; i < subsetsSumK(input, 6).length; i++) {
        	System.out.println(Arrays.toString(subsetsSumK(input, 6)[i]));
		}
        
	}

}
