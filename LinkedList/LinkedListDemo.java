import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Node {
	int data;
	Node next;
	
	Node() {
		data = 0;
		next = null;
	}
	
	Node(int data) {
		this.data = data;
		next = null;
	}
	
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class LinkedList {
	
	private Node head;
	
	LinkedList() {
		head = null;
	}
	
	LinkedList(int data) {
	
		head = new Node(data);
	}
	
	LinkedList(Node head) {
		this.head = head;
	}
	
	public Node getHead() {
		return head;
	}
	
	private Node getLastNode() {
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		return temp;
	}
	
	// Adds node to the front of LinkedList
	public void pushNode(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	
	public void pushNode(Node node) {
		node.next = head;
		head = node;
	}
	
	public void insertNodeAtIndex(int index, int data) {
		Node current = head;
		Node prev = null;
		Node newNode = new Node(data);
		
		if(index == 0) { 
			pushNode(newNode);
			return;
		}
		
		for(int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
			
			if(current == null) {
				System.out.println("Index exceeds length of Linked List");
				return;				
			}
		}
		
		prev.next = newNode;
		newNode.next = current;
		
	}
	
	public void insertNodeAtIndex(int index, Node node) {
		Node current = head;
		Node prev = null;
		
		if(index == 0) { 
			pushNode(node);
			return;
		}
		
		for(int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
			
			if(current == null) {
				System.out.println("Index exceeds length of Linked List");
				return;				
			}
		}
		
		prev.next = node;
		node.next = current;
		
	}
	
	public void appendNode(int data) {
		
		if(head == null){
			head = new Node(data);
		}
		else {
			Node lastNode = getLastNode();
			lastNode.next = new Node(data);
		}
		
	}
	
	public void appendNode(Node node) {
		
		if(head == null) {
			head = node;
		}
		else {
			Node lastNode = getLastNode();
			lastNode.next = node;
		}
	}
	
	// Deletes the first occurrence of data
	public void deleteNode(int data) {
		Node current = head;
		Node prev = null;
		
		if(current != null && head.data == data) {
			head = current.next;
			return;
		}
		
		while(current != null && current.data != data) {
			prev = current;
			current = current.next;
		}
		
		if(current == null) {
			System.out.println("Data not found");
			return;
		}
		
		prev.next = current.next;
		System.out.println("Deleted: " + data);
		
	}
	
	// Follows 0-indexing.
	public void deleteNodeAtIndex(int index) {
		Node current = head;
		Node prev = null;
		
		if(index == 0) {
			head = current.next;
			return;
		}
		
		for(int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
			if(current == null) {
				System.out.println("Index exceeds length of Linked List");
				return;
			}
		}
		
		prev.next = current.next;
		System.out.println("Deleted node at index: " + index);	
		
	}
	
	public void printLinkedList() {
		Node temp = head;
		
		if(temp == null) {
			System.out.println("The Linked List is empty!");
			return;
		}
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	public int getLength() {
		Node temp = head;
		int length = 0;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	public void swapNodes(int data1, int data2) {
		Node current1 = head, current2 = head;
		Node prev1 = null, prev2 = null;
		Node temp;
		
		if(data1 == data2) {
			System.out.println("Cannot swap same numbers.");
			return;
		}
		
		while(current1 != null && current1.data != data1) {
			prev1 = current1;
			current1 = current1.next;
		}
		
		while(current2 != null && current2.data != data2) {
			prev2 = current2;
			current2 = current2.next;
		}
		
		if(current1 == null || current2 == null) {
			System.out.println("Data not found! Unable to swap.");
			return;
		}
		
		// Case if Data1 is present in head Node
		if(prev1 != null)
			prev1.next = current2;
		else
			head = current2;
		
		// Case if Data2 is present in head Node
		if(prev2 != null)
			prev2.next = current1;
		else
			head = current1;
		
		temp = current2.next;
		current2.next = current1.next;
		current1.next = temp;		
		
	}
	
	public LinkedList reverseIteratively() {
		Node current = head;
		Node prev = null;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		// prev will be the head to the reversed LinkedList
		
		return new LinkedList(prev);
	}
	
	public LinkedList reverseRecursively() {
		Node temp = head;
		
		if(temp == null) return null;
		
		temp = reverseRecursiveHelper(temp, null);
		
		return new LinkedList(temp);
		
	}
	
	private Node reverseRecursiveHelper(Node current, Node prev) {
		Node tempHead = null;
		if(current.next == null) {
			current.next = prev;
			tempHead = current;
			return tempHead;
		}
		
		tempHead = reverseRecursiveHelper(current.next, current);
		current.next = prev;
		
		return tempHead;
	}
	
	public LinkedList rotateLinkedList(int k) {
		// Given a number k, the linked list will be rotated right by k nodes
		// 4->5->6->7->8 rotated by k=2 becomes 7->8->4->5->6
		
		int i = 0;
		Node rotateHead = head;
		Node temp = head;
		
		while (i < k && temp != null) {
			i++;
			temp = temp.next;
		}
		
		if (temp == null)
			return new LinkedList();
		
		while (temp.next != null) {
			temp = temp.next;
			rotateHead = rotateHead.next;
		}
		
		temp.next = head;
		head = rotateHead.next;
		rotateHead.next = null;
		
		return new LinkedList(head);
		
	}
	
}



public class LinkedListDemo {
	
	public static LinkedList mergeSortedLinkedLists(LinkedList list1, LinkedList list2) {
		LinkedList mergedLL = new LinkedList();
				
		Node current1 = list1.getHead();
		Node current2 = list2.getHead();
		
		
		while (true) {
			if(current1 == null && current2 == null)
				break;
			if (current1 == null && current2 != null) {
				// appending the reamaining nodes in List2. 
				// Uses the appendNode(Node) function. 
				// All remaining nodes are appended at once.
				mergedLL.appendNode(current2);
				break;
			}
			if (current1 != null && current2 == null) {
				// appending the reamaining nodes in List1.
				// Uses the appendNode(Node) function. 
				// All remaining nodes are appended at once.
				mergedLL.appendNode(current1);
				break;
			}
			
			if (current1.data <= current2.data) {
				// appends data using appendNode(int) function
				mergedLL.appendNode(current1.data);
				current1 = current1.next;
			}
			else {
				// appends data using appendNode(int) function
				mergedLL.appendNode(current2.data);
				current2 = current2.next;
			}
			
		}
		
		return mergedLL;
		
	}
	
	public static LinkedList mergeSort(Node head) {
		if(head.next == null)
			return new LinkedList(head);
		
		// Get central node in the list
		// Node centralNode = getCenterNode(head);
		
		Node first = head;
		//Node second = head.next;
		//head.next = null;
		Node second = getCenterNode(head);
		
		LinkedList sortedSubList1 = mergeSort(first);
		LinkedList sortedSubList2 = mergeSort(second);
		
		
		Node sortedList = mergeSortedLinkedLists(sortedSubList1, sortedSubList2).getHead();
		
		return new LinkedList(sortedList);
	}
	
	public static Node getCenterNode(Node head) {
		Node fastRef = head;
		if (fastRef == null || fastRef.next == null) 
			return null;
		
		Node slowRef = fastRef;
		while (fastRef != null) {
			fastRef = fastRef.next;
			if(fastRef != null && fastRef.next != null) {
				fastRef = fastRef.next;
				slowRef = slowRef.next;
			}
		}
		
		Node centerRef = slowRef.next;
		slowRef.next = null;
		return centerRef;
		
	}
	
	public static LinkedList sumOfLL(LinkedList list1, LinkedList list2) {
		// Returns sum of numbers which are represented as linked lists
		// 234 is represented as 4->3->2
		
		Node temp1 = list1.getHead();
		Node temp2 = list2.getHead();
		
		int a = 0, b =0, sum = 0, carry = 0;
		
		LinkedList sumList = new LinkedList();
		
		while (temp1 != null || temp2 != null) {
			a = (temp1 != null)? temp1.data: 0;
			b = (temp2 != null)? temp2.data: 0;
			
			sum = a + b + carry;
			carry = sum / 10;
			sum = sum % 10;
			
			sumList.appendNode(sum);
			
			if(temp1 != null)
				temp1 = temp1.next;
			
			if(temp2 != null)
				temp2 = temp2.next;
			
		}
		
		if(carry > 0) sumList.appendNode(carry);
		
		return sumList;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
			
		
		Scanner sc = new Scanner(System.in);
		LinkedList lList = new LinkedList();
		
		File file =  new File("input.txt");
		Scanner fsc = new Scanner(file);	
		while (fsc.hasNext()) 
		lList.appendNode(fsc.nextInt());
	
		
		System.out.println("\n\n");
		System.out.println("The Linked List created is:");
		lList.printLinkedList();
		
		System.out.println("\n\n");
		System.out.println("The rotated Linked List created is:");
		lList.rotateLinkedList(2).printLinkedList();
		
		
		/*
		// Unit test for sum of linked lists
		
		LinkedList lList1 = new LinkedList();
		LinkedList lList2 = new LinkedList();
		
		File file1 =  new File("input3.txt");
		File file2 =  new File("input4.txt");
		
		Scanner fsc1 = new Scanner(file1);	
		Scanner fsc2 = new Scanner(file2);	
		
		
		while (fsc1.hasNext()) 
			lList1.appendNode(fsc1.nextInt());
		
		while (fsc2.hasNext()) 
			lList2.appendNode(fsc2.nextInt());
	
		
		System.out.println("\n");
		System.out.println("Linked List 1:");
		lList1.printLinkedList();
		
		System.out.println("\n");
		System.out.println("Linked List 2:");
		lList2.printLinkedList();
		
		System.out.println("\n\n");
		System.out.println("Sum of the Lists:");
		sumOfLL(lList1, lList2).printLinkedList();
		*/
		
		
		/*
		// Test unit for mergeSort
		System.out.println("\n\n");
		System.out.println("The sorted Linked List is:");
		mergeSort(lList.getHead()).printLinkedList();
		*/
		
		
		/*
		LinkedList lList1 = new LinkedList();
		LinkedList lList2 = new LinkedList();
		
		File file1 =  new File("input1.txt");
		File file2 =  new File("input2.txt");
		
		Scanner fsc1 = new Scanner(file1);	
		Scanner fsc2 = new Scanner(file2);	
		
		
		while (fsc1.hasNext()) 
			lList1.appendNode(fsc1.nextInt());
		
		while (fsc2.hasNext()) 
			lList2.appendNode(fsc2.nextInt());
	
		
		System.out.println("\n");
		System.out.println("Linked List 1:");
		lList1.printLinkedList();
		
		System.out.println("\n");
		System.out.println("Linked List 2:");
		lList2.printLinkedList();
		
		System.out.println("\n\n");
		System.out.println("Merged List:");
		mergeSortedLinkedLists(lList1, lList2).printLinkedList();
		
		
		*/
		
		/*
		System.out.println("\n\n");
		System.out.println("The reversed Linked List created is:");
		lList.reverseRecursively().printLinkedList();
		
		
		System.out.println("\n\n");
		System.out.println("The reversed Linked List created is:");
		lList.reverseIteratively().printLinkedList();

				
		System.out.println("Enter data to be swapped: ");
		lList.swapNodes(sc.nextInt(), sc.nextInt());
		
		System.out.println("\n\n");
		System.out.println("The Linked List is:");
		lList.printLinkedList();
		
		System.out.println("The length of linked list is: " + lList.getLength());
		
		// 0-indexing
		//Inserting Node at Index i
		System.out.println("\n\n");
		System.out.println("Enter the data of node to be inserted:");
		nodeData = sc.nextInt();
		System.out.println("Enter the index of node to be inserted:");
		lList.insertNodeAtIndex(sc.nextInt(), nodeData);
		
		System.out.println("\n\n");
		System.out.println("The Linked List is:");
		lList.printLinkedList();
		
		
		
		
		// Deleting Node, given data
		System.out.println("\n\n");
		System.out.println("Enter the data to be deleted:");
		nodeData = sc.nextInt();
		lList.deleteNode(nodeData);
		
		System.out.println("\n\n");
		System.out.println("The Linked List is:");
		lList.printLinkedList();
		
		
		// Deleting node, given Index
		System.out.println("\n\n");
		System.out.println("Enter the index of the node to be deleted:");
		lList.deleteNodeAtIndex(sc.nextInt());
		
		System.out.println("\n\n");
		System.out.println("The Linked List is:");
		lList.printLinkedList();
			
		*/
	}
}