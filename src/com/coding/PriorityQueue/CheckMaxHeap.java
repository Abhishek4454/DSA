package com.coding.PriorityQueue;

public class CheckMaxHeap {

	public static boolean checkMaxHeap(int arr[]) {
		
		for (int index=0; index < arr.length; index++) {
//			if(leftChildIndex<arr.length &&  arr[index]>arr[leftChildIndex]) {
//				 index=leftChildIndex;
//				 leftChildIndex=2*index+1;
//				 rightChildIndex=2*index+2;
//			}else if(rightChildIndex<arr.length && arr[index]>arr[rightChildIndex]) {
//				 index=rightChildIndex;
//				 leftChildIndex=2*index+1;
//				 rightChildIndex=2*index+2;
//			}else {
//				return false;
//			}
			int leftChildIndex=2*index+1;
			int rightChildIndex=2*index+2;
			if(leftChildIndex<arr.length && arr[index]<arr[leftChildIndex])
				return false;
			
			if(rightChildIndex<arr.length && arr[index]<arr[rightChildIndex])
				return false;
			
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {42 ,20 ,18 ,6 ,14 ,11, 9 ,4};
       System.out.println(checkMaxHeap(arr));
	}

}
