import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;


public class TextBuddyTest {

	private static Vector<String> sortedList = new Vector<String>();
	private static Vector<String> compactedList = new Vector<String>();
	private static String testFile = "testFile.txt";

	@Test
	public void test() {
		generateSortedData();
		generateCompactedData();
		TextBuddy.fileName = testFile;
		TextBuddy.checkFileExist();
		testAll();
	}

	private static void testAll() {
		testClearMethod();
		testAddMethod();
		testSortMethod();
		testSearchMethod();
		testCompactMethod();
	}
	
	private static void generateSortedData() {
		sortedList.add("brown fox");
		sortedList.add("jumped over");
		sortedList.add("lazy dog");
		sortedList.add("The quick");
		sortedList.add("The quick");
	}
	
	private static void generateCompactedData() {
		compactedList.add("brown fox");
		compactedList.add("jumped over");
		compactedList.add("lazy dog");
		compactedList.add("The quick");
	}

	private static void testClearMethod() {
		assertEquals("\nall content deleted from testFile.txt\n", TextBuddy.executeCommand("clear"));
	}

	private static void testAddMethod() {
		assertEquals("\nadded to testFile.txt : \"lazy dog\"\n",
				TextBuddy.executeCommand("add lazy dog"));
		assertEquals("\nadded to testFile.txt : \"brown fox\"\n",
				TextBuddy.executeCommand("add brown fox"));
		assertEquals("\nadded to testFile.txt : \"The quick\"\n",
				TextBuddy.executeCommand("add The quick"));
		assertEquals("\nadded to testFile.txt : \"The quick\"\n",
				TextBuddy.executeCommand("add The quick"));
		assertEquals("\nadded to testFile.txt : \"jumped over\"\n",
				TextBuddy.executeCommand("add jumped over"));

	}

	private static void testSortMethod() {
		TextBuddy.executeCommand("sort");
		Vector<String> sortedData = TextBuddy.readDataFromFile();
		for(int index = 0; index < sortedData.size(); index++) {
			assertEquals("Data sorted.", sortedList.elementAt(index),sortedData.elementAt(index));
		}
	}

	private static void testSearchMethod() {
		assertEquals("\n1. brown fox\n",TextBuddy.executeCommand("search bro"));
		assertEquals("\nNo results found.\n", TextBuddy.executeCommand("search abc"));
	}
	
	private static void testCompactMethod() {
		TextBuddy.executeCommand("compact");
		Vector<String> compactedData = TextBuddy.readDataFromFile();
		for(int index = 0; index < compactedData.size(); index++) {
			assertEquals("Data compacted.", compactedList.elementAt(index), compactedData.elementAt(index));
		}
	}


}
