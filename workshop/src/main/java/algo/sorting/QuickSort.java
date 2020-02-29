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
    // int[] numbers = {3, 6, 1, 5, 8, 9, 1};

    if (input == null || input.length < 2) {
      return input;
    }
    quickSort(input, 0, input.length - 1);
    return input;
  }

  private void quickSort(int[] arr, int low, int high) {

    if (low < high) {
      int pi = putPivotAtRightPlace(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private int putPivotAtRightPlace(int arr[], int low, int high) {
    int pivot = arr[low];
    int i = low; // index of smaller element
    for (int j = low + 1; j <= high; j++) {
      // If current element is smaller than the pivot
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i, low);
    return i;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
