package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * AlexanderPrincessSort aka BubbleMergeSort
 * - Uses bubble sort for smaller or nearly sorted arrays
 * - Switches to a merge sort approach for larger, more unordered arrays.
 *
 * This algorithm adapts to the characteristics of the input, making it efficient for all input types.
 *
 * @param <T> The type of elements in the array to be sorted.
 *
 * @author Princess Alexander with help of online resource
 */
public class AlexanderPrincessSort<T> implements Sorter<T> {

  private Comparator<? super T> order;

  /**
   * Constructor for my sort.
   *
   * @param comparator Comparator to define the sorting order.
   */
  public AlexanderPrincessSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // constructor

  /**
   * Sorts the given array using the hybrid approach of BubbleSort followed by MergeSort.
   *
   * @param values The array to sort.
   */
  @Override
  public void sort(T[] values) {
    if (values == null || values.length <= 1) {
      return;  // Array is already sorted or empty
    } //if

    // First, try to bubble sort the array to catch small or nearly sorted arrays
    bubbleSort(values);

    // If it's still not fully sorted, use a merge sort
    if (!isSorted(values)) {
      mergeSort(values, 0, values.length - 1);
    } // if
  } // sort

  /**
   * Performs a single pass of bubble sort on the array.
   * If no swaps are made, it stops early.
   *
   * @param values The array to sort.
   */
  private void bubbleSort(T[] values) {
    boolean swapped;
    for (int i = 0; i < values.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < values.length - 1 - i; j++) {
        if (order.compare(values[j], values[j + 1]) > 0) {
          // Swap the elements if they are in the wrong order
          T temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;
          swapped = true;
        } // if
      } // for
      // If no elements were swapped in this pass, the array is sorted
      if (!swapped) {
        break;
      } // if
    } // for
  } // bubbleSort

  /**
   * Checks if the array is sorted.
   *
   * @param values The array to check.
   * @return true if the array is sorted, false otherwise.
   */
  private boolean isSorted(T[] values) {
    for (int i = 0; i < values.length - 1; i++) {
      if (order.compare(values[i], values[i + 1]) > 0) {
        return false;
      } // if
    } // for
    return true;
  } // isSorted

  /**
   * Performs merge sort on the array.
   *
   * @param values The array to sort.
   * @param left The starting index of the subarray.
   * @param right The ending index of the subarray.
   */
  private void mergeSort(T[] values, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(values, left, mid);
      mergeSort(values, mid + 1, right);
      merge(values, left, mid, right);
    } // if
  } // mergeSort

  /**
   * Merges two sorted halves of the array.
   *
   * @param values The array to sort.
   * @param left The starting index of the left subarray.
   * @param mid The middle index.
   * @param right The ending index of the right subarray.
   */
  private void merge(T[] values, int left, int mid, int right) {
    // Create temporary arrays for the left and right subarrays
    T[] leftArray = (T[]) new Object[mid - left + 1];
    T[] rightArray = (T[]) new Object[right - mid];

    System.arraycopy(values, left, leftArray, 0, leftArray.length);
    System.arraycopy(values, mid + 1, rightArray, 0, rightArray.length);

    // Merge the temporary arrays back into the original array
    int i = 0;
    int j = 0;
    int k = left;
    while (i < leftArray.length && j < rightArray.length) {
      if (order.compare(leftArray[i], rightArray[j]) <= 0) {
        values[k++] = leftArray[i++];
      } else {
        values[k++] = rightArray[j++];
      } // if
    } // while

    // Copy remaining elements from the left or right array
    while (i < leftArray.length) {
      values[k++] = leftArray[i++];
    } // while
    while (j < rightArray.length) {
      values[k++] = rightArray[j++];
    } // while
  } // merge
} // AlexanderPrincessSort
