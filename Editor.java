public class Editor implements IEditor {

	public void process command(String command) {
		String[] token = command.split(" ");
		String cmd = token[0].trim();
		switch (cmd.toLowerCase) {
			case "b":	break;
			case "i":	break;
			case "m":	break;
			case "u":	break;
			case "r":	break;
			case "d":	break;
			case "c":	break;
			case "s":	break;
			case "l":	break;
			case "h":	break;
			case "x":	break;
			case "cut": break;
			case "pas": break;
		}
	}

	public String getLine(int lineNbr) {

	}

	public String getCurrentLine() {

	}
}