/**
* 	Editor Test Class
*	Unit Tests for Project 4 of Winter 2014 CIS 163
*	@author Michael Hartung, Matthew Armand
*/
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class EditorTest {

	@Test
	public void testInsertAfter() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		assertEquals("    1: Test 1\n-->2: Test 2\n", e.getProcess().getList().toString());
	}

	@Test
	public void testInsertBefore() {
		Editor e = new Editor();
		e.processCommand("b Test 1");
		e.processCommand("b Test 2");
		assertEquals("--> Test 2\n    Test 1\n", e.getProcess().getList().toString());
	}

	@Test
	public void testInsertLast() {
		Editor e = new Editor();
		e.processCommand("b Test 1");
		e.processCommand("b Test 2");
		e.processCommand("e Test 3");
		assertEquals("    Test 2\n    Test 1\n--> Test 3\n", e.getProcess().getList().toString());
	}

	@Test
	public void testMoveUp() {
		Editor e = new Editor();
		e.processCommand("b Test 1");
		e.processCommand("b Test 2");
		e.processCommand("e Test 3");
		e.processCommand("u");
		assertEquals("Test 1\n", e.getCurrentLine());
	}

	@Test
	public void testMoveUpMult() {
		Editor e = new Editor();
		e.processCommand("b Test 1");
		e.processCommand("b Test 2");
		e.processCommand("e Test 3");
		e.processCommand("u 2");
		assertEquals("Test 2\n", e.getCurrentLine());
	}

	@Test
	public void testMoveDown() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("b Test 2");
		e.processCommand("b Test 3");
		e.processCommand("b Test 4");
		e.processCommand("m");
		assertEquals("Test 3\n", e.getCurrentLine());
	}

	@Test
	public void testMoveDownMult() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("b Test 2");
		e.processCommand("b Test 3");
		e.processCommand("b Test 4");
		e.processCommand("m 2");
		assertEquals("Test 2\n", e.getCurrentLine());
	}

	@Test
	public void testRemove() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		e.processCommand("i Test 3");
		e.processCommand("r");
		assertEquals("    Test 1\n--> Test 2", e.getProcess().getList().toString());
	}

	@Test
	public void testRemoveMult() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		e.processCommand("i Test 3");
		e.processCommand("r 2");
		assertEquals("--> Test 1\n", e.getProcess().getList().toString());
	}

	@Test
	public void testDisplay() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		e.processCommand("i Test 3");
		e.processCommand("d");
		assertEquals("    Test 1\n    Test 2\n--> Test 3\n", e.getProcess().getList().toString());
	}

	@Test
	public void testDisplaySpecific() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		e.processCommand("i Test 3");
		e.processCommand("d 2 3");
		assertEquals("    Test 2\n--> Test 3\n", e.getProcess().getList().toString());
	}

	@Test
	public void testClear() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		e.processCommand("i Test 3");
		e.processCommand("!c");
		assertEquals("", e.getProcess().getList().toString());
	}

	@Test
	public void testSaveLoad() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("i Test 2");
		e.processCommand("i Test 3");
		e.processCommand("s file1");
		Editor f = new Editor();
		f.processCommand("!l file1");
		f.processCommand("m 2");
		assertEquals(e.getProcess().getList().toString(),
				f.getProcess().getList().toString());
	}

	@Test
	public void testHelp() {
		
	}

	@Test
	public void testExit() {
		Editor e = new Editor();
		e.processCommand("!x");
		assertFalse(e.getActive());
	}

	@Test
	public void testCut() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		e.processCommand("cut 1 1 1");
		assertEquals("", e.getProcess().getList().toString());
	}

	@Test
	public void testPaste() {
		Editor e = new Editor();
		e.processCommand("i Test 1");
		String t1 = e.getProcess().getList().toString();
		e.processCommand("cut 1 1 1");
		e.processCommand("pas 1");
		assertEquals(t1, e.getProcess().getList().toString());
	}
}