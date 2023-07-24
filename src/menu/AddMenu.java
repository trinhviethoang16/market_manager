package menu;

import java.util.Scanner;
import bill.Bill;
import bill.ListOfBill;
import design.Design;
import product.ListOfProduct;
import product.ListOfType;
import product.Product;
import product.Type;

public class AddMenu extends Menu {

	public AddMenu() {
		super();
	}

	public AddMenu(String title) {
		super(title);
	}

	@Override
	public void addBill() {
		ListOfBill list = new ListOfBill();
		list.readBillFromFile();
		Bill bill = new Bill();
		bill.inputBill();
		list.addBillToList(bill);
		list.writeBillToFile();
		System.out.println("\tSuccessfully !");
		Bill.showBill();
		bill.outputBill();
		Design.design(Bill.constant);
	}

	@Override
	public void addProduct() {
		ListOfProduct list = new ListOfProduct();
		list.readProductFromFile();
		Product product = new Product();
		product.inputProduct();
		list.addProductToList(product);
		list.writeProductToFile();
		System.out.println("\tSuccessfully !");
		Product.showProduct();
		product.outputProduct();
		Design.design(Product.constant);
	}

	@Override
	public void addType() {
		ListOfType list = new ListOfType();
		list.readTypeFromFile();
		Type type = new Type();
		type.inputType();
		list.addTypeToList(type);
		list.writeTypeToFile();
		System.out.println("\tSuccessfully !");
		Type.showType();
		type.outputType();
		Design.design(Type.constant);
	}

	@Override
	public void main() {
		login();
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("\t\t" + this.title);
				designMenu();
				System.out.print("Enter your selection: ");
				int n = sc.nextInt();
				if (n == 0) {
					break;
				} else if (n == 1) {
					addBill();
				} else if (n == 2) {
					addProduct();
				} else if (n == 3) {
					addType();
				} else {
					System.out.println("No matching selection, please try again");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public void designMenu() {
		System.out.printf("%-20s", "");
		Design.design(71);
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "1. Add bill", "", "2. Add product");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "3. Add type of product", "", "0. End");
		System.out.printf("%-20s", "");
		Design.design(71);
	}
}
