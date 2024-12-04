package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * The node of a tree.
 * 
 * This is implemented for CSC207 fall 24.
 * 
 * @author Tiffany Yan
 */
public interface BitTreeNode {
  /**
   * Obtain the value from the provided bits path
   * 
   * @param bits the path that I would use to find its corresponding value.
   * @return the value corresponding to the given bits.
   */
  public String get(String bits);

  /**
   * Sets the value of the bits path by provided info.
   * 
   * @param bits the path that I would use to set its corresponding value.
   * @param value the value I want to be stored at the given node.
   */
  public void set(String bits, String value);

  /**
   * Print out the tree in the format of CSV.
   * 
   * @param pen
   * @param pre the string stored in the node before the current the current node.
   */
  public void dump(PrintWriter pen, String pre);
}
