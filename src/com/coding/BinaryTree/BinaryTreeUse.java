package com.coding.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc= new Scanner(System.in);
       // BinaryTreeNode<Integer> root1= takeInput(sc);
        
       // printTreeNode(root1);
		BinaryTreeNode<Integer> root= takeInputlevelWise();
		printLevelWise(root);
		
		System.out.println(countBinaryTreeNode(root));
	}
	
	
	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
		// If root is null means there
		// is no binary tree so
		// return a empty vector
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		// Recursive call on root.right
		ArrayList<Integer> right = longestRootToLeafPath(root.rightNode);

		// Recursive call on root.left
		ArrayList<Integer> left = longestRootToLeafPath(root.leftNode);

		// Compare the size of the two ArrayList
		// and insert current node accordingly
		if (right.size() < left.size()) {
			left.add(root.data);
		} else {
			right.add(root.data);
		}

		// Return the appropriate ArrayList
		return (left.size() > right.size() ? left : right);
	}
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
	    
		int sum=0;
		replaceWithLargerNodesSum(root,sum);

	}
	
   private static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum) {
		if(root==null)
			return sum ;
	   sum= replaceWithLargerNodesSum(root.rightNode,sum);
	   sum+=root.data;
	   root.data=sum;
	   sum= replaceWithLargerNodesSum(root.leftNode,sum);
	   
	   return sum;
	}

//	Pair Sum Binary Tree
//	Send Feedback
//	Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
//	Note:
//	1. Assume the given binary tree contains all unique elements.
//	2. In a pair, print the smaller element first. Order of different pairs doesn't matter.
//	Input format :
//	The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//	The following line of input contains an integer, that denotes the value of S.
//	Output Format :
//	Print each pair in a new line, as described in the task. 
//	Constraints:
//	Time Limit: 1 second
//	Sample Input 1:
//	5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//	15
//	Sample Output 1:
//	5 10
//	6 9
//	
	static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        if(root==null)
            return;
        int[] arr=arrayInsertion(root);//this will represent tree in arr
        Arrays.sort(arr);//Sorting
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==sum){
                System.out.println(arr[i]+" "+arr[j]);
                i++;
                j--;}
            else if(arr[i]+arr[j]<sum)
                i++;
            else 
                j--;

        }
    }

	private static int[] arrayInsertion(BinaryTreeNode<Integer> root) {

		if (root == null) {
			int[] arr = new int[0];
			return arr;
		}
		int firstData = root.data;

		int[] jrr = arrayInsertion(root.leftNode);

		int[] krr = arrayInsertion(root.rightNode);
		int[] finalArray = new int[1 + jrr.length + krr.length];
		int k = 0;
		finalArray[k] = firstData;
		k++;
		for (int i = 0; i < jrr.length; i++) {
			finalArray[k] = jrr[i];
			k++;
		}
		for (int i = 0; i < krr.length; i++) {
			finalArray[k] = krr[i];
			k++;
		}
		return finalArray;

	}
	
//	LCA of Binary Tree
//	Send Feedback
//	Given a binary tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the binary tree.
//	LCA
//	LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
//	Example:
//	In this example, the green coloured node is the LCA to A and B.
//	Alt Text
//
//	Note:
//	It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection from Y, then Y is the lowest common ancestor.
//	Example:
//	Alt Text
//
//	Note:
//	1. If out of 2 nodes only one node is present, return that node. 
//	2. If both are not present, return -1.
//	Input format:
//	The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//	The following line of input contains two integers, denoting the value of data of two nodes of given binary tree.
//	Output Format:
//	The first and only line of output contains the data associated with the lowest common ancestor node.
//	Constraints:
//	Time Limit: 1 second
//	Sample Input 1:
//	5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//	2 10
//	Sample Output 1:
//	10
//	Sample Input 2:
//	5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//	2 6
//	Sample Output 2:
//	5
//	Sample Input 3:
//	5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//	12 78
//	Sample Output 3:
//	-1

	
	static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if(root==null)
			return -1;
		
		if(root.data==a || root.data==b)
			return root.data;
		
		int c=getLCA(root.leftNode, a, b);
		int d=getLCA(root.rightNode, a, b);
		
		if(c==-1 && d==-1)
			return -1;
		
		if(c==-1 && d!=-1)
			return d;
		
		if(c!=-1 && d==-1)
			return c;
		
		return root.data;
		   
	}

	
