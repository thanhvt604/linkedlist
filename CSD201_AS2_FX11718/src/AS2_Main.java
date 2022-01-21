
import java.util.Scanner;

public class AS2_Main {
	public static void showMenu() {
		System.out.println();
		System.out.println("Choose one of this options:");
		System.out.println("Product list:");
		System.out.println("1. Load data from file and display");
		System.out.println("2. Input & add to the end.");
		System.out.println("3. Display data");
		System.out.println("4. Save product list to file.");
		System.out.println("5. Search by ID");
		System.out.println("6. Delete by ID");
		System.out.println("7. Sort by ID.");
		System.out.println("8. Convert to Binary");
		System.out.println("9. Load to stack and display");
		System.out.println("10. Load to queue and display.");
		System.out.println("0. Exit");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OperationToProduct x = new OperationToProduct();
		MyList<Product> listProduct = new MyList<Product>();
		MyStack<Product> listStack = new MyStack<Product>();
		MyQueue<Product> listQueue = new MyQueue<Product>();
		listProduct.insertToTail(new Product("Sugar",10,66,17));
		listProduct.insertToTail(new Product("Miliket",11,108,17.5));
		listProduct.insertToTail(new Product("Rose",3,199,55.5));
		int key = 1;
		
		do {
			showMenu();
			System.out.print(" You Choose : ");
			key = sc.nextInt();
			switch (key) {
			// lấy dữ liệu từ file và hiển thị ra màn hình
			case 1: {
				System.out.println("-----------------------------------------------------------------");
				System.out.printf("|%-15s|%-15s|%-15s|%-15s|%n","Title","BarCode","Quantity","Price");
				System.out.println("-----------------------------------------------------------------");
				x.getAllItemsFromFile("data", listProduct);
				System.out.println("-----------------------------------------------------------------");
				System.out.println("Sucesslly!");

				break;

			}
			// Nhập và thêm vào cuối list

			case 2: {
				x.addLast(listProduct);
				break;

			}
			// Hiển thị tất cả linklist
			case 3: {
				System.out.println("-----------------------------------------------------------------");
				System.out.printf("|%-15s|%-15s|%-15s|%-15s|%n","Title","BarCode","Quantity","Price");
				System.out.println("-----------------------------------------------------------------");
				x.displayAll(listProduct);
				System.out.println("-----------------------------------------------------------------");
				break;

			}
			// Lưu linkedlist vào file
			case 4: {
				x.writeAllItemsToFile("data", listProduct);
				System.out.println("Successlly!");
				break;
			}
			// tìm theo Id
			case 5: {
				
				x.searchByCode(listProduct);
				System.out.println("-----------------------------------------------------------------");
				break;

			}
			// xóa theo id
			case 6: {
				x.deleteById(listProduct);
				System.out.println("Delete!");
				break;
			}
			// sắp xếp list theo thứ tự tăng dần
			case 7: {
				x.Swap(listProduct);
				System.out.println("Successlly!");
				break;
			}
			// Nhị phân của Quantity đầu tiên
			case 8:{
				System.out.println(x.Binary(listProduct));
				break;
			}
			//thêm file vào Stack
			case 9: {
				System.out.println("-----------------------------------------------------------------");
				System.out.printf("|%-15s|%-15s|%-15s|%-15s|%n","Title","BarCode","Quantity","Price");
				System.out.println("-----------------------------------------------------------------");
				x.addStack(listStack, "data");
				System.out.println("-----------------------------------------------------------------");
				break;
			}
			//thêm file vào Queue
			case 10: {
				System.out.println("-----------------------------------------------------------------");
				System.out.printf("|%-15s|%-15s|%-15s|%-15s|%n","Title","BarCode","Quantity","Price");
				System.out.println("-----------------------------------------------------------------");
				x.addQueue(listQueue, "data");
				System.out.println("-----------------------------------------------------------------");
				break;
			}
			
			default:

				System.out.println("Please choose other key !");
			}
		} while (key != 0);
	}
}
