package dlinkedlist;

public class DList {
	DNode sentinel;
	DList() {
		sentinel = new DNode(444, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	// insert before pos, return iterator pointing to new node
	// TODO
	public Iter insert(Iter pos, int e) {
		
	}

	// erase the node at pos, return iterator to the next element
	// TODO
	public Iter erase(Iter pos) { return null; }

	public boolean empty(){ return sentinel.next == sentinel;}

	public class Iter implements Iterator, BidirectionalIterator {
		DNode curr;
		Iter(DNode n) { curr = n; }
		public int get() { return curr.data; }
		public Iterator advance() {
			curr = curr.next;
			return this;
		}
		
		// TODO
		public BidirectionalIterator retreat() { return null; }
		
		public boolean equals(Iterator other) { 
			return curr == ((Iter)other).curr; 
		}
	}

	public Iter begin() { return new Iter(sentinel.next); }
	public Iter end() { return new Iter(sentinel); }

}
