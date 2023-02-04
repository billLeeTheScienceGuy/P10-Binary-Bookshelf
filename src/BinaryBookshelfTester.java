//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Binary Bookshelf Tester
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NA
// Partner Email:   NA
// Partner Lecturer's Name: NA
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NA
// Online Sources:  NA
//
///////////////////////////////////////////////////////////////////////////////
/*
 * This class ensures that both BinaryBookshelf class and TreeNode class is valid.
 */
public class BinaryBookshelfTester {
	/*
	 * This method ensures that the generic class TreeNode is valid.
	 */
	public static boolean testTreeNode() {
		try {

			// Scenario 1: a single TreeNode with no children.
			TreeNode<Integer> tester1 = new TreeNode<Integer>(3);
			if (tester1.getLeft() != null || tester1.getRight() != null || (!(tester1.getData().equals(3)))
					|| (!(tester1.toString().equals("3")))) {
				return false;
			}
			// Scenario 2: a simple collection of TreeNodes.
			TreeNode<Integer> tester2 = new TreeNode<Integer>(4);
			tester2.setLeft(tester1);
			if (tester2.getLeft() == null || tester2.getRight() != null) {
				return false;
			}
			tester2.setLeft(null);
			if (tester2.getLeft() != null || tester2.getRight() != null) {
				return false;
			}
			// Scenario 3: multiple-arg constructor.
			TreeNode<Integer> tester3 = new TreeNode<Integer>(5, tester1, tester2);
			if (tester3.getLeft().getData() != 3 || tester3.getRight().toString() != "4") {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/*
	 * This method ensures that the basic methods of a BinaryBookshelf are valid, before any Books have
	 * been added to the shelf.
	 */

	public static boolean testEmptyTree() {
		// Scenario 1: invalid constructor inputs.
		try {
			Attribute[] att = new Attribute[4];
			BinaryBookshelf tester = new BinaryBookshelf(att);
		} catch (IllegalArgumentException e) {
		}
		try {
			Attribute[] att = new Attribute[3];
			BinaryBookshelf tester = new BinaryBookshelf(att);
		} catch (IllegalArgumentException e) {
		}
		try {
			Attribute[] att = new Attribute[4];
			att[0] = Attribute.AUTHOR;
			att[1] = Attribute.ID;
			att[2] = Attribute.AUTHOR;
			att[3] = Attribute.TITLE;
		} catch (IllegalArgumentException e) {
		}
		try {
			Attribute[] att = new Attribute[4];
			att[0] = Attribute.ID;
			att[1] = Attribute.AUTHOR;
			att[2] = Attribute.PAGECOUNT;
			att[3] = Attribute.TITLE;
		} catch (IllegalArgumentException e) {
		}
		// Scenario 2: valid input
		try {
			Attribute[] att = new Attribute[4];
			att[0] = Attribute.AUTHOR;
			att[1] = Attribute.ID;
			att[2] = Attribute.PAGECOUNT;
			att[3] = Attribute.TITLE;
			BinaryBookshelf tester = new BinaryBookshelf(att);
		
		if (tester.size() != 0 || tester.getRoot() != null || tester.isEmpty() != true || tester.toString() != null
				|| (!(tester.getAttributeOrder().equals("1:AUTHOR 2:ID 3:PAGECOUNT 4:TITLE")))) {
			return false;
		}
		Book anything = new Book("anything", 3);
		
		
			if (tester.contains(anything) != false || tester.getBooksByAuthor("anything") != null) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	/*
	 * This method ensures that the BinaryBookshelf insertBook() method works as expected.
	 */

	public static boolean testInsertBook() {
		try {
		// Scenario 1: inserting into an empty tree.
		Attribute[] att = new Attribute[4];
		att[0] = Attribute.AUTHOR;
		att[1] = Attribute.ID;
		att[2] = Attribute.PAGECOUNT;
		att[3] = Attribute.TITLE;
		BinaryBookshelf tester = new BinaryBookshelf(att);
		if (tester.isEmpty() == false) {
			return false;
		}
		
		Book book0 = new Book("CTITLE", 1, "CFIRST", "CLAST");
		tester.insertBook(book0);
		if (tester.isEmpty() == true) {
			return false;
		}
		TreeNode<Book> bookZero = new TreeNode<Book>(book0);
		if (!(tester.getRoot().equals(bookZero))) {
			return false;
		}
		// Scenario 2: inserting a unique, smaller value into a non-empty tree.
		try {
		Book book1 = new Book("CTITLE", 1, "CFIRST", "ALAST");
		tester.insertBook(book1);
		TreeNode<Book> bookOne = new TreeNode<Book>(book1);
		if (!(tester.getRoot().getLeft().equals(bookOne))) {
			return false;
		}
		}catch(NullPointerException e) {
			
		}
		// Scenario 3: inserting a value with a shared author attribute.
		Book book2 = new Book("CTITLE", 2, "CFIRST", "CLAST");
		tester.insertBook(book2);
		TreeNode<Book> bookTwo = new TreeNode<Book>(book2);
		if (!(tester.getRoot().getRight().equals(bookTwo))) {
			return false;
		}
		// Scenario 4: inserting a duplicate value.
		try {
			Book book3 = new Book("CTITLE", 2, "CFIRST", "CLAST");
			tester.insertBook(book3);
		} catch (Exception e) {
		}
		
		}catch (Exception e) {
			return false;
		}
		return true;

	}
	/*
	 * This method ensures that the BinaryBookshelf contains() method works as expected.
	 */

	public static boolean testContains() {
		// Scenario 1: non-recursive case.
		Attribute[] att = new Attribute[4];
		att[0] = Attribute.AUTHOR;
		att[1] = Attribute.ID;
		att[2] = Attribute.PAGECOUNT;
		att[3] = Attribute.TITLE;
		BinaryBookshelf tester = new BinaryBookshelf(att);
		Book bookD = new Book("DTITLE", 1, "DFIRST", "DLAST");

		tester.insertBook(bookD);
		if (tester.contains(bookD) != true) {
			return false;
		}
		Book bookB = new Book("BTITLE", 1, "BFIRST", "BLAST");
		if (tester.contains(bookB) == true) {
			return false;
		}
		// Scenario 2: recursive case.
		Book bookA = new Book("ATITLE", 1, "AFIRST", "ALAST");
		Book bookC = new Book("CTITLE", 1, "CFIRST", "CLAST");
		Book bookE = new Book("ETITLE", 1, "EFIRST", "ELAST");
		Book bookF = new Book("FTITLE", 1, "FFIRST", "FLAST");

		TreeNode<Book> bookNodeA = new TreeNode<Book>(bookA);
		TreeNode<Book> bookNodeB = new TreeNode<Book>(bookB);
		TreeNode<Book> bookNodeC = new TreeNode<Book>(bookC);
		TreeNode<Book> bookNodeD = tester.getRoot();
		TreeNode<Book> bookNodeE = new TreeNode<Book>(bookE);
		TreeNode<Book> bookNodeF = new TreeNode<Book>(bookF);

		bookNodeD.setLeft(bookNodeB);
		bookNodeB.setLeft(bookNodeA);
		bookNodeB.setRight(bookNodeC);
		bookNodeD.setRight(bookNodeE);
		bookNodeE.setRight(bookNodeF);
		if (!tester.contains(bookA) || !tester.contains(bookB) || !tester.contains(bookC) || !tester.contains(bookD)
				|| !tester.contains(bookE) || !tester.contains(bookF)) {
			return false;

		}
		return true;
	}
	/*
	 * This method ensures that the BinaryBookshelf getBooksByAuthor() method works as expected.
	 */

	public static boolean testGetBooksByAuthor() {
		try {
		Attribute[] att = new Attribute[4];
		att[0] = Attribute.AUTHOR;
		att[1] = Attribute.ID;
		att[2] = Attribute.PAGECOUNT;
		att[3] = Attribute.TITLE;
		BinaryBookshelf tester = new BinaryBookshelf(att);
		Book bookAA = new Book("ATITLE", 1, "AFIRST", "ALAST");
		Book bookAB = new Book("BTITLE", 1, "AFIRST", "ALAST");
		Book bookC = new Book("CTITLE", 1, "CFIRST", "CLAST");
		Book bookD = new Book("DTITLE", 1, "DFIRST", "DLAST");
		Book bookE = new Book("ETITLE", 1, "EFIRST", "ELAST");
		Book bookF = new Book("FTITLE", 1, "FFIRST", "FLAST");
		tester.insertBook(bookD);
		if (tester.getBooksByAuthor("DFIRST, DLAST").size() != 1
				|| tester.getBooksByAuthor("CFIRST, CLAST").size() != 0) {
			return false;
		}
		// Scenario 2: recursive case.
		TreeNode<Book> bookNodeAA = new TreeNode<Book>(bookAA);
		TreeNode<Book> bookNodeAB = new TreeNode<Book>(bookAB);
		TreeNode<Book> bookNodeC = new TreeNode<Book>(bookC);
		TreeNode<Book> bookNodeD = tester.getRoot();
		TreeNode<Book> bookNodeE = new TreeNode<Book>(bookE);
		TreeNode<Book> bookNodeF = new TreeNode<Book>(bookF);
		bookNodeD.setLeft(bookNodeAB);
		bookNodeAB.setLeft(bookNodeAA);
		bookNodeAB.setRight(bookNodeC);
		bookNodeD.setRight(bookNodeE);
		bookNodeE.setRight(bookNodeF);
		if (tester.getBooksByAuthor("AFIRST, ALAST").size() != 2
				|| tester.getBooksByAuthor("Bill, Lee").size() != 0 || tester.getBooksByAuthor("FFIRST, FLAST").size() != 1) {
			return false;
		}
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
