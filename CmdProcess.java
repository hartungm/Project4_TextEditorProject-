public class CmdProcess {
	private LineList tedList;

	public CmdProcess() {
		tedList = new LineList();
	}

	public void insertBefore(String newLine) {
		process.insertBefore(newLine);
	}

	public void insertAfter(String newLine) {
		process.insertAfter(newLine);
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
		process.toString();
	}

	public void clearFile() {
		tedList = new LineList();
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