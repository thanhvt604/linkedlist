
public class MyQueue<T> {
	Node<T> tail ;
	Node<T> head;
	public void enQueue(T item)
	{
		Node<T> newNode=new Node<T>(item);
		if(this.tail==null&&this.head==null)
		{
			this.head=this.tail=newNode;
		}
		
		this.tail.setNext(newNode);
		this.tail=newNode;
		
	}
	// Hiển thị với dấu phẩy
	public String display() 
	{
		System.out.println();
		String z=this.head.getInfor().toString();
		Node<T> current=this.head;
		while(current.getNext()!=null)
		{
			current=current.getNext();
			z+=current.getInfor().toString();
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
