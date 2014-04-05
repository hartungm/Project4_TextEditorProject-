public class LineList {
	private Line head, current;

	public LineList() {
		head = null;
		current = null;
	}

	public void insertBefore(String newLine) {
		Line addLine = new Line(newLine);
		if (current == null) {
			current = head = addLine;
		}
		else if (current.getPrev() != null) {
			addLine.setNext(current);
			addLine.setPrev(current.getPrev());
			current.getPrev().setNext(addLine);
			current.setPrev(addLine);
			current = addLine;
		}
		else {
			addLine.setNext(head);
			head.setPrev(addLine);
			current = head = addLine;
		}
		
	}

	public void insertAfter(String newLine) {
		Line addLine = new Line(newLine);
		if (current == null) {
			current = head = addLine;
		}
		else if (current.getNext() != null) {
			addLine.setNext(current.getNext());
			addLine.setPrev(current);
			current.getNext().setPrev(addLine);
			current.setNext(addLine);
			current = addLine;
		}
		else {
			addLine.setPrev(current);
			current.setNext(addLine);
			current = addLine;
		}
	}

	public void down() {
		if(current.getNext() != null) {
			current = current.getNext();
		}
		else {
			System.out.println("Bottom Line Reached!");
		}
	}

	public void up() {
		if(current.getPrev() != null) {
			current = current.getPrev();
		}
		else {
			System.out.println("Top Line Reached!");
		}
	}

	public void remove() {
		if(current.getNext() != null) {
			if(current.getPrev() != null) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				current = current.getNext();
			}
			else {
				current.getNext().setPrev(null);
				head = current.getNext();
				current = current.getNext();	
			}
		}
		else if(current.getPrev() != null) {
			current.getPrev().setNext(null);
			current = current.getPrev();
		}
		else {
			System.out.println("Nothing to remove!");
		}
	}
	
	public void setCurrent (Line l) {
		current = l;
	}
	
	public Line getCurrent () {
		return current;
	}
	
	public Line getHead () {
		return head;
	}

	public String toString() {
		String result = "";
		Line pass = head;
		int lineNumber = 1;
		while(pass != null) {
			if(pass == current) {
				result += "--> ";
			}
			result += lineNumber + ": ";
			result += pass.toString();
			pass = pass.getNext();
			lineNumber++;
		}
		return result;
	}
}
