package bill;

import java.util.ArrayList;
import java.util.Scanner;
import product.ListOfProduct;
import product.Product;

public class Payment {
	private int idOfProduct;
	private int quantityOfProduct;
	private int totalMoney;

	public Payment() {
		this.idOfProduct = 0;
		this.quantityOfProduct = 0;
	}

	public Payment(int idOfProduct, int quantityOfProduct, int totalMoney) {
		super();
		this.idOfProduct = idOfProduct;
		this.quantityOfProduct = quantityOfProduct;
		this.totalMoney = totalMoney;
	}

	public int getIdOfProduct() {
		return idOfProduct;
	}

	public void setIdOfProduct(int idOfProduct) {
		this.idOfProduct = idOfProduct;
	}

	public int getQuantityOfProduct() {
		return quantityOfProduct;
	}

	public void setQuantityOfProduct(int quantityOfProduct) {
		this.quantityOfProduct = quantityOfProduct;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public void inputPayment() {
		Scanner sc = new Scanner(System.in);
		ListOfProduct listOfProduct = new ListOfProduct();
		listOfProduct.readProductFromFile();
		listOfProduct.outputListOfProduct();
		do {
			System.out.print("Enter id of product: ");
			idOfProduct = Integer.parseInt(sc.nextLine());
			if (!checkID(listOfProduct)) {
				System.out.println("No id or product matches your selection, please try again");
			}
		} while (!checkID(listOfProduct));

		do {
			System.out.print("Enter the quantity: ");
			quantityOfProduct = Integer.parseInt(sc.nextLine());
			if (!checkQuantity(listOfProduct)) {
				System.out.println("Sorry, the remaining quantity of products is not enough !");
			}
		} while (!checkQuantity(listOfProduct));
		totalMoney = totalMoney(listOfProduct);
		decreaseNumberOfRemains(listOfProduct);
		listOfProduct.writeProductToFile();
	}

	public void outputPayment() {
		System.out.println("ID of product: " + idOfProduct);
		System.out.println("Quantity of product: " + quantityOfProduct);
	}

	private boolean checkID(ListOfProduct list) {
		ArrayList<Product> listOfProduct = list.getListOfProduct();
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (idOfProduct == listOfProduct.get(i).getProductID()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkQuantity(ListOfProduct list) {
		ArrayList<Product> listOfProduct = list.getListOfProduct();
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (idOfProduct == listOfProduct.get(i).getProductID()) {
				if (quantityOfProduct > listOfProduct.get(i).getRemainingProducts()) {
					return false;
				}
			}
		}
		return true;
	}

	private void changeID(ArrayList<Product> listOfProduct, int index) {
		for (int i = listOfProduct.size() - 1; i >= index; i--) {
			listOfProduct.get(i).setProductID(listOfProduct.get(i).getProductID() - 1);
		}
	}

	private void decreaseNumberOfRemains(ListOfProduct list) {
		ArrayList<Product> listOfProduct = list.getListOfProduct();
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (idOfProduct == listOfProduct.get(i).getProductID()) {
				int value = listOfProduct.get(i).getRemainingProducts();
				if (value != 0) {
					int numberOfRemains = value - quantityOfProduct;
					listOfProduct.get(i).setRemainingProducts(numberOfRemains);
				}
			}
			if (listOfProduct.get(i).getRemainingProducts() == 0) {
				listOfProduct.remove(i);
				changeID(listOfProduct, i);
			}
		}
	}

	private int totalMoney(ListOfProduct list) {
		int sum = 0;
		ArrayList<Product> listOfProduct = list.getListOfProduct();
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (idOfProduct == listOfProduct.get(i).getProductID()) {
				sum += quantityOfProduct * listOfProduct.get(i).getProductPrice();
			}
		}
		return sum;
	}
}
