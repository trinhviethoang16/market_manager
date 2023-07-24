package product;

import java.util.ArrayList;
import java.util.Scanner;

import design.Design;

public class Product implements Comparable<Product> {
	private int productID;
	private String productName;
	private int productPrice;
	private int remainingProducts;
	private int idOfType;
	public static final int constant = 68;

	public Product() {
		this.productID = 0;
		this.productName = "";
		this.productPrice = 0;
		this.remainingProducts = 0;
		this.idOfType = 0;
	}

	public Product(int productID, String productName, int productPrice, int remainingProducts, int idOfType) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.remainingProducts = remainingProducts;
		this.idOfType = idOfType;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getRemainingProducts() {
		return remainingProducts;
	}

	public void setRemainingProducts(int remainingProducts) {
		this.remainingProducts = remainingProducts;
	}

	public int getIdOfType() {
		return idOfType;
	}

	public void setIdOfType(int idOfType) {
		this.idOfType = idOfType;
	}

	public void inputProduct() {
		Scanner sc = new Scanner(System.in);
		ListOfProduct listOfProduct = new ListOfProduct();
		listOfProduct.readProductFromFile();
		System.out.println("\t\t\tPRODUCT LIST");
		listOfProduct.outputListOfProduct();
		do {
			System.out.print("Enter product id to add: ");
			productID = Integer.parseInt(sc.nextLine());
			if (checkID(listOfProduct) || productID <= 0) {
				System.out.println("Product ID can't be lower than 0 and must different ID from the list.");
				System.out.println("Please try again...");
			}
		} while (checkID(listOfProduct) || productID <= 0);
		System.out.print("Enter product name to add: ");
		productName = sc.nextLine();
		do {
			System.out.print("Enter product price to add: ");
			productPrice = Integer.parseInt(sc.nextLine());
			if (productPrice < 0) {
				System.out.println("The price can't be lower than 0, please try again...");
			}
		} while (productPrice < 0);
		do {
			System.out.print("Enter the remaining product in warehouse: ");
			remainingProducts = Integer.parseInt(sc.nextLine());
			System.out.println();
			if (remainingProducts <= 0) {
				System.out.println("The reamining product can't be lower than 0, please try again...");
			}
		} while (remainingProducts <= 0);
		System.out.println("\tTYPE LIST");
		ListOfType listOfType = new ListOfType();
		listOfType.readTypeFromFile();
		listOfType.outputListOfType();
		do {
			System.out.print("Enter type id of product to add: ");
			idOfType = Integer.parseInt(sc.nextLine());
			if (!checkIDOfType(listOfType)) {
				System.out.println("No type id of product matches your selection, please try again");
			}
		} while (!checkIDOfType(listOfType));
	}

	private boolean checkID(ListOfProduct list) {
		ArrayList<Product> listOfProduct = list.getListOfProduct();
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (productID == listOfProduct.get(i).getProductID()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIDOfType(ListOfType list) {
		ArrayList<Type> listOfType = list.getListOfType();
		for (int i = 0; i < listOfType.size(); i++) {
			if (idOfType == listOfType.get(i).getTypeID()) {
				return true;
			}
		}
		return false;
	}

	public void outputProduct() {
		System.out.printf("|%-10d|%-20s|%15d|%20d|\n", productID, productName, productPrice, remainingProducts);
	}

	public static void showProduct() {
		Design.design(Product.constant);
		System.out.printf("|%-10s|%-20s|%15s|%20s|\n", "ID", "Product name", "Price", "Remaining");
		Design.design(Product.constant);
	}

	@Override
	public int compareTo(Product product) {
		if(productID > product.getProductID()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
