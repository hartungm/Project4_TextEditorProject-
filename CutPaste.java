public class CutPaste {
	private LineList head, current;

	public CutPaste() {
		head = null;
		current = null;
	}

	public void insertBefore(LineList newList) {
		if(head == null) {
			head = newList;
			current = newList;
		}
		else if(current.getPrev() == null) {
			head = newList;
			current.setPrev(newList);
			newList.setNext(current);
			current = newList;
		}
		else {
			current.getPrev().setNext(newList);
			newList.setPrev(current.getPrev());
			current.setPrev(newList);
			newList.setNext(current);
			current = newList;
		}
	}

	public void insertAfter(LineList newList) {
		if(head == null) {
			head = newList;
			current = newList;
		}
		else if(current.getNext() == null) {
			current.setNext(newList);
			newList.setPrev(current);
			current = newList;
		}
		else {
			current.getNext().setPrev(newList);
			newList.setNext(current.getNext());
			current.setNext(newList);
			newList.setPrev(current);
			current = newList;
		}
	}
}