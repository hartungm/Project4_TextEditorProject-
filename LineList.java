public class LineList {
	private Line head, current;

	public LineList() {}



	public void down() {
		current = current.getNext();
	}

	public void up() {
		current = current.getPrev();
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
		else if(current.getPrev != null) {
			current.getPrev().setNext(null);
			current = current.getPrev();
		}
		else {
			System.out.println("Nothing to remove!");
		}
	}
}