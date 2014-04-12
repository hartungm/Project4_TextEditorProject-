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

	public void add(LineList newBoard, int newBoardNum) {
		newBoard.setClipNum(newBoardNum);
		if(head == null) {
			insertAfter(newBoard);
		}
		else if(current.getClipNum() < newBoardNum) {
			current = current.getNext();
			add(newBoard, newBoardNum);
		}
		else if(current.getNext() == null) {
			insertAfter(newBoard);
		}
		else if(current.getClipNum() > newBoardNum) {
			insertBefore(newBoard);
		}
	}

	private void removeCurrent() {
		if (current == null) {
			System.out.println("Nothing to Cut!");
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

	public LineList getBoard(int clipBoardNum) {
		current = head;
		LineList retrieve = null;		
		while(current != null && retrieve == null) {
			if(current.getClipNum() == clipBoardNum) {
				retrieve = current;
				removeCurrent();
			}
			else {
				current = current.getNext();
			}
		}
		return retrieve;
	}
}