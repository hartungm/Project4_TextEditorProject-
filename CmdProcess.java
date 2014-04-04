import java.io.*;
import java.util.Scanner;

public class CmdProcess {
	private LineList tedList;

	public CmdProcess() {
		tedList = new LineList();
	}
	
	public LineList getList () {
		return tedList;
	}

	public void insertBefore(String newLine) {
		tedList.insertBefore(newLine);
	}

	public void insertAfter(String newLine) {
		tedList.insertAfter(newLine);
	}

	public void downOnePos() {
		tedList.down();
	}

	public void upOnePos() {
		tedList.up();
	}

	public void removeCurrentLine() {
		tedList.remove();
	}

	public void displayFile() {
		System.out.println(tedList.toString());
		// Double check this to match intent
	}

	public void clearFile() {
		tedList = new LineList();
	}

	public void saveFile(String fileName) {
		PrintWriter p = null;
		try {
			p=new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} catch (IOException e) {
			System.out.println("Error while writing file!");
		}
		p.println(tedList.toString());
		p.close();
	}

	public void loadFile(String fileName) {
		try {
			Scanner fileReader = new Scanner (new File(fileName));
			clearFile();
			tedList.insertAfter(fileReader.next());
			tedList.down();
			while (fileReader.hasNext()) {
				tedList.insertAfter(fileReader.next());
				tedList.down();
			}
			//needs to be checked
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	public void showHelp() {

	}

	public void exitEditor() {
		System.exit(1);
	}

	public void cutSelection() {

	}

	public void pasteClipboard() {

	}
}