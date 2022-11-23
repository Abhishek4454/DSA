package com.coding.Queue;

import java.util.LinkedList;
import java.util.Queue;


public class ReverseQueue {

	public static void reverseQueue(Queue<Integer> input) {
//		if (input.size() == 0)
//			return;
//		int temp = input.dequeue();
//		reverseQueue(input);
//		input.eneque(temp);
		
		if (input.size() == 0)
			return;
		int temp = input.poll();
		reverseQueue(input);
		input.add(temp);
		
	}

	public static void main(String[] args) {
       
		Queue<Integer> queue= new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.add(i);
		}
		reverseQueue(queue);
		System.out.println(queue.peek());
//		QueueUsingLL ql = new QueueUsingLL();
//		for (int i = 0; i < 5; i++) {
//			ql.eneque(i);
//		}
//       reverseQueue(ql);
//       System.out.println(ql.front());
	}

}
