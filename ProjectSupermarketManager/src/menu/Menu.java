package menu;

import java.util.Scanner;
import admin.Account;
import admin.ListOfAccount;
import design.Design;

public class Menu implements InterfaceMenu {
	protected String title;
	public static final int constant = 16;

	public Menu() {
		super();
	}

	public Menu(String title) {
		this.title = title;
	}

	@Override
	public void addBill() {

	}

	@Override
	public void addProduct() {

	}

	@Override
	public void addType() {

	}

	@Override
	public void showBillList() {
	}

	@Override
	public void showProductList() {
	}

	@Override
	public void showTypeList() {
	}

	@Override
	public void main() {
		System.out.println("\t\t" + this.title);
		login();
	}

	@Override
	public void login() {
		ListOfAccount list = new ListOfAccount();
		list.readAccountFromFile();
		Account account = new Account();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Enter admin account: ");
			account.setAdminAccount(sc.nextLine());
			System.out.print("Enter admin password: ");
			account.setAdminPassword(sc.nextLine());
			System.out.println();
			if (!account.checkAccountLogin(list)) {
				System.out.println("Wrong account, please try again\n");
				System.out.println("To create new account, please type \"yes\"");
				System.out.println("To retype account, please type anything....");
				String confirm;
				confirm = sc.nextLine();
				if (confirm.equals("yes")) {
					register();
				}
			}
		} while (!account.checkAccountLogin(list));
		System.out.println("\tLogin successful\n");
		System.out.println("\tWelcome " + account.getAdminAccount() + " to page\n");
		Design.design(Menu.constant);
		System.out.printf("| %-15s|\n", "Account");
		System.out.printf("| %-15s|\n", "");
		System.out.printf("| %-15s|\n", account.getAdminAccount());
		Design.design(Menu.constant);
	}

	@Override
	public void register() {
		ListOfAccount list = new ListOfAccount();
		list.readAccountFromFile();
		Account account = new Account();
		account.createAccount();
		list.addAccountToList(account);
		list.writeAccountToFile();
		System.out.println("\tCreate successful !");
	}
}
