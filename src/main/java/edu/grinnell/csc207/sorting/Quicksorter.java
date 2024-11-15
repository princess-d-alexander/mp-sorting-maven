package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
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
    if (values == null || values.length < 2) {
      return;  // If the array is null or has fewer than two elements, no need to sort
    } // if
    quickSort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Helper method to recursively sort the array using Quicksort.
   *
   * @param values
   *   The array to sort.
   * @param low
   *   The starting index of the portion of the array to sort.
   * @param high
   *   The ending index of the portion of the array to sort.
   */
  private void quickSort(T[] values, int low, int high) {
    if (low < high) {
      // Partition the array around a pivot
      int[] pivotIndices = partition(values, low, high);

      // Recursively sort the subarrays
      quickSort(values, low, pivotIndices[0] - 1);  // Left subarray
      quickSort(values, pivotIndices[1] + 1, high); // Right subarray
    } // if
  } // quickSort(T[], int, int)

  /**
   * Partition the array using the Dutch National Flag algorithm.
   * Rearranges array into three sections: less than pivot, equal to pivot, and greater than pivot.
   *
   * @param values
   *   The array to partition.
   * @param low
   *   The starting index of the subarray to partition.
   * @param high
   *   The ending index of the subarray to partition.
   * @return
   *   An array containing the indices of the three partitions:
   *   [lowIndex, highIndex], where elements in values[lowIndex..highIndex] are equal to the pivot.
   */
  private int[] partition(T[] values, int low, int high) {
    // Choose a pivot element (we'll use the first element in this implementation)
    T pivot = values[low];

    int i = low + 1;  // i is for scanning the array from left to right
    int j = high;     // j is for scanning the array from right to left
    int equal = low;  // Pointer to keep track of the region of elements equal to the pivot

    // Use the Dutch National Flag algorithm to partition the array
    while (i <= j) {
      // Compare values[i] with the pivot
      if (order.compare(values[i], pivot) < 0) {
        // If values[i] is less than the pivot, swap it with values[equal] and increment i and equal
        swap(values, i, equal);
        i++;
        equal++;
      } else if (order.compare(values[i], pivot) > 0) {
        // If values[i] is greater than the pivot, swap it with values[j] and decrement j
        swap(values, i, j);
        j--;
      } else {
        // If values[i] is equal to the pivot, just move i forward
        i++;
      } // if
    } // while

    // Return the indices of the region of pivot elements
    return new int[] {equal, j };
  } // partition(T[], int, int)

  /**
   * Helper method to swap two elements in an array.
   *
   * @param values
   *   The array containing the elements to swap.
   * @param i
   *   The first index to swap.
   * @param j
   *   The second index to swap.
   */
  private void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap(T[], int, int)
} // class Quicksorter
