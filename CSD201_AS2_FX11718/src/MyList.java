import java.util.EmptyStackException;
import java.util.Scanner;

public class MyList<T> {

	Node<T> head = null;
	Node<T> tail = null;
	int count = 0;
	int y = 0;

	Scanner sc = new Scanner(System.in);

	// Link list trống
	public boolean Empty() {
		return head == null;

	}

	// Xoá list
	void clear() {
		head = tail = null;
	}

	// Đếm chiều dài của linklist.
	public int lenght() {
		int count = 1;
		if (head == null) {
			return 0;
		}
		Node<T> current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
			count++;
		}
		return count;

	}

	// thêm 1 node ở cuối danh sách
	public void insertToTail(T item) {
		Node<T> newNode = new Node<T>(item);
		if (this.tail == null) {
			this.tail = newNode;
			this.head = newNode;

		}
		this.tail.setNext(newNode);
		this.tail = newNode;

	}

	// Thêm 1 node ở đâu danh sách list
	public Node<T> insertToHead(T item) {
		Node<T> newNode = new Node<T>(item);
		if (this.head == null) {
			this.head = newNode;
		}

		else {
			newNode.setNext(this.head);
			this.head = newNode;
		}
		return newNode;
	}

	// Xóa 1 node ở cuối danh sách

	public void deleteTail() {
		// nếu list trống ném except;
		if (Empty()) {
			throw new EmptyStackException();
		}
		Node<T> temp = null;
		Node<T> current = this.head;
		while (current.getNext() != null) {
			temp = current;
			current = current.getNext();
		}
		temp.setNext(null);
		this.tail = temp;

	}

	// tìm id
	public Node<T> findId(int id) {
		Node<T> newNode = this.head;
		while (newNode.getNext() != null) {
			// tìm Node trừ Node cuối
			if (((Product) newNode.getInfor()).getBarCode() == id) {
				return newNode;
			}
			newNode = newNode.getNext();
			// Xét Node cuối
			if (((Product) newNode.getInfor()).getBarCode() == id) {
				return newNode;
			}
		}
		return null;
	}

	// Xóa 1 Node theo Id
	public void deleteId(Node<T> xx) {

		Node<T> current = this.head;
		// Nếu id tìm đc ở đầu thì xóa node đầu
		if (((Product) current.getInfor()).getBarCode() == ((Product) xx.getInfor()).getBarCode()) {
			this.head = current.getNext();
		}

		//
		while (current.getNext() != null
				&& ((Product) current.getNext().getInfor()).getBarCode() != ((Product) xx.getInfor()).getBarCode()) {
			current = current.getNext();
		}

		current.setNext(xx.getNext());

	}

	// Đổi chỗ 2 node
	public void swap(Node<T> firstNode, Node<T> secondNode)

	{
		// x1,x2 là node trước của node đc xét
		Node<T> x1 = null;
		Node<T> x2 = null;
		Node<T> current1 = this.head;
		Node<T> current2 = this.head;
		// trường hợp 2 node trùng nhau
		if (firstNode == secondNode) {
			return;
		}
		while (current1 != null && current1 != firstNode) {
			x1 = current1;
			current1 = current1.getNext();

		}
		while (current2 != null && current2 != secondNode) {
			x2 = current2;
			current2 = current2.getNext();
		}
		// trường hợp 2 node trống
		if (current1 == null || current2 == null)
			return;
		// trường hợp bình thường
		if (x1 != null) {
			x1.setNext(current2);
			;
		}
		// trường hợp node xét nằm ở đầu
		else {
			this.head = current2;

		}

		if (x2 != null) {
			x2.setNext(current1);
		} else {
			this.head = current1;
			System.out.println("11123");
		}

		Node<T> temp = current1.getNext();

		current1.setNext(current2.getNext());

		current2.setNext(temp);

	}

	// Sắp xếp node theo pp bubble sort
	public void sortBubble() {

		boolean x = true;
		Node<T> current = this.head;
		// Nếu Node hiện tại lớn hơn Node trước nó thì đổi chỗ , nếu không có vị trí nào
		// cần đổi thì dừng
		while (current != null && current.getNext() != null) {
			if (((Product) current.getInfor()).getBarCode() > ((Product) current.getNext().getInfor()).getBarCode()) {
				swap(current, current.getNext());
				x = false;
			}

			current = current.getNext();
		}
		// Đệ quy
		if (x == false) {
			sortBubble();
		}

	}

	public void toStringxx() {
		((Product) this.head.getInfor()).toStringx();
		Node<T> current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
			((Product) current.getInfor()).toStringx();

		}

	}

	// Lấy Node đầu
	public int getfirstNode() {
		return ((Product) this.head.getInfor()).getQuantity();
	}

	// Trả về Chuỗi nhị phân
	public String Binary(int x) {

		String z = "";
		if (x == 0 && x % 2 != 1) {
			return " ";
		} else {
			return z + (x % 2) + Binary(x / 2);
		}

	}

	public String toString() {
		String z = ((Product) this.head.getInfor()).toString();
		Node<T> current = this.head;
		while (current.getNext() != null) {
			current = current.getNext();
			z += ((Product) current.getInfor()).toString();

		}
		return z;
	}
}