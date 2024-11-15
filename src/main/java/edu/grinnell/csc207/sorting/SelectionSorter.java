package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using selection sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 */

public class SelectionSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using selection sort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    // Traverse the array from the first element to the second last
    for (int i = 0; i < values.length - 1; i++) {
      // Find the minimum element in the unsorted portion
      int minIndex = i;
      for (int j = i + 1; j < values.length; j++) {
        if (order.compare(values[j], values[minIndex]) < 0) {
          minIndex = j;  // Update minIndex if a smaller element is found
        } // if
      } //for

      // If minIndex is not the same as i, swap the elements
      if (minIndex != i) {
        T temp = values[i];
        values[i] = values[minIndex];
        values[minIndex] = temp;
      } // if
    } // for
  } // sort(T[])
} // class SelectionSorter
