package com.coding.GenericTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

	public static void main(String[] args) {
		
		//TreeNode<Integer> root= takeInput();
		TreeNode<Integer> root1= takeInputLevelWise();
		printTee(root1);
		System.out.println(countNumNodes(root1));
        
		//printTee(root);
		printTreeLevelWise(root1);
//		TreeNode<Integer> node1= new TreeNode<Integer>(2);
//		TreeNode<Integer> node2= new TreeNode<Integer>(3);
//		TreeNode<Integer> node3= new TreeNode<Integer>(4);
//		TreeNode<Integer> node4= new TreeNode<Integer>(5);
//		
//		node1.next.add(node2);
//		node2.next.add(node3);
//		node3.next.add(node4);
//		
//		System.out.println(node1);


	}
    
	
	public static int countNumNodes(TreeNode<Integer> root) {
		// TODO Auto-generated method stub
		int count=1;
		for(int i=0;i<root.next.size();i++)
			count +=countNumNodes(root.next.get(i));
		
		return count;
	}


	public static void printTreeLevelWise(TreeNode<Integer> root) {
		if(root==null)
			return;
		
		Queue<TreeNode<Integer>> mq= new LinkedList<TreeNode<Integer>>();
		mq.add(root);
		Queue<TreeNode<Integer>> cq= new LinkedList<TreeNode<Integer>>();

		while(mq!=null) {
			TreeNode<Integer> front=mq.poll();
			System.out.print(front.data+"  ");
			for (int i = 0; i < front.next.size(); i++) {
				cq.add(front.next.get(i));
			}
			
			while(mq.size()==0) {
				mq=cq;
				cq=new LinkedList<TreeNode<Integer>>();
			}
		}
		
		
	}

	 static TreeNode<Integer> takeInputLevelWise() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the root element data : ");
		int data=sc.nextInt();
		TreeNode<Integer> root= new TreeNode<Integer>(data);
		Queue<TreeNode<Integer>> pendingQueue= new LinkedList<TreeNode<Integer>>();
		pendingQueue.add(root);
		while(!pendingQueue.isEmpty()) {
			TreeNode<Integer> frontNode= pendingQueue.poll();
			System.out.println("Enter number of child for node : " +frontNode.data);
			int childCount=sc.nextInt();
			for(int i=0;i<childCount;i++) {
				System.out.println("Enter the "+ (i+1) +"th node element for "+frontNode.data);
				int childData=sc.nextInt();
				TreeNode<Integer> childNode= new TreeNode<Integer>(childData);
				root.next.add(childNode);
				pendingQueue.add(childNode);
			}
			
		}
		
		return root;
	}

	public static void printTee(TreeNode<Integer> root) {
		String s=root.data +" : ";
		
		for(int i=0;i<root.next.size();i++) {
			s=s+root.next.get(i).data+',';
		}
		
		System.out.println(s);
		
		for(int i=0;i<root.next.size();i++) {
			printTee(root.next.get(i));
		}
		
	}

	public static TreeNode<Integer> takeInput() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter node element : ");
		int data=sc.nextInt();
		TreeNode<Integer> root= new TreeNode<Integer>(data);
		System.out.println("Enter number of children: ");
		int noOfChild=sc.nextInt();
		
		for(int i=0;i<noOfChild;i++) {
			TreeNode<Integer> child= takeInput();
			root.next.add(child);
		}
		
		return root;
	}

}
