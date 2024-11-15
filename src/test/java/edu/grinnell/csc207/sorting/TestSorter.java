package edu.grinnell.csc207.sorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Princess Alexander
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "apple", "canyon", "dragonfly", "echo", "fable" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "whisper", "violet", "treasure", "quartz", "oasis" };
    String[] expected = { "oasis", "quartz", "treasure", "violet", "whisper" };
    assertSorts(expected, original, stringSorter);
  } // reverseOrderedStringTest

  /**
   * Ensure that an array with duplicate elements sorts correctly.
   */
  @Test
  public void duplicateStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "apple", "apple", "banana", "banana", "cherry" };
    String[] expected = { "apple", "apple", "banana", "banana", "cherry" };
    ArrayUtils.permute(original);
    assertSorts(expected, original, stringSorter);
  } // duplicateStringTest

  /**
   * Ensure that an empty array is handled correctly.
   */
  @Test
  public void emptyArrayTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {};
    String[] expected = {};
    assertSorts(expected, original, stringSorter);
  } // emptyArrayTest

    /**
   * Ensure that a single-element array is handled correctly.
   */
  @Test
  public void singleElementTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alone" };
    String[] expected = { "alone" };
    assertSorts(expected, original, stringSorter);
  } // singleElementTest
} // class TestSorter
