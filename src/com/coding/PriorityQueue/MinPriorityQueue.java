package com.coding.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;

//This is nothing but the use case of heap sort
public class MinPriorityQueue {

	private static ArrayList<Integer> heap;
	
	public MinPriorityQueue() {
	   heap=new ArrayList<Integer>();	
	}
	
	public static int size() {
		return heap.size();
	}
	
	public static  int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return heap.size()==0;
	}
	
	public void insert(int element) {
		heap.add(element);
		
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		
		while(childIndex>0) {
			
			//up heapify
			if(heap.get(childIndex) < heap.get(parentIndex)) {
				int temp=heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				
				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}else {
				return;
			}
		}
		
	}
	
	public int removeMin() {
		int min=heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int index=0;
		int minIndex=0;
		int leftIndex=1;
		int rightindex=2;
		
		while(leftIndex<heap.size()) {//leftindex should be less than array size 
			if(heap.get(leftIndex)<heap.get(minIndex)) {
				minIndex=leftIndex;   //if left heap is less than minIndex need to be swapped
			}
			if(rightindex<heap.size() && heap.get(rightindex)<heap.get(minIndex)) {
				minIndex=rightindex;  //if right heap is less than minIndex need to be swapped
			}
			if(minIndex==index) {
				break ;//if minIndex is is already at correct position
			}else {
				int temp=heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp);//swap the minIndex and index
				index=minIndex;//update the minIndex
				leftIndex=2*index+1;//calculate the leftIndex again
				rightindex=2*index+2;//calculate the rightIndex again
			}
			
		}
		
		return min;
	}
	
	public static void virtualInsertheap(int[] arr,int i) {
//		int childIndex=i;
//		int parentIndex=(childIndex-1)/2;
//		while(childIndex>0) {
//			if(arr[childIndex]>arr[parentIndex]) {
//				int temp=arr[childIndex];
//				arr[childIndex]=arr[parentIndex];
//				arr[parentIndex]=temp;
//				childIndex=parentIndex;
//				parentIndex=(childIndex-1)/2;
//			}else {
//				return;
//			}
//		}
		int childIndex = i;
		int parentIndex = (childIndex - 1) / 2;
		while(childIndex > 0){
			if(arr[childIndex] < arr[parentIndex] ){
				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}else{
				return;
			}
		}
	}

	public int removeMinVirtual(int[] arr, int heapSize) {
		
//		int minvalue=arr[0];
//		arr[0]=arr[heapSize-1];
//		heapSize--;
		
//		int index=0;
//		int leftIndex=2*index +1;
//		int rightIndex=2*index +2;
        
//		while(leftIndex<heapSize) {
//			int minIndex=index;
//			if(arr[leftIndex]<arr[minIndex]) {
//				minIndex=leftIndex;
//			}
//			if(rightIndex<heapSize && arr[rightIndex]<arr[minIndex]) {
//				minIndex=rightIndex;
//			}
//			if(minIndex!=index) {
//				int temp=arr[index];
//				arr[index]=arr[minIndex];
//				arr[minIndex]=temp;
//				
//				index=minIndex;
//				leftIndex=2*index +1;
//				rightIndex=2*index +2;
//			}else {
//				break;
//			}
//		}
		int temp = arr[0];
		arr[0] = arr[heapSize - 1];
		heapSize--;
		int index = 0;
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;

		while(leftChildIndex < heapSize){

			int minIndex = index;
			if(arr[leftChildIndex] < arr[minIndex]){
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]){
				minIndex = rightChildIndex;
			}
			if(minIndex != index){
				int temp1 = arr[index];
				arr[index] = arr[minIndex];
				arr[minIndex]  = temp1;
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}else{
				break;
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MinPriorityQueue pq= new MinPriorityQueue();
        int arr[]= {5,3,4,2,10,23,1,0};
        for(int i=0;i<arr.length;i++) {
        	//pq.insert(arr[i]);
        	pq.virtualInsertheap(arr, i);
        }
        System.out.println(Arrays.toString(arr));
        
        for (int i = 0; i < arr.length; i++) {
			arr[arr.length-1-i]= pq.removeMinVirtual(arr, arr.length-i);
		}
        
        for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	

}
