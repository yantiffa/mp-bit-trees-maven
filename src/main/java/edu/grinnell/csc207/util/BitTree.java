package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 * 
 * 
 * This class is implemented for fall24 CSC207
 * 
 * @author Tiffany
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * the root of the tree
   */
  BitTreeNode root;

  /**
   * the depth of the tree
   */
  int depth;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a tree with the provided depth, n
   * 
   * @param n the depth of the tree
   */
  public BitTree(int n) {
    this.depth = n;
    this.root = null;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set the value with the given bits path.
   * 
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    // check for if the depth is correct
    if (bits.length() != this.depth) {
      throw new IndexOutOfBoundsException("Incorrect data!\n");
    } // if

    // check for if the bits contain only 0 and 1
    if (bits.matches("[01]+")) {
      throw new IndexOutOfBoundsException("Incorrect data!\n");
    } // if

    if (root == null) {
      if (this.depth == 0) {
        this.root = new BitTreeLeaf(value);
      } else {
        root = new BitTreeInteriorNode();
      } // if
    } // if
    this.root.set(bits, value);
  } // set(String, String)

  /**
   * Get the value corresponding to the bits.
   * 
   * @param bits
   * @return a string corresponding to the bits path.
   */
  public String get(String bits) {
    // check for if the depth is correct
    if (bits.length() != this.depth) {
      throw new IndexOutOfBoundsException("Incorrect data!\n");
    } // if

    // check for if the bits contain only 0 and 1
    if (bits.matches("[01]+")) {
      throw new IndexOutOfBoundsException("Incorrect data!\n");
    } // if

    if (this.root == null) {
      throw new IndexOutOfBoundsException("Empty Tree\n");
    } // if

    return this.root.get(bits);
  } // get(String)

  /**
   * print out the tree by printing nodes one by one in CSV format.
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    if (this.root == null) {
    } else {
      this.root.dump(pen, "");
    } // if
  } // dump(PrintWriter)

  /**
   * reads a series of lines of the form bits,value and stores them in the tree.
   */
  public void load(InputStream source) {
    Scanner eye = new Scanner(source);
    while (eye.hasNextLine()) {
      String input = eye.nextLine().trim();
      if (input.length() != 0) {
        String[] sections = input.split(",");
        set(sections[0], sections[1]);
      } //if
    } //while
  } // load(InputStream)
} // class BitTree
