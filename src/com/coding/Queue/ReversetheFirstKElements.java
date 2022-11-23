package com.coding.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversetheFirstKElements {
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		
		if(k==0 || k>=input.size())
			return input;
		
		if(input.isEmpty())
			return input;
		
		
	    Stack<Integer> stk= new Stack<Integer>();
		for (int i = 0; i < k; i++) {
			stk.push(input.poll());
		}
		
		while(!stk.isEmpty()) {
			 input.add(stk.pop());
		}
		
		for (int i = 0; i <input.size()- k; i++) {
			input.add(input.poll());
		}
		
		
		
		return input;
		
	}
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<Integer>();
		for (int i = 1; i < 6; i++) {
			queue.add(i);
		}
		System.out.println(reverseKElements(queue, 3));
		

	}

}
