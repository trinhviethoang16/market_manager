package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import design.Design;

public class ListOfProduct {
	private ArrayList<Product> listOfProduct;
	
	public ListOfProduct() {
		listOfProduct = new ArrayList<Product>();
	}

	public ArrayList<Product> getListOfProduct() {
		return listOfProduct;
	}

	public void setListOfProduct(ArrayList<Product> listOfProduct) {
		this.listOfProduct = listOfProduct;
	}
	
	public void addProductToList(Product p)
	{
		listOfProduct.add(p);
	}
	
	public void readProductFromFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\market_manager\\src\\files\\ProductList.txt";
		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String data[] = line.split("\\t+");
				Product product = new Product();
				product.setProductID(Integer.parseInt(data[0]));
				product.setProductName(data[1]);
				product.setProductPrice(Integer.parseInt(data[2]));
				product.setRemainingProducts(Integer.parseInt(data[3]));
				product.setIdOfType(Integer.parseInt(data[4]));
				listOfProduct.add(product);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void writeProductToFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\market_manager\\src\\files\\ProductList.txt";
		try {
			File f = new File(path);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Product product : listOfProduct) {
				bw.write(product.getProductID() + "\t");
				bw.write(product.getProductName() + "\t");
				bw.write(product.getProductPrice() + "\t");
				bw.write(product.getRemainingProducts() + "\t");
				bw.write(product.getIdOfType() + "\t");
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Product findByProductID(int id) {
		for(Product product : listOfProduct) {
			if(product.getProductID()==id) {
				return product;
			}
		}
		return null;
	}
	
	public void updateProductQuantity(Product p, int id) {
		for(Product product : listOfProduct) {
			if(product.getProductID()==p.getProductID()) {
				product.setRemainingProducts(id);
			}
		}
	}
	
	public void outputListOfProduct() {
		Collections.sort(listOfProduct);
		Product.showProduct();
		for(int i=0; i<listOfProduct.size(); i++)
		{
			listOfProduct.get(i).outputProduct();
		}
		Design.design(Product.constant);
	}
}
