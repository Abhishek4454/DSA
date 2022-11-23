package com.coding.GenericTree;

//Remove leaf nodes in Tree
//Send Feedback
//Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any next.
//Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
//Input format :
//Line 1 : Elements in level order form separated by space (as per done in class). Order is - `
//
//Root_data, n (No_Of_Child_Of_Root), n next, and so on for every element `
//Output Format :
//Elements are printed level wise, each level in new line (separated by space)
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 1 : (Level wise, each level in new line)
//10
//20
public class RemoveleafNodesTree {

	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		} // if root is null return null
		if (root.next.size() == 0) {// if root itself is leaf return null
			return null;
		}
		// if root.next is a leaf node
		// then delete it from next vector
		for (int i = 0; i < root.next.size(); i++) {

			TreeNode child = root.next.get(i);

			// if it is a leaf
			if (child.next.size() == 0) {

				// shifting the vector to left
				// after the point i
				for (int j = i; j < root.next.size() - 1; j++)
					root.next.set(j, root.next.get(j + 1));

				// delete the last element
				root.next.remove(root.next.size() - 1);

				i--;
			}
		}

		// Remove all leaf node
		// of next of root
		for (int i = 0; i < root.next.size(); i++) {

			// call function for root.next
			root.next.set(i, removeLeafNodes(root.next.get(i)));
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUse tree = new TreeUse();
		TreeNode<Integer> root = tree.takeInputLevelWise();
		System.out.println(removeLeafNodes(root));
	}

}
