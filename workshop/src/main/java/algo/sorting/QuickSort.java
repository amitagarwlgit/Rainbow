package algo.sorting;

/**
 * Quicksort is a sorting algorithm which applies divide and conquer paradigm. Moreover, it works
 * in-place but not stable. The performance of quicksort depends on selecting the pivot, and
 * starting to partition around it. During the partition procedure subarrays divided into four
 * regions; ≤x, >x, unrestricted ,and finally the pivot.
 *
 * <p>|....<= pivot....|....> pivot....|....{unrestricted}....|pivot|
 *
 * <pre>
 *  * Space complexity: O(n)
 *  *
 *  * Time complexity:
 *  *   Best: O(nlogn)
 *  *   Worst: O(n2)
 *  *   Average: O(nlogn)
 *  *
 * </pre>
 */
public class QuickSort implements Sorting {

  @Override
  public int[] sort(int[] input) {
    // int[] numbers = {3, 6, 1, 5, 8, 9, 2};
    if (input == null || input.length == 1) return input;
    quicksort(input, 0, input.length - 1);
    return input;
  }

  private void quicksort(int[] input, int low, int high) {

    if (low < high) {
      int pi = movePivotAtRightPlace(input, low, high);
      quicksort(input, low, pi);
      quicksort(input, pi + 1, high);
    }
  }

  private int movePivotAtRightPlace(int[] input, int low, int high) {

    int pivot = input[low];
    int i = low;

    for (int j = i + 1; j <= high; j++) {

      if (input[j] < pivot) {
        i++;
        swap(input, i, j);
      }
    }
    swap(input, i, low);
    return i;
  }

  private void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
