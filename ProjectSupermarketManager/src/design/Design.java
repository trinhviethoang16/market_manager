package design;

public class Design {
	public static void design(int n) {
		System.out.printf("|");
		for (int i = 0; i < n; i++) {
			System.out.printf("-");
		}
		System.out.printf("|\n");
	}
}
