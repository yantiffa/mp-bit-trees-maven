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
    // check if we are looking at the right path or the left path
    if (bits.charAt(0) == '0') {
      // go to the left
      return left.get(bits.substring(1));
    } else {
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
    // check for the direction
    if (bits.charAt(0) == '0') { // left
      left.set(bits.substring(1), value);
    } else {
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
    } //if
    if (this.right != null) {
      this.right.dump(pen, pre + "0");
    } //if
  } //dump(PrintWriter, String)
} // Class BitTreeInteriorNode
