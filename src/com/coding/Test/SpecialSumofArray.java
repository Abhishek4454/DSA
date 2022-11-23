package com.coding.Test;

public class SpecialSumofArray {

	public static int sum(int arr[]) {
		if (arr.length == 0)
			return 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		//int tempsum = sum;
		int ansSum = 0;
		while (sum > 9) {
			for (ansSum = 0; sum != 0; sum = sum / 10) {
				// finds the last digit and add it to the variable sum
				ansSum = ansSum + sum % 10;
			}
           sum=ansSum;
		}
      return sum;
//		//System.out.println(sum);
//		int temp=sum,digits=0;
//		while (temp > 0) {
//			temp = temp / 10;
//			digits++;
//		}
//		//sum=30
//		//System.out.println(digits);
//		int ans=0;
//		for(int i=0;i<digits;i++) {
//			ans+=sum%10;
//			sum=sum/10;
//		}
//		
		//return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1 ,7 ,8, 5, 9,11};
       System.out.println(sum(arr));
	}

}
