package bill;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import design.Design;

public class ListOfBill {
	private ArrayList<Bill> listOfBill;

	public ListOfBill() {
		listOfBill = new ArrayList<Bill>();
	}

	public ArrayList<Bill> getListOfBill() {
		return listOfBill;
	}

	public void setListOfBill(ArrayList<Bill> listOfBill) {
		this.listOfBill = listOfBill;
	}

	public void addBillToList(Bill b) {
		listOfBill.add(b);
	}

	public void outputListOfBill() {
		Collections.sort(listOfBill);
		Bill.showBill();
		for (int i = 0; i < listOfBill.size(); i++) {
			listOfBill.get(i).outputBill();
		}
		Design.design(Bill.constant);
	}

	public void readBillFromFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\market_manager\\src\\files\\BillList.txt";
		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line=br.readLine()) != null) {
				String data[] = line.split("\\t+");
				Bill bill = new Bill();
				bill.setCustomerName(data[0]);
				bill.setDateOfPayment(data[1]);
				bill.setPaymentAmount(Integer.parseInt(data[2]));
				listOfBill.add(bill);
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void writeBillToFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\market_manager\\src\\files\\BillList.txt";
		try {
			File f = new File(path);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Bill bill : listOfBill) {
				bw.write(bill.getCustomerName() + "\t");
				bw.write(bill.getDateOfPayment() + "\t");
				bw.write(bill.getPaymentAmount() + "\t");
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Bill findCustomerName(String name) {
		for(Bill bill : listOfBill) {
			if(bill.getCustomerName().equals(name)) {
				System.out.println("The system has a bill that matches the name you just entered");
				Design.design(Bill.constant);
				bill.outputBill();
				return bill;
			}
		}
		System.out.println("Oops, the customer name you just entered is not available !");
		return null;
	}
	
	public boolean deleteBillByName(String name) {
		for(int i=0; i<listOfBill.size(); i++) {
			if(listOfBill.get(i).getCustomerName().equals(name)) {
				listOfBill.remove(i);
				return true;
			}
		}
		return false;
	}
}
