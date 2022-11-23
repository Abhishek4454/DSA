package com.coding.Queue;

public class QueueUsingArray {
    private int data[];
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int frontElement() throws QueueEmptyException {
		if(size==0)
			throw new QueueEmptyException();
		
		return data[front];
	}
	
	public void eneque(int element) throws QueueFullException {
		if(size==0) 
			front=0;
		
		
		if(size==data.length) {
			//throw new QueueFullException();
			doubleCapacity();
		}
		size++;
		rear=(rear+1)%data.length;
//		if(rear==data.length) same as line no:45
//			rear=0;
		data[rear]=element;
		
	}
	
	private void doubleCapacity() {
		int temp[]=data;
		data=new int[temp.length*2];
		int index=0;
		for (int i = front; i < temp.length; i++)
			data[index++]=temp[i];
			
		for (int i=0;i<front;i++)
			data[index++]=temp[i];
		
		front=0;
		rear=temp.length-1;
		
	}

	public  int deque() throws QueueEmptyException {
		if(size==0)
			throw new QueueEmptyException();
		int temp=data[front];
		front=(front+1)%data.length;
		
		size--;	
		if(size==0) {
			front=-1;
			rear=-1;
		}
		return temp;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          QueueUsingArray qa= new QueueUsingArray(3);
          
          for (int i = 1; i <= 5; i++) {
			try {
				qa.eneque(i);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
          
          while(!qa.isEmpty()) {
        	  try {
				System.out.print(qa.deque()+" ");
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
	}

}
