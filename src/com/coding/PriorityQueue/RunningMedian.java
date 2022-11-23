package com.coding.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
//Running Median
//Send Feedback
//You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.
//Print only the integer part of the median.
//Input Format :
//The first line of input contains an integer 'N', denoting the number of integers in the stream.
//
//The second line of input contains 'N' integers separated by a single space.
//Output Format :
//Print the running median for every integer added to the running list in one line (space-separated).
//Input Constraints
//0 <= N <= 10 ^ 5
//1 <= ARR[i] <= 10 ^ 5
//
//Time Limit: 1 sec
//Sample Input 1 :
//6
//6 2 1 3 7 5
//Sample Output 1 :
//6 4 2 2 3 4
//Explanation of Sample Output 1 :
//S = {6}, median = 6
//S = {6, 2} -> {2, 6}, median = 4
//S = {6, 2, 1} -> {1, 2, 6}, median = 2
//S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
//S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
//S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
//Sample Input 2 :
//5
//5 4 3 2 1
//Sample Output 2 :
//5 4 4 3 3
public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]= {6 ,2 ,1 ,3 ,7, 5};
       findMedian(arr);
	}
	public static void findMedian(int arr[]) {
		PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
 		PriorityQueue<Integer> minpq=new PriorityQueue<>();
        int i=0;
        while(i<arr.length){
            // the below if condition is for the first element to enter in the max priority queue
            if(maxpq.size()==0&&minpq.size()==0){
                maxpq.add(arr[i]);
                System.out.print(arr[i]+" ");
            }
            // the below condition is for second element to enter to the min priority queue
            
            else if(maxpq.size()!=0&&minpq.size()==0){
                maxpq.add(arr[i]);
                minpq.add(maxpq.remove());
                int max=maxpq.peek();
                int min=minpq.peek();
                System.out.print((max+min)/2+" ");
            }
            // when both have elements
            else if(maxpq.size()!=0&&minpq.size()!=0){
                int num=arr[i];
                int max=maxpq.peek();
                int min=minpq.peek();
                if(num<max){
                maxpq.add(arr[i]);           
                }else{
                    minpq.add(arr[i]);
                } 
                 max=maxpq.peek();
                 min=minpq.peek();
                // if the size is same
                if(maxpq.size()==minpq.size()){
                    System.out.print((maxpq.peek()+minpq.peek())/2+" ");
                }
                // if the size is differ more than one than 
                // first try to make there size equal 
                else if(maxpq.size()-minpq.size()>1){
                    minpq.add(maxpq.remove());
                    max=maxpq.peek();
                    min=minpq.peek();
                    System.out.print((max+min)/2+" ");
                }//same
                else if(minpq.size()-maxpq.size()>1){
                     maxpq.add(minpq.remove());
                     max=maxpq.peek();
                     min=minpq.peek();
                     System.out.print((max+min)/2+" ");
                }   // if difference is less than two mwans one    
                else if(minpq.size()>maxpq.size()){
                     System.out.print(minpq.peek()+" ");
                }
                else if(minpq.size()<maxpq.size()){
                     System.out.print(maxpq.peek()+" ");
                }
            }
        i++;
        }
    }

}
