public class Editor implements IEditor {
	private CmdProcess process;
	private LineList tedList;

	public Editor() {
		process = new CmdProcess();
		tedList = new LineList();
	}

	public void process command(String command) {
		String[] token = command.split(" ");
		switch (token[0].trim().toLowerCase()) {
			
			case "b":	process.insertBefore(command.subString(2), getCurrentLine());
						break;
			case "i":	process.insertAfter(command.subString(2), getCurrentLine());
						break;
			case "m":	process.downOnePos(getCurrentLine());
						break;
			case "u":	process.upOnePos(getCurrentLine());
						break;
			case "r":	process.removeCurrentLine(getCurrentLine());
						break;
			case "d":	process.displayFile();
						break;
			case "c":	process.clearFile();
						break;
			case "s":	process.saveFile(token[1].trim());
						break;
			case "l":	process.loadFile(token[1].trim());
						break;
			case "h":	process.showHelp();
						break;
			case "x":	process.exitEditor();
						break;
			case "cut": process.cutSelection();
						break;
			case "pas": process.pasteClipboard();
						break;
		}
	}

	public String getLine(int lineNbr) {

	}

	public String getCurrentLine() {

	}
}