package dlinkedlist;

public interface Iterator {
	int get();
	Iterator advance();
	boolean equals(Iterator other);
}
