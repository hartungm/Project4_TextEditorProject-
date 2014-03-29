public class CmdProcess {
	private LineList tedList;
	private int currentLine;

	public CmdProcess() {
		tedList = new LineList();
	}

	public void insertBefore(String newLine, int currentIndex) {

	}

	public void insertAfter(String newLine, int currentIndex) {

	}

	public void downOnePos(int currentIndex) {
		tedList.down();
	}

	public void upOnePos(int currentIndex) {
		tedList.up();
	}

	public void removeCurrentLine(int currentIndex) {
		tedList.remove();
	}

	public void displayFile() {

	}

	public void clearFile() {

	}

	public void saveFile(String fileName) {

	}

	public void loadFile(String fileName) {

	}

	public void showHelp() {

	}

	public void exitEditor() {

	}

	public void cutSelection() {

	}

	public void pasteClipboard() {

	}
}