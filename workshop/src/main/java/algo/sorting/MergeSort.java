package algo.sorting;

public class MergeSort implements Sorting {

  @Override
  public int[] sort(int[] input) {

    if (input == null || input.length < 2) {
      return input;
    }
    mergeSort(input, 0, input.length - 1);
    return input;
  }

  private void mergeSort(int[] input, int low, int high) {

    if (low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(input, low, mid);
      mergeSort(input, mid + 1, high);
      merge(input, low, mid, high);
    }
  }

  private void merge(int[] input, int low, int mid, int high) {
    int[] leftArray = new int[mid - low + 1];
    int[] rightArray = new int[high - mid];

    // copy values into created arrays
    System.arraycopy(input, low, leftArray, 0, leftArray.length);
    System.arraycopy(input, mid + 1, rightArray, 0, rightArray.length);

    int i = 0;
    int j = 0;
    int k = low;
    // merge two arrays
    while (i < leftArray.length && j < rightArray.length) {
      if (leftArray[i] <= rightArray[j]) {
        input[k] = leftArray[i];
        i++;
      } else {
        input[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while (i < leftArray.length) {
      input[k] = leftArray[i];
      k++;
      i++;
    }

    while (j < rightArray.length) {
      input[k] = rightArray[j];
      k++;
      j++;
    }
  }
}