//	Print nodes at distance k from node
//	Send Feedback
//	You are given a Binary Tree of type integer, a target node, and an integer value K.
//	Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
//	Example:
//	For a given input tree(refer to the image below):
//	1. Target Node: 5
//	2. K = 2
//	alt txt
//
//	Starting from the target node 5, the nodes at distance K are 7 4 and 1.
//	Input Format:
//	The first line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//
//	The second line of input contains two integers separated by a single space, representing the value of the target node and K, respectively.
//	Output Format:
//	All the node data at distance K from the target node will be printed on a new line.
//
//	The order in which the data is printed doesn't matter.
//	Constraints:
//	1 <= N <= 10^5
//	Where N is the total number of nodes in the binary tree.
//
//	Time Limit: 1 sec
//	Sample Input 1:
//	5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//	3 1
//	Sample Output 1:
//	9
//	6
//	Sample Input 2:
//	1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//	3 3
//	Sample Output 2:
//	4
//	5
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    int x = print(root,k,node);
	}
    
    public static int print(BinaryTreeNode<Integer> root,int k,int elem){
        if(root == null){
            return -1;
        }
        
        if(root.data == elem){
            printAtDepthK(root,k);
            return 0;
        }
        
        int ld = print(root.leftNode,k,elem);
        
        int rd;
        if(ld == -1){
            rd = print(root.rightNode,k,elem);
            if(rd == -1){
                return -1;
            }else if(rd + 1 == k){
                System.out.println(root.data+" ");
                return k;
            }else{
                printAtDepthK(root.leftNode,k-rd-2);
                return rd+1;
            }
        }else if(ld + 1 == k){
            System.out.println(root.data+" ");
            return k;
        }else{
            printAtDepthK(root.rightNode,k-ld-2);
            return ld+1;
        }
        
    }
    
    public static void printAtDepthK(BinaryTreeNode<Integer> root,int depth){
        if(root == null){
            return;
        }
        
        if(depth == 0 && root != null){
            System.out.println(root.data+" ");
            return;
        }
        
        printAtDepthK(root.leftNode,depth-1);
        printAtDepthK(root.rightNode,depth-1);
    }
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		
		rootToLeafPathsSumToK(root, k,0,"");
	}
	
	private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int sum, int data, String path) {
		
		if(root==null)
			return;
		
		if(root.leftNode==null && root.rightNode==null) {
			data=data+root.data;
			if(data==sum)
				System.out.println(path+root.data+" ");
			
			return;
		}
		
		rootToLeafPathsSumToK(root.leftNode, sum,(data+root.data),(path+root.data+" "));
		rootToLeafPathsSumToK(root.rightNode, sum,(data+root.data),(path+root.data+" "));
		
	}
	
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		
		if(root.leftNode==null && root.rightNode!=null)
			System.out.print(root.rightNode.data+" ");
		else if(root.rightNode==null && root.leftNode!=null)
		    System.out.println(root.leftNode.data+" ");
		
		printNodesWithoutSibling(root.leftNode);
		printNodesWithoutSibling(root.rightNode);
	}
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		
		if (root == null) {
			Pair<Integer, Integer> output = new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE);
			return output;
		}

		Pair<Integer, Integer> leftData = getMinAndMax(root.leftNode);
		Pair<Integer, Integer> rightData = getMinAndMax(root.rightNode);

		int min = Math.min(root.data, Math.min(leftData.first, rightData.first));
		int max = Math.max(root.data, Math.max(leftData.second, rightData.second));

		Pair<Integer, Integer> ans = new Pair<Integer, Integer>(min, max);

		return ans;
		
	}
	
