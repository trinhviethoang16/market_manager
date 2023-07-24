package admin;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	private String adminAccount;
	private String adminPassword;

	public Account() {
		this.adminAccount = "";
		this.adminPassword = "";
	}

	public Account(String adminAccount, String adminPassword) {
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void createAccount() {
		ListOfAccount listOfAccount = new ListOfAccount();
		listOfAccount.readAccountFromFile();
		Scanner sc = new Scanner(System.in);
		do {
			do {
				System.out.print("Enter new account: ");
				adminAccount = sc.nextLine();
				if (adminAccount.length() > 10 || adminAccount.equals("")) {
					System.out.println("Account too long or can't be null");
					System.out.println("Please try again...");
				}
			} while (adminAccount.length() > 10 || adminAccount.equals(""));
			if (checkAccountHasExist(listOfAccount)) {
				System.out.println("Account already exists, please try again...");
			}
		} while (checkAccountHasExist(listOfAccount));
		do {
			System.out.print("Enter new password: ");
			adminPassword = sc.nextLine();
			if (adminPassword.length() > 10 || adminPassword.equals("")) {
				System.out.println("Password too long or can't be null");
				System.out.println("Please try again...");
			}
		} while (adminPassword.length() > 10 || adminPassword.equals(""));
	}

	private boolean checkAccountHasExist(ListOfAccount list) {
		ArrayList<Account> listOfAccount = list.getListOfAccount();
		for (int i = 0; i < listOfAccount.size(); i++) {
			if (adminAccount.equals(listOfAccount.get(i).getAdminAccount())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkAccountLogin(ListOfAccount list) {
		ArrayList<Account> listOfAccount = list.getListOfAccount();
		for (int i = 0; i < listOfAccount.size(); i++) {
			if (adminAccount.equals(listOfAccount.get(i).getAdminAccount())) {
				if (adminPassword.equals(listOfAccount.get(i).getAdminPassword())) {
					return true;
				}
			}
		}
		return false;
	}
}
