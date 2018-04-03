import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {
	
	

	@Test
	public void test12() {
		LinkedList<String> newList= new LinkedList<String>();
		assertEquals("Searching", true, newList.isEmpty());
	}
	
	@Test
	public void test1() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		assertEquals("Searching", "a", newList.toString());
	}
	
	@Test
	public void test2() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		assertEquals("Searching", "v -> a", newList.toString());
	}
	
	@Test
	public void test3() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		assertEquals("Searching", "a -> v -> a", newList.toString());
	}
	
	
	
	@Test
	public void test4() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		assertEquals("Searching", "l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test5() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		assertEquals("Searching", "o -> l -> a -> v -> a", newList.toString());
	}

	@Test
	public void test6() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		assertEquals("Searching", "i -> o -> l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test7() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		newList.insertAfter(newList.getFirstNode().getNext(), "j");
		assertEquals("Searching", "i -> o -> j -> l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test8() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		newList.insertAfter(newList.getFirstNode().getNext(), "j");
		newList.insertAfter(newList.getFirstNode().getNext(), "e");
		assertEquals("Searching", "i -> o -> e -> j -> l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test9() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		newList.insertAfter(newList.getFirstNode().getNext(), "j");
		newList.insertAfter(newList.getFirstNode().getNext(), "e");
		newList.insertAfter(newList.getFirstNode().getNext(), "v");
		assertEquals("Searching", "i -> o -> v -> e -> j -> l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test10() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		newList.insertAfter(newList.getFirstNode().getNext(), "j");
		newList.insertAfter(newList.getFirstNode().getNext(), "e");
		newList.insertAfter(newList.getFirstNode().getNext(), "v");
		newList.insertAfter(newList.getFirstNode(), "l");
		assertEquals("Searching", "i -> l -> o -> v -> e -> j -> l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test11() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		newList.insertAfter(newList.getFirstNode().getNext(), "j");
		newList.insertAfter(newList.getFirstNode().getNext(), "e");
		newList.insertAfter(newList.getFirstNode().getNext(), "v");
		newList.insertAfter(newList.getFirstNode(), "l");
		newList.deleteNext(newList.getFirstNode().getNext().getNext().getNext().getNext());
		assertEquals("Searching", "i -> l -> o -> v -> e -> l -> a -> v -> a", newList.toString());
	}
	
	@Test
	public void test13() {
		LinkedList<String> newList= new LinkedList<String>();
		newList.insertFirst("a");
		newList.insertFirst("v");
		newList.insertFirst("a");
		newList.insertFirst("l");
		newList.insertFirst("o");
		newList.insertFirst("i");
		newList.insertAfter(newList.getFirstNode().getNext(), "j");
		newList.insertAfter(newList.getFirstNode().getNext(), "e");
		newList.insertAfter(newList.getFirstNode().getNext(), "v");
		newList.insertAfter(newList.getFirstNode(), "l");
		newList.deleteNext(newList.getFirstNode().getNext().getNext().getNext().getNext());
		newList.deleteLast();
		assertEquals("Searching", "i -> l -> o -> v -> e -> l -> a -> v", newList.toString());
	}
	
	
}