//	Create & Insert Duplicate Node
//	Send Feedback
//	For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
//	The root will remain the same. So you just need to insert nodes in the given Binary Tree.
//	Example:
//	alt txt
//
//	After making the changes to the above-depicted tree, the updated tree will look like this.
//	alt txt
//
//	You can see that every node in the input tree has been duplicated and inserted to the left of itself.
//	Input format :
//	The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
//	Output Format :
//	The updated tree will be printed in a level order fashion where each level will be printed on a new line. 
//	Elements on every level will be printed in a linear fashion. A single space will separate them.
//	 Note:
//	You are not required to print anything explicitly. It has already been taken care of. Just implement the function to achieve the desired structure of the tree.
//	Constraints :
//	1 <= N <= 10^5
//	Where N is the total number of nodes in the binary tree.
//
//	Time Limit: 1 sec
//	Sample Input 1:
//	10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
//	Sample Output 1:
//	10 
//	10 30 
//	20 30 60 
//	20 50 60 
//	40 50 
//	40 
//	Sample Input 2:
//	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//	Sample Output 2:
//	8 
//	8 10 
//	5 10 
//	5 6 
//	2 6 7 
//	2 7
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null)
			return ;
		
		BinaryTreeNode<Integer> temp=new BinaryTreeNode<Integer>(root.data);
		
		BinaryTreeNode<Integer> left= root.leftNode;
		
		root.leftNode=temp;
		temp.leftNode=left;
		
		insertDuplicateNode(left);//Dont pass root.leftNode here as the value already updated
		insertDuplicateNode(root.rightNode);
		
		
	}
	
	public static BinaryTreeNode<Integer> buildTreeFromPreorderAndInorder(int[] preOrder, int[] inOrder) {
	    return buildTreeHelper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1); 
	}
    
    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder, int preS, int preEND, int inS,  int inEND){
        if(inS>inEND || preS>preEND){
            return null;
        }
        int rootIndexIn=0;
        int data = preOrder[preS];
        for(int i=inS;i<=inEND;i++){
            if(inOrder[i]==data){
                rootIndexIn=i;
                break;
            }
        }
        
        int lpreST = preS+1;
        int lpreE = lpreST+rootIndexIn-inS-1;
        int linST = inS;
        int linE = rootIndexIn-1;
        int rpreST = lpreE+1;
        int rpreE = preEND;
        int rinST = rootIndexIn+1;
        int rinE = inEND;
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[preS]);
        root.leftNode = buildTreeHelper(preOrder,inOrder,lpreST,lpreE,linST,linE);
        root.rightNode = buildTreeHelper(preOrder,inOrder,rpreST,rpreE,rinST,rinE);   
        return root;
    }
	
//	Construct Tree from Postorder and Inorder
//	Send Feedback
//	For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
//	Note:
//	Assume that the Binary Tree contains only unique elements. 
//	Input Format:
//	The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.
//
//	The second line of input contains N integers, all separated by a single space. It represents the Postorder-traversal of the binary tree.
//
//	The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
//	Output Format:
//	The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
//	Elements on every level will be printed in a linear fashion. A single space will separate them.
//	Constraints:
//	1 <= N <= 10^4
//	Where N is the total number of nodes in the binary tree.
//
//	Time Limit: 1 sec
//	Sample Input 1:
//	7
//	4 5 2 6 7 3 1 
//	4 2 5 1 6 3 7 
//	Sample Output 1:
//	1 
//	2 3 
//	4 5 6 7 
//	Sample Input 2:
//	6
//	2 9 3 6 10 5 
//	2 6 3 9 5 10 
//	Sample Output 2:
//	5 
//	6 10 
//	2 3 
//	9 
    
    public static BinaryTreeNode<Integer> buildTreeFromPostorderAndInorder(int[] post, int[] in) {
		return getTreeFromPostorderAndInorder(post, in, 0, post.length-1, 0, in.length -1);

	}
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,int[] in,int postSI,int postEI,int inSI,int inEI){

		if( inSI>inEI || postSI>postEI ) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>( post[postEI]  );

		int index=0;
		for(int i=inSI;i<=inEI;i++) {
			if(post[postEI] == in[i]) {
				index = i;
				break;
			}
		}

		int leftPostSI=postSI ;
		int leftPostEI= postSI + index - inSI -1;
		int rightPostSI= leftPostEI + 1 ;
		int rightPostEI= postEI-1;

		int leftInSI=inSI;
		int leftInEI=index - 1;
		int rightInSI=index + 1;
		int rightInEI=inEI;

		root.leftNode = getTreeFromPostorderAndInorder(post, in, leftPostSI, leftPostEI, leftInSI, leftInEI);
		root.rightNode = getTreeFromPostorderAndInorder(post, in, rightPostSI, rightPostEI, rightInSI, rightInEI);
		return root;

	}
	public static void inorder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return ;
		
		inorder(root.leftNode);
		System.out.print(root.data+" ");
		inorder(root.rightNode);
	}
	
//	Sample Input 1:
//		1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//  Sample Output 1:
//		1 2 4 5 3 6 7
//	Sample Input 2:
//		5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//	Sample Output 1:
//		5 6 2 3 9 10
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return ;
		
		System.out.print(root.data+" ");
		
		preOrder(root.leftNode);
		preOrder(root.rightNode);
	}
	
