import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class OperationToProduct {
	Scanner sc = new Scanner(System.in);
	MyList<Product> list = new MyList<Product>();
	MyStack<Product> stack = new MyStack<Product>();
	MyQueue<Product> queue = new MyQueue<Product>();

	
	
	

	/// Tạo một đối tượng product mới
	public Product createProduct() {
		System.out.print("Input title : ");
		String newTitle = sc.next();
		System.out.print("Input BarCor : ");
		int newBar = sc.nextInt();
		System.out.print("Input quantity : ");
		int newQuatity = sc.nextInt();
		System.out.print("Input price : ");
		double newPrice = sc.nextDouble();
		

		Product newProduct = new Product(newTitle, newBar, newQuatity, newPrice);

		return newProduct;
	}

	// viết tất cả item trong list vào file
	public void writeAllItemsToFile(String fileName, MyList<Product> list) {
		try (PrintWriter pw = new PrintWriter(new File("D:/" + fileName + ".txt"))) {
			// Mỗi Product sẽ viết 1 dòng trong file
				pw.print(list);
		} catch (Exception e) {
			
		}

	}
	// In kết quả vào file test2
	public void writeConseLogToFile(MyList<Product> list2) {

		try (// Mỗi Product sẽ viết 1 dòng trong file
				FileWriter pw = new FileWriter("D:/console_output.txt", true)) {
			pw.append(list2 + "\n");

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeToFile(String z) {

		try (// Mỗi Product sẽ viết 1 dòng trong file
				FileWriter pw = new FileWriter("D:/console_output.txt", true)) {
			pw.append(z + "\n");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//Lưu tất cả vào file
	public void getAllItemsFromFile(String fileName, MyList<Product> list) {
		try (Scanner sx = new Scanner(new File("D:/" + fileName + ".txt"))) {
			// lấy mỗi dòng trong file

			while (sx.hasNextLine()) {
				String item = sx.nextLine();
				// lấy các phần tử cách nhau bằng dấu phẩy để tạo 1 product mới
				String[] temp = item.split(",");
				String title = temp[0];
				int barcode = Integer.parseInt(temp[1]);
				int quality = Integer.parseInt(temp[2]);
				double price = Double.parseDouble(temp[3]);
				// thêm vào đầu mỗi list
				list.insertToTail(new Product(title, barcode, quality, price));

				// Mỗi Product sẽ viết 1 dòng trong file

			}

			list.toStringxx();
			sx.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writeToFile("Danh sách sản phẩm : ");
		writeConseLogToFile(list);

	}

	// thêm 1 Product ở cuối danh sách
	public void addLast(MyList<Product> list) {
		list.insertToTail(createProduct());

	}

	// Hiển thị tất cả các sản phẩm trong list
	public void displayAll(MyList<Product> list) {
		list.toStringxx();
		writeToFile("Danh sách tất cả sản phẩm : ");
		writeConseLogToFile(list);
	}
	// Tìm kiếm sản phẩm theo id
	public void searchByCode(MyList<Product> list) {
		System.out.print("Input Id : ");
		int id = sc.nextInt();
		// Nếu không tìm thấy id thì in ra -1
		if (list.findId(id) == null) {
			System.out.println(-1);
		} else {
			System.out.println("-----------------------------------------------------------------");
			System.out.printf("|%-15s|%-15s|%-15s|%-15s|%n", "Title", "BarCode", "Quantity", "Price");
			System.out.println("-----------------------------------------------------------------");
			list.findId(id).getInfor().toStringx();
			writeToFile("Sản phẩm tìm được: ");
			writeToFile(list.findId(id).getInfor().toString());
		}
	}

	// Xóa Product theo id
	public void deleteById(MyList<Product> list) {
		System.out.print("Input Id : ");
		int id = sc.nextInt();
		// Nếu không tìm thấy id thì in ra -1
		if (list.findId(id) == null) {
			System.out.println(-1);
		} else {
			writeToFile("Sản phẩm bị xóa : ");
			writeToFile(list.findId(id).getInfor().toString());
			list.deleteId(list.findId(id));
		}
	}

	// Chiều dài cua myList
	public void Length(MyList<Product> list) {
		System.out.println(list.lenght());

	};

	// Sắp xếp bubble sort
	public void Swap(MyList<Product> list) {
		list.sortBubble();
		writeToFile(" Sắp xếp Bubble sort");
		writeConseLogToFile(list);
	}

	public void Sw(MyList<Product> list) {
		int id1 = sc.nextInt();
		int id2 = sc.nextInt();
		list.swap(list.findId(id1), list.findId(id2));
	}
	// thêm sản phẩm vào stack
	public void addStack(MyStack<Product> stack, String fileName) {
		
		try (Scanner sx = new Scanner(new File("D:/" + fileName + ".txt"))) {
			// lấy mỗi dòng trong file

			while (sx.hasNextLine()) {
				String item = sx.nextLine();
				// lấy các phần tử cách nhau bằng dấu phẩy để tạo 1 product mới
				String[] temp = item.split(",");
				String title = temp[0];
				int barcode = Integer.parseInt(temp[1]);
				int quality = Integer.parseInt(temp[2]);
				double price = Double.parseDouble(temp[3]);
				// thêm vào đầu mỗi list
				stack.addStack(new Product(title, barcode, quality, price));
			}
			stack.toStringxx();
			sx.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Viết kết quả vào file
				try (
						FileWriter pw = new FileWriter("D:/console_output.txt", true)) {
					pw.append("\n Stack list :\n ");
					pw.append(stack.display());
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

// Tạo danh sách queue nhập vào từ file
	public void addQueue(MyQueue<Product> queue, String fileName) {
		try (Scanner sx = new Scanner(new File("D:/" + fileName + ".txt"))) {
			// lấy mỗi dòng trong file

			while (sx.hasNextLine()) {
				String item = sx.nextLine();
				// lấy các phần tử cách nhau bằng dấu phẩy để tạo 1 product mới
				String[] temp = item.split(",");
				String title = temp[0];
				int barcode = Integer.parseInt(temp[1]);
				int quality = Integer.parseInt(temp[2]);
				double price = Double.parseDouble(temp[3]);
				// thêm vào đầu mỗi list
				queue.enQueue(new Product(title, barcode, quality, price));
			}
			queue.toStringxx();
			sx.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Viết kết quả vào file
		try (
				FileWriter pw = new FileWriter("D:/console_output.txt", true)) {
			pw.append("\n Queue list :\n ");
			pw.append(queue.display());
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String Binary(MyList<Product> list)

	{
		System.out.print("Quantity " + list.getfirstNode() + " => ");
		writeToFile("Quantity " + list.getfirstNode() + " => "+ list.Binary(list.getfirstNode()));
		return list.Binary(list.getfirstNode());
	}

}
