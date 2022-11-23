package com.coding.LinkedList;

import java.util.Iterator;
import java.util.Scanner;

public class AllLinkedListProblem {
	
//	AppendLastNToFirst
//	Send Feedback
//	You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.
//	Input format :
//	The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//	The first line of each test case or query contains the elements of the singly linked list separated by a single space. 
//
//	The second line contains the integer value 'N'. It denotes the number of nodes to be moved from last to the front of the singly linked list.
//	Remember/Consider :
//	While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//	Output format :
//	For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.
//
//	Output for every test case will be printed in a seperate line.
//	Constraints :
//	1 <= t <= 10^2
//	0 <= M <= 10^5
//	0 <= N < M
//	Time Limit: 1sec
//
//	Where 'M' is the size of the singly linked list.
//	Sample Input 1 :
//	2
//	1 2 3 4 5 -1
//	3
//	10 20 30 40 50 60 -1
//	5
//	Sample Output 1 :
//	3 4 5 1 2
//	20 30 40 50 60 10
//	Sample Input 2 :
//	1
//	10 6 77 90 61 67 100 -1
//	4
//	Sample Output 2 :
//	90 61 67 100 10 6 77 
//	 Explanation to Sample Input 2 :
//	We have been required to move the last 4 nodes to the front of the list. Here, "90->61->67->100" is the list which represents the last 4 nodes. When we move this list to the front then the remaining part of the initial list which is, "10->6->77" is attached after 100. Hence, the new list formed with an updated head pointing to 90.
	
	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {//VVIP
		
		 if(head==null || n==0)
				return head;
		
		Node<Integer> fastNode= head;
		Node<Integer> slowNode= head;
		Node<Integer> initiaHead= head;
		
		for (int i = 0; i < n; i++) {
			fastNode=fastNode.next;
		}
		
		while(fastNode.next!=null)
		{
			slowNode=slowNode.next;
			fastNode=fastNode.next;
		}
		
		Node<Integer> temp= slowNode.next;
        slowNode.next=null;//this becomes end
        fastNode.next=initiaHead;
        head=temp;

        return head;
        
//        LinkedListNode<Integer> temp=null;
//        LinkedListNode<Integer> end=null;
//        int length=1;
//        end=root;
//        
//        if(end==null)
//            return root;
//       //pointing this end node to last node
//        while(end.next!=null){
//          length++;
//          end=end.next;
//        }
//        int i=1;
//        temp=root;
//        //pointing this temp node to the (length-2)node i.e the node after this we have to append 
//        //if n==2 then we will point to 8th node
//        while(i<length-n){
//          i++;
//          temp=temp.next;
//        }
//        end.next=root;
//        root=temp.next;
//        temp.next=null;
//        return root;
	}

//	Eliminate duplicates from LL
//	Send Feedback
//	You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.
//	 Input format :
//	The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//
//	The first and the only line of each test case or query contains the elements(in ascending order) of the singly linked list separated by a single space.
//	 Remember/Consider :
//	While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//	 Output format :
//	For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.
//
//	Output for every test case will be printed in a seperate line.
//	Constraints :
//	1 <= t <= 10^2
//	0 <= M <= 10^5
//	Time Limit: 1sec
//
//	Where 'M' is the size of the singly linked list.
//	Sample Input 1 :
//	1
//	1 2 3 3 3 3 4 4 4 5 5 7 -1
//	Sample Output 1 :
//	1 2 3 4 5 7 
//	Sample Input 2 :
//	2
//	10 20 30 40 50 -1
//	10 10 10 10 -1
//	Sample Output 2 :
//	10 20 30 40 50
//	10
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		
		if(head==null || head.next==null)
			return head;
		Node<Integer> temp=head;
		
		while (temp.next != null) {
			if (temp.data.equals((temp.next).data))
				temp.next = temp.next.next;
			else
				temp = temp.next;

		}

