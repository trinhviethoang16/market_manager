package admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListOfAccount {
	private ArrayList<Account> listOfAccount;

	public ListOfAccount() {
		listOfAccount = new ArrayList<Account>();
	}

	public ArrayList<Account> getListOfAccount() {
		return listOfAccount;
	}

	public void setListOfAccount(ArrayList<Account> listOfAccount) {
		this.listOfAccount = listOfAccount;
	}

	public void addAccountToList(Account a) {
		listOfAccount.add(a);
	}
	
	public void readAccountFromFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\ProjectSupermarketManager\\src\\files\\AccountList.txt";
		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String data[] = line.split("\\t+");
				Account account = new Account();
				account.setAdminAccount(data[0]);
				account.setAdminPassword(data[1]);
				listOfAccount.add(account);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void writeAccountToFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\ProjectSupermarketManager\\src\\files\\AccountList.txt";
		try {
			File f = new File(path);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Account account : listOfAccount) {
				bw.write(account.getAdminAccount() + "\t");
				bw.write(account.getAdminPassword() + "\t");
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}