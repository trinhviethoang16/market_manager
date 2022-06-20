package bill;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import design.Design;

public class Bill implements Comparable<Bill> {
	private String customerName;
	private String dateOfPayment;
	private int paymentAmount;
	public static final int constant = 72;

	public Bill() {
		this.customerName = "";
		this.dateOfPayment = "";
		this.paymentAmount = 0;
	}

	public Bill(String customerName, String dateOfPayment, int paymentAmount) {
		this.customerName = customerName;
		this.dateOfPayment = dateOfPayment;
		this.paymentAmount = paymentAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int paymentAmount(ListOfPayment list) {
		int temp = 0;
		ArrayList<Payment> listOfPayment = list.getListOfPayment();
		for (int i = 0; i < listOfPayment.size(); i++) {
			temp += listOfPayment.get(i).getTotalMoney();
		}
		return temp;
	}

	public void inputBill() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Enter customer name: ");
			customerName = sc.nextLine();
			if (customerName.equals("")) {
				System.out.println("Please enter the name !");
			}
		} while (customerName.equals(""));
		ListOfPayment listOfPayment = new ListOfPayment();
		listOfPayment.inputListOfPayment();
		paymentAmount = paymentAmount(listOfPayment);
		Date today = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		dateOfPayment = df.format(today);
	}

	public void outputBill() {
		System.out.printf("|%-30s|%-20s|%20d|\n", customerName, dateOfPayment, paymentAmount);
	}

	public static void showBill() {
		Design.design(Bill.constant);
		System.out.printf("|%-30s|%-20s|%20s|\n", "Customer name", "Date", "Payment amount");
		Design.design(Bill.constant);
	}

	@Override
	public int compareTo(Bill bill) {
		if (paymentAmount < bill.getPaymentAmount()) {
			return 1;
		} else if (paymentAmount == bill.getPaymentAmount()) {
			return customerName.compareTo(bill.getCustomerName());
		} else {
			return -1;
		}
	}
}
