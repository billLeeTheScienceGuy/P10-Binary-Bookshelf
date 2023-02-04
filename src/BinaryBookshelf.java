
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Binary Bookshelf
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
import java.util.ArrayList;

/*
 * This class represents a binary search tree version of sorted Bookshelf, 
 * where all Books are sorted based on
 * the Attributes contained in the sortList. Books are compared first 
 * based on their authors, and then on the other Attributes in the order they appear in the sortList.
 */
public class BinaryBookshelf {
	private TreeNode<Book> root;
	private int size;
	private Attribute[] sortList;

	BinaryBookshelf(Attribute[] sortList) {
		this.root = null;
		this.size = 0;
		this.sortList = sortList;
	}

	public void clear() {
		this.root = null;
		this.size = 0;
		this.sortList = null;
	}

	/*
	 * This method searches for the input book in the bookshelf. implemented
	 * recursively.
	 * 
	 * @returns true if the book is present in the shelf, false otherwise
	 */
	public boolean contains(Book book) {
		return containsHelper(book, root);
	}
	/*
	 * Recursive helper method, searches for the input book in the subtree rooted at
	 * current
	 * 
	 * @param book is the query book to search for
	 * 
	 * @param current is the root of the current subtree
	 * 
	 * @returns true if the book is contained in this subtree, false otherwise
	 */

	protected boolean containsHelper(Book book, TreeNode<Book> current) {
		if (current == null) {
			return false;
		}

		if (containsHelper(book, current.getLeft()) == true) {
			return true;
		}
		if (current.getData().equals(book) == true) {
			return true;
		}
		if (containsHelper(book, current.getRight()) == true) {
			return true;
		} else
			return false;
	}
	/*
	 * This method returns a list of books in the bookshelf written by the given
	 * author
	 * 
	 * @param authorName is the author name to filter on
	 * 
	 * @returns a list of books by the author
	 */

	public ArrayList<Book> getBooksByAuthor(String authorName) {
		return getBooksByAuthorHelper(authorName, root);
	}

	protected ArrayList<Book> getBooksByAuthorHelper(String authorName, TreeNode<Book> current) {
		ArrayList<Book> list = new ArrayList<Book>();
		if (current == null) {
			return list;
		}
		if (current.getLeft() != null) {
			getBooksByAuthorHelper(authorName, current.getLeft());
		}
		if (current.getData().getAuthor().compareTo(authorName) == 0) {
			list.add(current.getData());
		}
		if (current.getRight() != null) {
			getBooksByAuthorHelper(authorName, current.getRight());
		}
		return list;
	}
	/*
	 * This method Creates and returns an in-order traversal of the BST, with each
	 * Book on a separate line
	 * 
	 * @returns an in-order traversal of the BST, with each Book on a separate line
	 */

	@Override
	public String toString() {
		return toStringHelper(root);
	}
	/*
	 * This is a recursive helper method, creates and returns the String
	 * representation of the subtree rooted at the current node
	 * 
	 * @param current is the root of the current subtree.
	 * 
	 * @returns the string representation of this subtree
	 */

	protected String toStringHelper(TreeNode<Book> current) {
		ArrayList<Book> list = new ArrayList<Book>();
		if (current != null) {
			toStringHelper(current.getLeft());
			list.add(current.getData());
			toStringHelper(current.getRight());
		}
		return list.toString();

	}
	/*
	 * Helper method to compare two Book objects according to the sortList of
	 * attributes. Uses both equals() and compareTo() from the Book class.
	 * 
	 * @param one is the first Book
	 * 
	 * @param two is the second Book.
	 * 
	 * @returns a negative value if one < two, a positive value if one > two, and 0
	 * if they are equal
	 */

	protected int compareToHelper(Book one, Book two) {
		if (one.equals(two)) {
			return 0;
		}
		if (one.compareTo(two, Attribute.AUTHOR) != 0) {
			return one.compareTo(two, Attribute.AUTHOR);
		}
		if (one.compareTo(two, Attribute.ID) != 0) {
			return one.compareTo(two, Attribute.ID);
		}
		if (one.compareTo(two, Attribute.TITLE) != 0) {
			return one.compareTo(two, Attribute.TITLE);
		}
		if (one.compareTo(two, Attribute.PAGECOUNT) != 0) {
			return one.compareTo(two, Attribute.PAGECOUNT);
		}
		return 0;
	}
	/*
	 * This method returns a shallow copy of the root node so that test tree
	 * structures may be constructed manually rather than by using the insertBook()
	 * method
	 * 
	 * @returns a reference to the current root node
	 */

	protected TreeNode<Book> getRoot() {
		return root;
	}
	/*
	 * This method adds a new Book to the BST in sorted order, relative to this
	 * BST's sortList attributes.
	 * 
	 * @book is the Book object to be added to the BST.
	 * 
	 * @throws IllegalArgumentException if this Book is already in the BST
	 */

	public void insertBook(Book book) {
		insertBookHelper(book, root);
	}
	/*
	 * This is a recursive helper method that adds the given Book to the subtree
	 * rooted at current.
	 * 
	 * @param book is the Book object to be added to the BST
	 * 
	 * @param current is the root of the current subtree
	 */

	protected void insertBookHelper(Book book, TreeNode<Book> current) {
		if (current.equals(null)) {
			size++;
			current = new TreeNode<Book>(book);
		}
		if (compareToHelper(book, current.getData()) == 0) {
			throw new IllegalArgumentException("The book is already in the BST");
		}
		if (compareToHelper(book, current.getData()) > 0) {
			insertBookHelper(book, current.getLeft());
		}
		if (compareToHelper(book, current.getData()) < 0) {
			insertBookHelper(book, current.getRight());
		}
	}
	/*
	 * This method determines whether the BST is empty
	 * 
	 * @returns true if the BST is empty, false otherwise
	 */

	public boolean isEmpty() {
		if (this.root == null || this.size == 0) {
			return true;
		}
		return false;
	}
	/*
	 * This method provides a String-formatted list of the attributes in the order
	 * in which they are used
	 * 
	 * @returns a String-formatted list of the sorting attributes.
	 */

	public String getAttributeOrder() {
		String result = "";
		for (int i = 1; i <= 4; i++) {
			result += i + ":" + sortList[i - 1].toString() + " ";
		}
		return result;
	}
	/*
	 * This method gets the number of nodes currently in the BST
	 * 
	 * @returns the number of nodes currently in the BST
	 */

	public int size() {
		return this.size;
	}

}
