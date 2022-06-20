package menu;

import java.util.ArrayList;
import java.util.Scanner;
import bill.Bill;
import bill.ListOfBill;
import design.Design;
import product.ListOfProduct;
import product.Product;

public class ExtendMenu extends ShowMenu {
	Scanner sc = new Scanner(System.in);

	public ExtendMenu() {
		super();
	}

	public ExtendMenu(String title) {
		super(title);
	}

	public void findCustomerName() {
		ListOfBill list = new ListOfBill();
		System.out.print("Enter customer name that you want to search for the bill: ");
		String name = sc.nextLine();
		list.readBillFromFile();
		list.findCustomerName(name);
		Design.design(Bill.constant);
	}

	public void deleteBill() {
		ListOfBill list = new ListOfBill();
		list.readBillFromFile();
		list.outputListOfBill();
		System.out.print("Enter customer name that you want to delete from the bill list: ");
		String name = sc.nextLine();
		if(list.deleteBillByName(name))
		{
			System.out.println("\tSuccessfully !");
		}
		else {
			System.out.println("Sorry, There are no customers matching the name you just entered");
		}
		list.writeBillToFile();
	}

	public void updateProductRemains() {
		ListOfProduct list = new ListOfProduct();
		list.readProductFromFile();
		list.outputListOfProduct();
		ArrayList<Product> listProduct = list.getListOfProduct();
		int id;
		do {
			System.out.print("Enter product ID that you want to update: ");
			id = Integer.parseInt(sc.nextLine());
			if(id<=0 || id>listProduct.size()) {
				System.out.println("ID does not match any product, please try again...");
			}
		} while(id<=0 || id>listProduct.size());
		Product product = new Product();
		product = list.findByProductID(id);
		System.out.print("Enter the number of remaining products: ");
		int remain = Integer.parseInt(sc.nextLine());
		list.updateProductQuantity(product, remain);
		list.writeProductToFile();
		System.out.println("\tSuccessfully !");
	}

	@Override
	public void designMenu() {
		System.out.printf("%-20s", "");
		Design.design(71);
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "1. Add bill", "", "2. Add product");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "3. Add type of product", "", "4. Show bill list");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "5. Show product list", "", "6. Show type list");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "7. Find customer", "", "8. Delete bill");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "9. Update product", "", "0. End");
		System.out.printf("%-20s", "");
		Design.design(71);
	}

	@Override
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t\tLOGIN PAGE\n");
		System.out.println("To create a new account, please type \"1\"");
		System.out.println("Or you already have, please type anything to login...........\n");
		String confirm = sc.nextLine();
		if (confirm.equals("1")) {
			register();
			login();
		} else {
			login();
		}
		while (true) {
			try {
				System.out.println("\t\t\t\t\t\t" + this.title);
				designMenu();
				System.out.print("Enter your selection: ");
				int n = sc.nextInt();
				if (n == 0) {
					System.out.println("\t\t\t\t\t\tHave a nice day !");
					System.out.println("\t\t\t\t\t\tEnding....");
					break;
				} else if (n == 1) {
					addBill();
				} else if (n == 2) {
					addProduct();
				} else if (n == 3) {
					addType();
				} else if (n == 4) {
					showBill();
				} else if (n == 5) {
					showProduct();
				} else if (n == 6) {
					showType();
				} else if (n == 7) {
					findCustomerName();
				} else if (n == 8) {
					deleteBill();
				} else if (n == 9) {
					updateProductRemains();
				} else {
					System.out.println("No matching selection, please try again");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
