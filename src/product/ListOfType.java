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

public class ListOfType {
	private ArrayList<Type> listOfType;

	public ListOfType() {
		listOfType = new ArrayList<Type>();
	}

	public ArrayList<Type> getListOfType() {
		return listOfType;
	}

	public void setListOfType(ArrayList<Type> listOfType) {
		this.listOfType = listOfType;
	}

	public void addTypeToList(Type type) {
		listOfType.add(type);
	}

	public void outputListOfType() {
		Collections.sort(listOfType);
		Type.showType();
		for (int i = 0; i < listOfType.size(); i++) {
			listOfType.get(i).outputType();
		}
		Design.design(Type.constant);
	}

	public void readTypeFromFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\market_manager\\src\\files\\TypeList.txt";
		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String data[] = line.split("\\t+");
				Type type = new Type();
				type.setTypeID(Integer.parseInt(data[0]));
				type.setTypeName(data[1]);
				listOfType.add(type);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void writeTypeToFile() {
		String path = "C:\\Users\\Viet Hoang\\eclipse-workspace\\market_manager\\src\\files\\TypeList.txt";
		try {
			File f = new File(path);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Type type : listOfType) {
				bw.write(type.getTypeID() + "\t");
				bw.write(type.getTypeName() + "\t");
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
