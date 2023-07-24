package menu;

import java.util.Scanner;

import bill.ListOfBill;
import design.Design;
import product.ListOfProduct;
import product.ListOfType;

public class ShowMenu extends AddMenu {

	public ShowMenu() {
		super();
	}

	public ShowMenu(String title) {
		super(title);
	}

	public void showBill() {
		ListOfBill list = new ListOfBill();
		list.readBillFromFile();
		list.outputListOfBill();
	}

	public void showProduct() {
		ListOfProduct list = new ListOfProduct();
		list.readProductFromFile();
		list.outputListOfProduct();
	}

	public void showType() {
		ListOfType list = new ListOfType();
		list.readTypeFromFile();
		list.outputListOfType();
	}

	@Override
	public void designMenu() {
		System.out.printf("%-20s", "");
		Design.design(71);
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "1. Add bill", "", "2. Add product");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "3. Add type of product", "", "4. Show bill list");
		System.out.printf("%-20s|%10s%-25s|%10s%-25s|\n", "", "", "5. Show product list", "", "6. Show type list");
		System.out.printf("%-20s", "");
		Design.design(71);
		System.out.printf("%-20s|%33s%-38s|\n", "", "", "0. End");
		System.out.printf("%-20s", "");
		Design.design(71);
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
				} else if (n == 4) {
					showBill();
				} else if (n == 5) {
					showProduct();
				} else if (n == 6) {
					showType();
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
