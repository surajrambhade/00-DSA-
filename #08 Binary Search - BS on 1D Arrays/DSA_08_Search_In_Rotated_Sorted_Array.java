import java.util.ArrayList;
import java.util.Arrays;

public class DSA_08_Search_In_Rotated_Sorted_Array {
  // Unique 
  // Identify the sorted half
  // Time Complexity: O(N), N = size of the given array.
  // Space Complexity: O(1)
  public static int search(ArrayList<Integer> arr, int n, int k) {
    for (int i = 0; i < n; i++) {
      if (arr.get(i) == k)
        return i;
    }
    return -1;
  }

  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1)
  public static int search1(ArrayList<Integer> arr, int n, int k) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (arr.get(mid) == k)
        return mid;
      // left
      if (arr.get(low) <= arr.get(mid)) {
        if (arr.get(low) <= k && k <= arr.get(mid)) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } // right
      else {
        if (arr.get(mid) <= k && k <= arr.get(high)) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
    int n = 9, k = 1;
    int res = search(arr, n, k);
    if (res == -1)
      System.out.println("Target is not present.");
    else
      System.out.println("The index is: " + res);
  }
}
