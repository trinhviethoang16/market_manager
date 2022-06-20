package product;

import java.util.ArrayList;
import java.util.Scanner;

import design.Design;

public class Type implements Comparable<Type> {
	private int typeID;
	private String typeName;
	public static final int constant = 23;

	public Type() {
		this.typeID = 0;
		this.typeName = "";
	}

	public Type(int typeID, String typeName) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void inputType() {
		Scanner sc = new Scanner(System.in);
		ListOfType listOfType = new ListOfType();
		listOfType.readTypeFromFile();
		System.out.println("\t\tTYPE LIST");
		listOfType.outputListOfType();
		do {
			System.out.print("Enter type id: ");
			typeID = Integer.parseInt(sc.nextLine());
			if (!checkID(listOfType) || typeID<=0) {
				System.out.println("Type an ID greater than 0 and different from the ID in the list.");
				System.out.println("Please try again...");
			}
		} while (!checkID(listOfType) || typeID<=0);
		do {
			System.out.print("Enter type name: ");
			typeName = sc.nextLine();
			if(typeName.equals("")) {
				System.out.println("Please enter a new type name");
			}
		}while(typeName.equals(""));
		
	}

	private boolean checkID(ListOfType list) {
		ArrayList<Type> listOfType = list.getListOfType();
		for (int i = 0; i < listOfType.size(); i++) {
			if (typeID == listOfType.get(i).getTypeID()) {
				return false;
			}
		}
		return true;
	}

	public void outputType() {
		System.out.printf("| %-5d| %-15s|\n", typeID, typeName);
	}

	public static void showType() {
		Design.design(Type.constant);
		System.out.printf("| %-5s| %-15s|\n", "ID", "Name");
		Design.design(Type.constant);
	}

	@Override
	public int compareTo(Type type) {
		if(typeID > type.getTypeID()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
