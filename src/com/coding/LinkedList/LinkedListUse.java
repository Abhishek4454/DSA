package com.coding.LinkedList;

import java.util.Scanner;


public class LinkedListUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       Node<Integer> node1=new Node<Integer>(10);
//       Node<Integer> node2=new Node<Integer>(20);
//       Node<Integer> node3=new Node<Integer>(30);
//       node1.next=node2;
//       node2.next=node3;
//       printLL(node1);
        
		//printLL(takeInput());
		
		//printLL(insertLL(takeInput(),0,80));
		printLL(deleteNode(takeInput(),3));
		

	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
		if(head==null)
			return head;
        
		if(pos==0)
			return head.next;
		
		int i=0;
		Node<Integer> temp=head;

		while(i<pos-1 && temp!=null) {
			temp=temp.next;
			i++;
		}
		if(temp==null || temp.next==null)
			return head;
		
		temp.next=temp.next.next;
		
		return head;
	
	}
	
	private static Node<Integer> insertLL(Node<Integer> head, int pos, int data) {
         int i=0;
         Node<Integer> newNode=new Node<Integer>(data);

         if(pos==0) {
			 newNode.next=head;
			 return newNode;
		 }
         Node<Integer> temp=head;
			while(i<pos-1) {//we should stop at poss-1
				temp=temp.next;
				i++;
			}
		
		 //First we need to create link for newNode and pos+1 Index
		 newNode.next=temp.next;
		 //than after link will created between newNode and temp.next .Otherwise reference to pos+1 is lost
		 temp.next=newNode;
		 
		 return head;
	}

	public static void printIthNode(Node<Integer> head, int i){
		int count=0;
		while(head!=null) {
			if(count==i) {
				System.out.println(head.data);
				break;
			}
			head=head.next;
			count++;
		}
		
	}
	public static int length(Node<Integer> head){
		//Your code goes here
		int count=0;
		
		while(head!=null) {
			count++;
			head=head.next;
		}
			
		
		return count;
	}

	public static Node<Integer> takeInput() {
		
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = null;
		int data = sc.nextInt();
		while (data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if (head == null)
				head = newNode;
			else {
				Node<Integer> temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = newNode;
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	
	
	private static void printLL(Node<Integer> head) {
		while(head!=null) {
			   System.out.print(head.data+" ");
			   head= head.next;
		   }
	}

}