//	Sample Input 1: 1 2 3 4 5 6 7-1-1-1-1-1-1-1-1
//	Sample Output 1: 4 5 2 6 7 3 1
//	Sample Input 2:5 6 10 2 3-1-1-1-1-1 9-1-1
//	Sample Output 1:2 9 3 6 10 5

	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return ;
		
		postOrder(root.leftNode);
		postOrder(root.rightNode);

		System.out.print(root.data+" ");
	}

	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		
		int op1=height(root.leftNode)+height(root.rightNode);
		int op2=diameter(root.leftNode);
		int op3=diameter(root.rightNode);
		
		return Math.max(op1, Math.max(op2, op3));
	}
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null)
			return;
		
		BinaryTreeNode<Integer> left=root.leftNode;
		BinaryTreeNode<Integer> right=root.rightNode;

		root.leftNode=right;
		root.rightNode=left;
		
		mirrorBinaryTree(root.leftNode);
		mirrorBinaryTree(root.rightNode);
		
	}
	public static int height(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		
		
		int leftHieght=height(root.leftNode);
		int rightHeight=height(root.rightNode);
		
		return 1+Math.max(leftHieght, rightHeight);
		
	}
	

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		boolean val = false;

		if (root.data == x)
			return true;

		if (root.leftNode != null)
			val = isNodePresent(root.leftNode, x);

		if (val == false) {
			if (root.rightNode != null) {
				val = isNodePresent(root.rightNode, x);
			}
		}

		return val;
	}
	public static int countBinaryTreeNode(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		
		int ans=1;
		ans+=countBinaryTreeNode(root.leftNode);
		ans+=countBinaryTreeNode(root.rightNode);
		
		return ans;
	}
	private static BinaryTreeNode<Integer> takeInputlevelWise() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Root Data : ");
		int rootData=sc.nextInt();
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingQueues= new LinkedList<BinaryTreeNode<Integer>>();
		pendingQueues.add(root);
		
		while (!pendingQueues.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingQueues.poll();

			System.out.println("Enter the left node data for " + frontNode.data);
			int leftdata = sc.nextInt();
			if (leftdata != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftdata);
				pendingQueues.add(leftNode);
				frontNode.leftNode = leftNode;
			}

//			1:L:2,R:3
//			2:L:4,R:-1
//			3:L:5,R:6
//			4:L:-1,R:7
//			5:L:-1,R:-1    
//			6:L:-1,R:-1
//			7:L:-1,R:-1
			System.out.println("Enter the right node data for " + frontNode.data);
			int rightdata = sc.nextInt();
			if (rightdata != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightdata);
				pendingQueues.add(rightNode);
				frontNode.rightNode = rightNode;
			}

		}
		
		return root;
	}

	public static void printTreeNode(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		String tobePrinted = root.data + "";

		if (root.leftNode != null)
			tobePrinted += ": L-" + root.leftNode.data + ",";

		if (root.rightNode != null)
			tobePrinted += ": R-" + root.rightNode.data;

		System.out.println(tobePrinted);

		printTreeNode(root.leftNode);
		printTreeNode(root.rightNode);

	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		if(root==null)
			return;
		
		Queue<BinaryTreeNode<Integer>> pendingQueues= new LinkedList<BinaryTreeNode<Integer>>();
		pendingQueues.add(root);
		
		while(!pendingQueues.isEmpty()) {
			BinaryTreeNode<Integer> front=pendingQueues.poll();
			System.out.print(front.data+":");
			
			if(front.leftNode!=null) {
				pendingQueues.add(front.leftNode);
				System.out.print("L:"+front.leftNode.data+",");
			}else {
				System.out.print("L:-1"+",");
			}
			
			if(front.rightNode!=null) {
				pendingQueues.add(front.rightNode);
				System.out.print("R:"+front.rightNode.data);
			}else {
				System.out.print("R:-1");
			}
			
			System.out.println();
		}
		
	}

	
	public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
		// TODO Auto-generated method stub
		int rootdata;
		System.out.println("Enter the head of BinaryTreeNode data : ");
		rootdata = sc.nextInt();
		if (rootdata == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);

		root.leftNode = takeInput(sc);
		root.rightNode = takeInput(sc);

		return root;
	}

}
