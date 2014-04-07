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

	public void insertLast(String newLine) {
		while(current.getNext() != null) {
			down();
		}
		insertAfter(newLine);
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
		if (current == null) {
			System.out.println("Nothing to remove!");
		}
		else if(current.getNext() != null) {
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
			head = current = null;
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
	
	public String display (int x, int y) {
		String result = "";
		Line pass = head;
		int lineNumber = 1;
		boolean done = false;
		while (pass != null && !done) {
			if (lineNumber == x) {
				while (pass != null && !done) {
					if (pass == current) {
						result += "--> ";
					}
					else {
						result += "    ";
					}
					result += lineNumber + ": ";
					result += pass.toString();
					pass = pass.getNext();
					lineNumber++;
					if (lineNumber == y+1) {
						done = true;
					}
				}
			}
			lineNumber++;
			try {
				pass = pass.getNext();
			} catch (NullPointerException e) {
				done = true;
			}
		}
		return result;
	}

	public String toString() {
		String result = "";
		Line pass = head;
		int lineNumber = 1;
		while(pass != null) {
			if(pass == current) {
				result += "--> ";
			}
			else {
				result += "    ";
			}
			result += lineNumber + ": ";
			result += pass.toString();
			pass = pass.getNext();
			lineNumber++;
		}
		return result;
	}
}
