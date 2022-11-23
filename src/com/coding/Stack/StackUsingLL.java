package com.coding.Stack;

public class StackUsingLL {

	Node<Integer> data;
	int size;
	
	//Define the data members
    public StackUsingLL() {
        //Implement the Constructor
    	data=null;
    	size=0;
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() { 
        //Implement the getSize() function
    	return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
    	return size==0;
    }

    public void push(int element) {
        //Implement the push(element) function
    	Node<Integer> node=new Node<Integer>(element);
    	node.next=data;
    	data=node;
    	size++;
    }

	public int pop() {
		// Implement the pop() function
		int temp = -1;
		if (data != null) {
			temp = data.data;
			data = data.next;
			size--;
		}
		return temp;
	}

    public int top() {
        int temp=-1;
        if(data!=null) {
        	temp=data.data;
        }
    	return temp;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
