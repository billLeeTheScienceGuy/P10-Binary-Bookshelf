//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TreeNode
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
 * This class represents a generic binary tree node
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	/*
	 * Constructs a node with the given data and no children.
	 * 
	 * @param data is the data to be contained in this node
	 */

	public TreeNode(T data) {
		this.data = data;
	}
	/*
	 * Constructs a node with the given data and children.
	 * 
	 * @param data is the data to be contained in this node.
	 * @param left is the left child of this node, may be null
	 * @param right - the right child of this node, may be null
	 */

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	/*
	 * This method is an accessor for the left child of the node.
	 * 
	 * @returns a reference to the left child of this node.
	 */

	public TreeNode<T> getLeft() {
		return left;
	}
	/*
	 * This method is an accessor for the right child of the node
	 * 
	 * @returns a reference to the right child of this node
	 */

	public TreeNode<T> getRight() {
		return right;
	}
	/*
	 * This method is an accessor for the data contained in the node
	 * 
	 * @returns the data contained in the node
	 */

	public T getData() {
		return data;
	}
	/*
	 * This method changes the left child reference of this node; may be null
	 * 
	 * @param left is the new left child reference
	 */

	public void setLeft(TreeNode<T> left) {
		try {
			this.left = left;
		} catch (NullPointerException e) {

		}
	}
	/*
	 * This method changes the right child reference of this node; may be null
	 * 
	 * @param right is the new right child reference
	 */

	public void setRight(TreeNode<T> right) {
		try {
			this.right = right;
		} catch (NullPointerException e) {

		}
	}
	/*
	 * This method returns a string representation of this node's data
	 * 
	 * @returns a string representation of this node's data.
	 */
	@Override
	public String toString() {
		return data.toString();
	}

}
