
public class MyStack<T> {
	Node<T> head;
	Node<T> tail;

	// thêm node vào stack
	public void addStack(T item) {
		Node<T> newNode = new Node<T>(item);
		if (this.tail == null && this.head == null) {
			this.tail = newNode;
			this.head = newNode;
		}

		else {
			newNode.setNext(this.head);
			this.head = newNode;
		}
	}
	// Hiển thị với dấu phẩy
	public String display() {
		System.out.println();
		String z = this.head.getInfor().toString();
		Node<T> current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
			z += current.getInfor().toString();
		}
		return z;

	}
	// Hiển thị bảng
	public void toStringxx() {
		((Product) this.head.getInfor()).toStringx();
		Node<T> current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
			((Product) current.getInfor()).toStringx();

		}

	}

}