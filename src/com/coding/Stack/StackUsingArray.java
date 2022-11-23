package com.coding.Stack;

public class StackUsingArray {

	private int arr[] ;
	private int top;
	
	public StackUsingArray() {
		arr=new int[10];
		top=-1;
	}
	
	public StackUsingArray(int capacity) {
		arr=new int[capacity];
		top=-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() throws StackEmptyException {
		if(size()==0) {
			throw new StackEmptyException();
		}
		return arr[top];
	}
	
	public void push(int element) throws StackFullException {
		if (size() == arr.length) {
			// throw new StackFullException();
			int newArr[] = arr;
			arr=new int[arr.length * 2];
			for (int i = 0; i < newArr.length; i++) {
				arr[i] = newArr[i];
			}
			arr[++top] = element;
		} else {
			arr[++top] = element;
		}
	}

	public int pop() throws StackEmptyException {
		if(size()==0) {
			throw new StackEmptyException();
		}
		return arr[top--];
	}
	

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		// TODO Auto-generated method stub
       StackUsingArray sa= new StackUsingArray();
       System.out.println(sa.isEmpty());
       sa.push(10);
       System.out.println(sa.top());
       System.out.println(sa.pop());
       System.out.println(sa.isEmpty());

	}

}
