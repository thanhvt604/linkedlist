

public class Product {
	double price;
	int barCode, quantity;
	String title;

	public Product(String title,int barCode, int quantity, double price) {
		this.barCode = barCode;// mã vạch
		this.quantity = quantity;//Số lượng
		this.price = price;//Giá
		this.title = title;//Tên
	}

	public Product() {
	}

	
	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public void toStringx() {
		System.out.printf("|%-15s|%-15s|%-15s|%-15s|%n",getTitle(),getBarCode(),getQuantity(),getPrice());
	}

	@Override
	public String toString() {
		return getTitle()+","+getBarCode()+ ","+getQuantity()+","+getPrice()+"\n";
	}
	

}
