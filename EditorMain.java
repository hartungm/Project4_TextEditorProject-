import java.util.Scanner;

public class EditorMain {
	
	public static void main(String[] args) {
		String text = "";
		Editor ted = new Editor();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Ted Editor! If you need help, type the letter h.");
		while(ted.getActive()) {
			text = sc.nextLine();
			ted.processCommand(text);
		}
	}
}