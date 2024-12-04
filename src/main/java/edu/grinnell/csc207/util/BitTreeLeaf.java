package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * The last node (leaf) of a branch of tree. It should contain a field for the string.
 * 
 * This class is implemented for CSC207 fall 24.
 * 
 * @author Tiffany Yan
 */
public class BitTreeLeaf implements BitTreeNode {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Because a leaf is at the end of a tree, we store a value corresponding to its bits path.
   */
  String value;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /*
   * Build a new leaf with the given val stored.
   * 
   * @param val
   *  the value to be stored
   */
  public BitTreeLeaf(String val) {
    this.value = val;
  } // BitTreeLeaf(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * This method gets the value associated with the given bits (which is a path).
   * 
   * @param bits
   *  the path provided
   * @return the String associated with the bits
   */
  public String get(String bits){
    if (bits.length() != 0) {
      throw new IndexOutOfBoundsException("the bits are not empty!");
    } //if
    return this.value;
  } //get(String)

  /**
   * This method sets the value with the provided bits
   * 
   * @param bits
   * @param val
   */
  public void set(String bits, String value){
    if (bits.length() != 0) {
      throw new IndexOutOfBoundsException("the bits are not empty!");
    } //if
    this.value = value;
  } //set(String, String)

  /**
   * Print out the tree
   * @param pen
   * @param pre the string stored in the node before the current the current node.
   */
  public void dump(PrintWriter pen, String pre) {
    pen.println(pre + ',' + this.value);
  } //dump(PrintWriter, String)
} //Class BitTreeLeaf
