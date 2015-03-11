import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;


public class TextBuddyTest {

	private static Vector<String> testData = new Vector<String>();
	private String testFile = "testFile.txt";

	@Test
	public void test() {
		generateSortedData();
		TextBuddy.fileName = testFile;
		TextBuddy.checkFileExist();
		testAll();
	}


	private static void testAll() {
		testClearMethod();
		testAddMethod();
		testSortMethod();
		testSearchMethod();
	}
	private static void generateSortedData() {
		testData.add("brown fox");
		testData.add("jumped over");
		testData.add("lazy dog");
		testData.add("The quick");
	}

	private static void testClearMethod() {
		assertEquals("\nall content deleted from testFile.txt\n", TextBuddy.executeCommand("clear"));
	}

	private static void testAddMethod() {
		assertEquals("\nadded to testFile.txt : \"lazy dog\"\n",
				TextBuddy.executeCommand("add lazy dog"));
		assertEquals("\nadded to testFile.txt : \"brown fox\"\n",
				TextBuddy.executeCommand("add brown fox"));
		assertEquals("\nadded to testFile.txt : \"jumped over\"\n",
				TextBuddy.executeCommand("add jumped over"));
		assertEquals("\nadded to testFile.txt : \"The quick\"\n",
				TextBuddy.executeCommand("add The quick"));
	}

	private static void testSortMethod() {
		TextBuddy.executeCommand("sort");
		Vector<String> sortedData = TextBuddy.readDataFromFile();
		for(int index = 0; index < sortedData.size(); index++) {
			assertEquals("Data sorted.",testData.elementAt(index),sortedData.elementAt(index));
		}
	}

	private static void testSearchMethod() {
		assertEquals("\n1. brown fox\n",TextBuddy.executeCommand("search bro"));
		assertEquals("\nNo results found.\n", TextBuddy.executeCommand("search abc"));
	}


}
