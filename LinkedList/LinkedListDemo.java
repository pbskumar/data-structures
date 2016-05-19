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