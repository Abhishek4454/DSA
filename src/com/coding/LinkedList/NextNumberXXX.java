package com.coding.LinkedList;


//Next Number
//Send Feedback
//Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).
//Note: You don't need to print the elements, just update the elements and return the head of updated LL.
//Input Constraints:
//1 <= Length of Linked List <=10^6.
//Input format :
//Line 1 : Linked list elements (separated by space and terminated by -1)
//Output Format :
//Line 1: Updated linked list elements 
//Sample Input 1 :
//3 9 2 5 -1
//Sample Output 1 :
//3 9 2 6
//Sample Input 2 :
//9 9 9 -1
//Sample Output 1 :
//1 0 0 0 
public class NextNumberXXX {
	public static Node<Integer> nextLargeNumber(Node<Integer> head) {
        
        return addDigit(head,1);
	}

   // Function to reverse a given linked list
    public static Node<Integer> reverse(Node<Integer> head)
    {
    	Node<Integer> prev = null;
    	Node<Integer> current = head;
    	Node<Integer> next;
 
        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            next = current.next;
 
            // fix the current node
            current.next = prev;
 
            // advance the two pointers
            prev = current;
            current = next;
        }
 
        // fix the head pointer to point to the new front
        head = prev;
        return head;
    }
 
    // Function to add a single-digit number to a singly linked list
    // whose nodes represent digits of a number
    public static Node<Integer> addDigit(Node<Integer> head, int digit)
    {
        // empty list
        if (head == null) {
            return new Node<Integer>(digit);
        }
 
        // reverse the linked list
        head = reverse(head);
 
        // initialize carry with the given digit
        int carry = digit;
 
        // traverse the reversed list
        Node<Integer> curr = head;
        while (carry > 0)
        {
            // get a sum of the current node and carry
            int sum = curr.data + carry;
 
            // update value of the current node with the single-digit sum
            curr.data = sum % 10;
 
            // set carry for the next node
            carry = sum / 10;
 
            // break if the current node is the last
            if (curr.next == null) {
                break;
            }
 
            // move to the next node
            curr = curr.next;
        }
 
        // add a new node at the end of the linked list if there is any carry left
        if (carry > 0) {
            curr.next = new Node<Integer>(carry);
        }
 
        // reverse the list again to restore the original order
        head = reverse(head);
        return head;
    }
	public static void main(String[] args) {
		AllLinkedListProblem ll= new AllLinkedListProblem();
		Node<Integer> head=ll.takeInput();
	    ll.printLL(nextLargeNumber(head));
	}
}
