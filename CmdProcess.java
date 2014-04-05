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

	public void down(int numDown) {
		while(numDown > 0) {
			downOnePos();
			numDown--;
		}
	}

	public void downOnePos() {
		tedList.down();
	}

	public void up(int numUp) {
		while(numUp > 0) {
			upOnePos();
			numUp--;
		}
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
			Line tmp = tedList.getHead();
			while (tmp!=null){
				p.println(tmp);
				tmp=tmp.getNext();
			}
			p.close();
		} catch (IOException e) {
			System.out.println("Error while writing file!");
		}
	}

	public void loadFile(String fileName) {
		try {
			Scanner sc = new Scanner (new File(fileName));
			clearFile();
			while (sc.hasNextLine()) {
				tedList.insertAfter(sc.nextLine());
			}
			tedList.setCurrent(tedList.getHead());
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	public void showHelp() {
		//non-implemented functionality included, commented out
		String out = "";
		out += ("Welcome to Text Editor Help!\n");
		out += ("Command:   Function:\n");
		out += ("b 'sentence' Insert sentence before current");
		out += (" line, make inserted line current\n");
		out += ("i 'sentence' Insert sentence after current");
		out += (" line, make inserted line current\n");
		out += ("m            Move cursor down 1 position\n");
	  //out += ("m #          Move cursor down # positions\n");
		out += ("u            Move cursor up 1 position\n");
	  //out += ("u #		  Move cursor down # positions\n");
		out += ("r            Remove current line. Next line becomes ");
		out += ("current, unless\n 	     no next line, then previous becomes ");
		out += ("current\n");
	  //out += ("r #          Remove # lines, starting at current\n")
		out += ("d            Display all lines with line numbers\n");
	  //out += ("d # *        Display lines # to * with line numbers\n");
		out += ("c            Clear all lines in the file\n");
		out += ("s 'filename' Save contents to specified text file\n");
		out += ("l 'filename' Load contents of file into current buffer\n");
		out += ("h            Display this help page\n");
		out += ("x            Exit the editor");
		//extra functionality: only if saved to l, c, x
		System.out.println(out);
	}

	public void cutSelection() {

	}

	public void pasteClipboard() {

	}
}