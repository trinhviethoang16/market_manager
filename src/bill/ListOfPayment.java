package bill;

import java.util.ArrayList;
import java.util.Scanner;

public class ListOfPayment {
	private ArrayList<Payment> listOfPayment;
	
	public ListOfPayment() {
		listOfPayment = new ArrayList<Payment>();
	}

	public ArrayList<Payment> getListOfPayment() {
		return listOfPayment;
	}

	public void setListOfPayment(ArrayList<Payment> listOfPayment) {
		this.listOfPayment = listOfPayment;
	}
	
	public void addPaymentToList(Payment p) {
		listOfPayment.add(p);
	}
	
	public void inputListOfPayment() {
		Scanner sc = new Scanner(System.in);
		String confirm;
		do {
			Payment payment = new Payment();
			payment.inputPayment();
			listOfPayment.add(payment);
			System.out.println("\nIf you want to continue entering the payment information, type anything...");
			System.out.println("If not, please type \"stop\".");
			confirm = sc.nextLine();
		} while(!confirm.equals("stop"));
		for(int i=0; i<listOfPayment.size(); i++) {
			System.out.println("Total money of payment: " + listOfPayment.get(i).getTotalMoney());
		}
	}
}