		return head;
	}

	public static void printReverse(Node<Integer> root) {
		if(root==null)
			return ;
		
		printReverse(root.next);
		System.out.print(root.data+" ");
	}

	static Node<Integer> left=null;
	public static boolean isPalindrome(Node<Integer> head) {
	    left=head;  
      return find(head);
    	
  	}
   public static boolean find(Node<Integer> right){
   	 if(right==null){
        return true;
      }
      boolean val=find(right.next);
      if(val==true){
        if(left.data==right.data){
          left=left.next;
          return true;
        }
      }
      return false;
	}
	public static int findNode(Node<Integer> head, int n) {
		if(head==null)
			return -1;
		int pos=0;
		Node<Integer> temp= head;
		
		
		while(temp!=null) {
			if(temp.data==n)
				break;
			  
			pos++;
			temp=temp.next;
			
			
		}
		
		if(temp==null)
			pos=-1;
		
		return pos;
	}
	
	public static int findNodeRec(Node<Integer> head, int n) {
		
		return findNodeRec(head, n,0);
			
	}

	
	private static int findNodeRec(Node<Integer> head, int n, int pos) {
		
		
		if(head==null)
			return -1;
		
		if(head.data==n)
			return pos;
		
		
		pos=findNodeRec(head.next, n,pos+1);
		
		return pos;
	}

	public static void printLL(Node<Integer> head) {
		while(head!=null) {
			   System.out.print(head.data+" ");
			   head= head.next;
		   }
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

    public static Node<Integer> midPoint(Node<Integer> head) {
        Node<Integer> slow=head;
        Node<Integer> fast=head;
       
        if(head==null || head.next==null)
        	return head;
        while(fast.next!=null && fast.next.next!=null) {
        	slow=slow.next;
        	fast=fast.next.next;
        	
        }

         return slow;
    }

    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
    	if(head1==null)
    		return head2;
    	if(head2==null)
    		return head1;
    	Node<Integer> t1=head1,t2=head2,tail=null,head=null;
    	if(head1.data<=head2.data) {
    		head=t1;
    		tail=t1;
    		t1=t1.next;
    	}else {
    		head=t2;
    		tail=t2;
    		t2=t2.next;
    	}
    		
    	while(t1!=null && t2!=null) {
    		if(t1.data<=t2.data) {
    			tail.next=t1;
    			tail=t1;
    			t1=t1.next;
    		}else {
    			tail.next=t2;
    			tail=t2;
    			t2=t2.next;
    		}
    	}
    	
    	if(t1==null) {
    		tail.next=t2;
    	}
    	if(t2==null) {
    		tail.next=t1;
    	}
    	
    	
    	return head;
    	
    }
	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head==null || head.next==null)
			return head;
		
		Node<Integer> midNode=midPoint(head);
		Node<Integer> h2=midNode.next;
		midNode.next=null;
		Node<Integer> part1=mergeSort(head);
		Node<Integer> part2=mergeSort(h2);
		
		return mergeTwoSortedLinkedLists(part1,part2);
		
	}

	public static Node<Integer> insertRecursively(Node<Integer> head,int pos,int element){
		
		if(pos==0) {
			Node<Integer> newNode=new Node<Integer>(element);
			newNode.next=head;
			return newNode;
		}
		if(head==null)
			return head;
		head.next = insertRecursively(head.next, pos-1, element);
		
		return head;
		
	}
	
	public static Node<Integer> deleteRecursively(Node<Integer> head, int pos) {

		if (pos == 0) {
			return head.next;
		}
		if (head == null)
			return head;

		head.next = deleteRecursively(head.next, pos - 1);

		return head;

	}
    
	public static Node<Integer> reverseLinkedListRec(Node<Integer> head) {
		if(head==null || head.next==null)
			return head;
		
		Node<Integer> finalHead= reverseLinkedListRec(head.next);
		
		Node<Integer> temp=finalHead;
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		temp.next=head;
		head.next=null;
		
		return finalHead;
		
		
	}

	//Reverse using Double Node
	public static DoubleNode<Integer> reverseLLBetter(Node<Integer> head) {

		if (head == null || head.next == null) {
			DoubleNode<Integer> doubleNode = new DoubleNode<Integer>();
			doubleNode.head = head;
			doubleNode.tail = head;
			return doubleNode;
		}

		DoubleNode<Integer> smallAns = reverseLLBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		
		DoubleNode<Integer> finalAns= new DoubleNode<Integer>();
		finalAns.head=smallAns.head;
		finalAns.tail=head;
		
		return finalAns;

	}
	
	    //Reverse with T(O)n=1
	public static Node<Integer> reverseLLBetterWithoutDN(Node<Integer> head) {

			if(head==null || head.next==null)
				return head;
			
			Node<Integer> reversetail=head.next;//this is to store the tail for the head.next
			Node<Integer> finalHead= reverseLinkedListRec(head.next);
			
			reversetail.next=head;
			head.next=null;
			
			return finalHead;

		}
	
	public static Node<Integer> reverseLLIterative(Node<Integer> head) {

		if(head==null || head.next==null)
			return head;
		
		Node<Integer> curr=head,prev=null,temp;
		
		while(curr!=null) {
			temp=curr.next;
			curr.next=prev;//prev will point to the last node
			prev=curr;
			curr=temp;
		}
          return prev;
	}

	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		
		Node<Integer> eh=null,et=null,oh=null,ot=null;
		
		while (head != null) {
			if (head.data % 2 == 0) {
				if (eh == null) {
					eh = head;
					et = head;
					
				} else {
					et.next = head;
					et=et.next;
					
				}
			} else {
				if (oh == null) {
					oh = head;
					ot = head;
					
				} else {
					ot.next = head;
					ot=ot.next;
					
				}
			}
			head=head.next;
		}
			
		if (oh == null)
			return eh;
		else
			ot.next = eh;
		 
		if(eh!=null) {
			ot.next=eh;
			et.next=null;
		}
		
		return oh;
	}

	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		
		if(head==null || M==0)
			return null;
		
		if(N==0)
			return head;
		
		Node<Integer> currNode=head,temp=null;
		
		while(currNode!=null) {
			int take=1,skip=1;
			while(currNode!=null && take<=M) {
				if (temp == null)
					temp = currNode;
				else {
					temp.next = currNode;
					temp = currNode;
				}
				currNode = currNode.next;
				take++;
			}
			
			while(currNode!=null && skip<=N) {
				currNode=currNode.next;
				skip++;
			}
			
		}
		
		if(temp!=null)
			temp.next=null;
		
		return head;
		
	}
	
	//Swap two Nodes of LL
    //at ith and jth pos
	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		
		if(i==j)
			return head;
		
		Node<Integer> currNode=head,prev=null;
		Node<Integer> c1=null,c2=null,p1=null,p2=null;
		int pos=0;
		while(currNode!=null) {
			if(pos==i) {
				p1=prev;
				c1=currNode;
			}else if(pos==j) {
				p2=prev;
				c2=currNode;
			}
			pos++;
			prev=currNode;
			currNode=currNode.next;
		}
		
		if(p1!=null) {
			p1.next=c2;
		}else {
			head=c2;//when j==0 i.e at front of LL
		}
		
		if(p2!=null) {
			p2.next=c1;
		}else {
			head=c1;//when i==0 i.e at front of LL
		}
		
		Node<Integer> currentFirstNode=c2.next;
		c2.next=c1.next;
		c1.next=currentFirstNode;
		
		return head;
		
	}
	
	public static Node<Integer> bubbleSort(Node<Integer> head) {
		 if(head==null || head.next==null)
	        return head;
	        //Write your code here
	        for(int i=0;i<lengthLL(head)-1;i++){
	            Node<Integer> prev = null;
	            Node<Integer> curr = head;
	            Node<Integer> next = curr.next;

	            while(curr.next != null){
	                if(curr.data > curr.next.data){
	                    if(prev == null){
	                        curr.next = next.next;
	                        next.next = curr;
	                        prev = next;
	                        head = prev;
	                    }else{
	                        next = curr.next;
	                        curr.next = next.next;
	                        prev.next = next;
	                        next.next = curr;
	                        prev = next;
	                    }
	                }else{
	                    prev = curr;
	                    curr = curr.next;
	                }
	            }
	        }
	        return head;
	    }
	    
	private static int lengthLL(Node<Integer> head){
	        int count = 1;
	        while(head.next != null){
	            head = head.next;
	            count++;
	        }
	        return count;
	    }
	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		
		if(k==0 || k==1 )
			return head;
		if(head==null)
			return head;
		
		Node<Integer> curr=head,fwd=null,prev=null;
		int pos=0;
		while(pos<k) {
			fwd=curr.next;
			curr.next=prev;
			prev=curr;
			curr=fwd;
			pos++;
		}
		
		if(fwd!=null)
			head.next=kReverse(fwd, k);
		
		return prev;
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Node<Integer> head=takeInput();
         //printLL(head);
        // System.out.println(findNode(head, 6));
        // printLL(removeDuplicates(head));
         //printReverse(head);
         //System.out.println(isPalindrome(head));
         //printLL(mergeSort(head));
         //printLL(insertRecursively(head, 2, 10));
         //printLL(deleteRecursively(head, 2));
         //printLL(reverseLinkedListRec(head));
         
        //DoubleNode<Integer> doubleNode=reverseLLBetter(head);
       // printLL(doubleNode.head);
         //printLL(reverseLLBetterWithoutDN(head));
         //printLL(reverseLLIterative(head));
         //System.out.println(findNodeRec(head, 6));
        // printLL(evenAfterOdd(head));
         //printLL(swapNodes(head, 1, 3));
         printLL(kReverse(head,3));
	}
}
