public class LinkedQueue<E> implements GenericQueue<E> {

    Node<E> head, tail;

    public void add(E item) {
	// special case for first item in queue goes here:

	// whew.
	Node<E> newNode = new Node<E>(item,null);
	tail.next = newNode;
	tail = newNode;
    }

    public E dequeue() {
	// special case for the empty queue:

	//
	E toReturn = head.item;
	head = head.next;
	// can't do most stuff to an E type object ---
	// toReturn.doIt();
	return toReturn;
    }
}