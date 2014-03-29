public class Line {
	private String content;
	private Line next;
	private Line prev;

	public Line() {
		content = "\n";
	}

	public Line(String newLine) {
		content = newLine + "\n";
	}

	public void setNext(Line l) {
		next = l;
	}

	public Line getNext() {
		return next;
	}

	public void setPrev(Line l) {
		prev = l;
	}

	public Line getPrev() {
		return prev;
	}

	public String toString() {
		return content;
	}
}