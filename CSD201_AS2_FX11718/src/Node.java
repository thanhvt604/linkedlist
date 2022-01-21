
public class Node<T> {

	T infor;
	Node<T> next;

	public Node(T infor, Node<T> next) {
		this.infor = infor;
		this.next = next;
	}

	Node(T item) {
		this(item,null);
	}

	public T getInfor() {
		return infor;
	}

	public void setInfor(T infor) {
		this.infor = infor;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node() {
	}

}
