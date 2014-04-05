public class Editor implements IEditor {
	private CmdProcess process;
	private boolean active = true;		//End the program by setting this boolean to false, use while loop to keep program running in a main method

	public Editor() {
		process = new CmdProcess();
	}

	public void processCommand(String command) {
		String[] token = command.split(" ");
		switch (token[0].trim().toLowerCase()) {
			
			case "b":	process.insertBefore(command.substring(2));
						break;
			
			case "i":	process.insertAfter(command.substring(2));
						break;
			
			case "m":	if (token.length == 2) {
							process.down(Integer.parseInt(token[1].trim()));
						} 
						else {
							process.downOnePos();
						}
						break;
			
			case "u":	if (token.length == 2) {
							process.up(Integer.parseInt(token[1].trim()));
						} 
						else {
							process.upOnePos();
						}
						break;
			
			case "r":	process.removeCurrentLine();
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
			
			case "x":	active = false;
						break;
			
			case "cut": process.cutSelection();
						break;
			
			case "pas": process.pasteClipboard();
						break;
			
			default:	System.out.println("Invalid Command!");
						break;
		}
	}

	public String getLine(int lineNbr) {
		Line l = process.getList().getHead();
		for (int i=1; i<=lineNbr; i++)
			l = l.getNext();
		return l.toString();
	}

	public String getCurrentLine() {
		return process.getList().getCurrent().toString();
	}

	public boolean getActive() {
		return active;
	}
}