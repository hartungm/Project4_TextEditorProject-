/************************************************************************
 * Class for Line object within Ted Editor Program as the base object in
 * the Linked List structure
 * @author Michael Hartung, Matthew Armand
 */
public class Line {
	//Content string, next and previous reference objects
	private String content;
	private Line next;
	private Line prev;

	/********************************************************************
	 * Constructs a new blank line object
	 */
	public Line() {
		content = "\n";
	}
	
	/********************************************************************
	 * Constructs a new line object with parameter text as content
	 * @param newLine String to be set as line content
	 */
	public Line(String newLine) {
		content = newLine + "\n";
	}

	/********************************************************************
	 * Sets the next object reference to the parameter line
	 * @param l Line to be set as next in the Linked List
	 */
	public void setNext(Line l) {
		next = l;
	}

	/********************************************************************
	 * Gets the next object reference in the Linked List structure
	 * @return Next Line in the Linked List
	 */
	public Line getNext() {
		return next;
	}

	/********************************************************************
	 * Sets the previous object reference in the Linked List structure
	 * @param l Line to be set as previous in the Linked List
	 */
	public void setPrev(Line l) {
		prev = l;
	}

	/********************************************************************
	 * Gets the previous object reference in the Linked List structure
	 * @return Previous Line in the Linked List
	 */
	public Line getPrev() {
		return prev;
	}

	/********************************************************************
	 * Returns string representation of the Line object
	 */
	public String toString() {
		return content;
	}
}