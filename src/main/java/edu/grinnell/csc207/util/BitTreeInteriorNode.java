package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * This class is for nodes that are not the leaf. It creates the tree structure by linking nodes.
 * 
 * This class is implemented for CSC207 fall 2024.
 * 
 * @author Tiffany Yan
 */
public class BitTreeInteriorNode implements BitTreeNode {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The branch to the left of the current node.
   */
  BitTreeNode left;

  /**
   * The branch to the right of the current node.
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Initialize the left and right branch to null.
   */
  public BitTreeInteriorNode() {
    this.left = null;
    this.right = null;
  } // BitTreeInteriorNode(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Obtain the value from the provided bits path
   * 
   * @param bits the path that I would use to find its corresponding value.
   * @return the value corresponding to the given bits.
   */
  public String get(String bits) {
    if (bits.length() == 0) {
      throw new IndexOutOfBoundsException("the bits are empty!");
    } //if
    // check if we are looking at the right path or the left path
    if (bits.charAt(0) == '0') {
      if (this.left == null) {
        throw new IndexOutOfBoundsException("no matching path");
      } //if
      // go to the left
      return left.get(bits.substring(1));
    } else {
      if (this.right == null) {
        throw new IndexOutOfBoundsException("no matching path");
      } //if
      // go to the right
      return right.get(bits.substring(1));
    } // if
  } // get(String)

  /**
   * Sets the value of the bits path by provided info.
   * 
   * @param bits the path that I would use to set its corresponding value.
   * @param value the value I want to be stored at the given node.
   */
  public void set(String bits, String value) {
    if (bits.length() == 0) {
      throw new IndexOutOfBoundsException("the bits are not empty!");
    } //if
    // check for the direction
    if (bits.charAt(0) == '0') { // left
      if (this.left == null) {
        if (bits.length() == 1) {
          this.left = new BitTreeLeaf(value);
        } else {
          this.left = new BitTreeInteriorNode();
        } // if
      } // if
      left.set(bits.substring(1), value);
    } else {
      if (this.right == null) {
        if (bits.length() == 1) {
          this.right = new BitTreeLeaf(value);
        } else {
          this.right = new BitTreeInteriorNode();
        } // if
      } // if
      right.set(bits.substring(1), value);
    } // if
  } // set(String, String)

  /**
   * Print out the tree in the format of CSV.
   * 
   * @param pen
   * @param pre the string stored in the node before the current the current node.
   */
  public void dump(PrintWriter pen, String pre) {
    if (this.left != null) {
      this.left.dump(pen, pre + "0");
    } // if
    if (this.right != null) {
      this.right.dump(pen, pre + "1");
    } // if
  } // dump(PrintWriter, String)
} // Class BitTreeInteriorNode
