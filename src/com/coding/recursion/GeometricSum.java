package com.coding.recursion;

public class GeometricSum {
	public static double findGeometricSum(int k){
		double sum=0;
		if(k<=0)
			return 1;
		if(k>0)
			sum=1/Math.pow(2, k);
		return sum+findGeometricSum(k-1);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(findGeometricSum(3));
	}

}
