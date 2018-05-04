public class Node<D> {

    // for very simple things like this, I don't mind public
    // but don't tell anyone I said so.
    public D item;
    public Node<D> next;

    public Node(D item, Node<D> next) {
	this.item = item;
	this.next = next;
    }
    
}