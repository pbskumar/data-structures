import java.util.*;

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
	
	public void appendData(int data) {
		
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
}


public class LinkedListDemo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LinkedList lList = new LinkedList();
		
		System.out.println("How many elements do you want to insert into the Linked List?");
		
		int size = sc.nextInt();
		int nodeData = 0;
		
		for(int i = 0; i < size; i++) {
			System.out.print("Enter Element: ");
			nodeData = sc.nextInt();
			lList.appendData(nodeData);
		}
		
		System.out.println("\n\n");
		System.out.println("The Linked List created is:");
		lList.printLinkedList();
		
		
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
			
		
	}
}