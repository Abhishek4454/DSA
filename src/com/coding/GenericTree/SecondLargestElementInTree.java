package com.coding.GenericTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SecondLargestElementInTree {

	// Pointers to store the largest and second largest node
    public static TreeNode<Integer> largest;
    public static TreeNode<Integer> secondLargest;
	// Helper Function to find the second largest node of the n-ary tree
    public static void findSecondLargestHelper(TreeNode<Integer> root)
    {
        // Base Case
        if (root == null) {
            return;
        }
        // Check if root's data is larger than current largest node's data
        if (root.data > largest.data) {
            secondLargest = largest;
            largest = root;
        } else if (root.data > secondLargest.data && root.data != largest.data)
            secondLargest = root;
        // recursively find second largest in children
        for (TreeNode<Integer> child: root.next)
            findSecondLargestHelper(child);
    }
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        // Initialising the pointers to a node with value negative infinity
        largest = new TreeNode<Integer>(Integer.MIN_VALUE);
        secondLargest = largest;
        findSecondLargestHelper(root);
        return secondLargest;
	}
	
	public static int countLeafNodes(TreeNode<Integer> root){
		if(root==null)
			return 0;
		
		int count=0;
		
		if(root.next.size()==0)
			return 1;
		
		for(int i=0;i<root.next.size();i++)
			count+=countLeafNodes(root.next.get(i));
		
		return count;
	}

	public static void replaceWithDepthValue(TreeNode<Integer> root){

		replaceWithDepthValue(root,0);
		
	}
	private static void replaceWithDepthValue(TreeNode<Integer> root, int depth) {
		// TODO Auto-generated method stub
		if(root==null)
			return ;
		
		root.data=depth;
		
		for(int i=0;i<root.next.size();i++) {
			replaceWithDepthValue(root.next.get(i),depth+1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PrintAtK pk=new PrintAtK();
       TreeNode<Integer> root= pk.takeInputLevelWise();
       System.out.println(findSecondLargest(root).data);
    		   
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc= new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		System.out.println("Enter the root element : ");
		int rootData = sc.nextInt();
		
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			currentNode = pendingNodes.poll();
			System.out.println("Number of child for "+currentNode.data);
			int numChild = sc.nextInt();
			for(int i = 0 ; i < numChild; i++){
				System.out.println("Element for child at "+(i+1)+" index of "+currentNode.data);
				int currentChild = sc.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
				pendingNodes.add(childNode);
				currentNode.next.add(childNode);
			}
		}
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
        Queue<TreeNode<Integer>> mq= new LinkedList<TreeNode<Integer>>();
		mq.add(root);
		Queue<TreeNode<Integer>> cq= new LinkedList<TreeNode<Integer>>();

		while(mq.size()>0) {
			root=mq.poll();
			System.out.print(root.data+" : ");
			
			for(int i=0;i<root.next.size();i++) 
				cq.add(root.next.get(i));
			
			if(mq.size()==0) {
				mq=cq;
				cq=new LinkedList<TreeNode<Integer>>();
				System.out.println();
			}
		}
	}

}
