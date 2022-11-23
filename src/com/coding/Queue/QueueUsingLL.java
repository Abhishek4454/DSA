package com.coding.Queue;


public class QueueUsingLL {

	Node<Integer> front;
	Node<Integer> rear;
	int size;
	
	public QueueUsingLL() {
		size=0;
	}
	
	public int size() {
		return size;
	}
     
	public int front() {
		if(size==0)
			return -1;
		return front.data;
	}

	public void eneque(int element) {
		size++;//size should be placed at top else there inconsistency
		Node<Integer> next= new Node<Integer>(element);
		if(front==null) {
			front=next;
			rear=next;
			return;
		}
		rear.next=next;
		rear=next;
		
	}
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	public int dequeue() {
		
		if(this.isEmpty())
			return -1;
		int temp=front.data;
		
		front =front.next;
		size--;
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
          QueueUsingLL ql= new QueueUsingLL();
          
          for (int i = 1; i <= 5; i++) {
			ql.eneque(i);
		}
          
          while(!ql.isEmpty()) {
        	  System.out.print(ql.dequeue()+" ");
          }
	

	}

	

}
