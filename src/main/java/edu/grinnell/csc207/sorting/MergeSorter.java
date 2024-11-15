package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Princess Alexander
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
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
    if (values.length < 2) {
      return;  // No need to sort if the array has fewer than two elements
    } // if
    mergeSort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Helper method to help us recursively sort the array using merge sort.
   *
   * @param values
   *   The array to sort.
   * @param low
   *   The starting index of the portion of the array to sort.
   * @param high
   *   The ending index of the portion of the array to sort.
   */
  private void mergeSort(T[] values, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;

      // Recursively sort the two halves
      mergeSort(values, low, mid);
      mergeSort(values, mid + 1, high);
      // Merge the sorted halves
      merge(values, low, mid, high);
    } // if
  } // mergeSort(T[], int, int)

  /**
   * Merges two sorted subarrays into a single sorted array.
   *
   * @param values
   *   The array containing the subarrays.
   * @param low
   *   The starting index of the left subarray.
   * @param mid
   *   The ending index of the left subarray (and mid point).
   * @param high
   *   The ending index of the right subarray.
   */
  private void merge(T[] values, int low, int mid, int high) {
    // Create temporary arrays to hold the left and right subarrays
    int leftSize = mid - low + 1;
    int rightSize = high - mid;

    Object[] left = new Object[leftSize];
    Object[] right = new Object[rightSize];

    // Copy data into temporary arrays
    System.arraycopy(values, low, left, 0, leftSize);
    System.arraycopy(values, mid + 1, right, 0, rightSize);

    // Merge the two subarrays back into the original array
    int i = 0;
    int j = 0;
    int k = low;
    while (i < leftSize && j < rightSize) {
      if (order.compare((T) left[i], (T) right[j]) <= 0) {
        values[k] = (T) left[i];
        i++;
      } else {
        values[k] = (T) right[j];
        j++;
      } // if
      k++;
    } // while

    // Copy remaining elements from left subarray, if any
    while (i < leftSize) {
      values[k] = (T) left[i];
      i++;
      k++;
    } // while

    // Copy remaining elements from right subarray, if any
    while (j < rightSize) {
      values[k] = (T) right[j];
      j++;
      k++;
    } // while
  } // merge(T[], int, int, int)
} // class MergeSorter
