public class DSA_10_Find_Min_in_Rotated_Sorted_Array {

  // Time Complexity: O(N), N = size of the given array.
  // Space Complexity: O(1)
  public static int findMin(int[] arr) {
    int n = arr.length;

    int mini = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      mini = Math.min(mini, arr[i]);
    }
    return mini;
  }

  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1)
  public static int findMin1(int[] arr) {
    int n = arr.length;
    int low = 0, high = n - 1;
    int ans = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      // search space is already sorted
      // then arr[low] will always be
      // the minimum in that search space:
      if (arr[low] <= arr[high]) {
        ans = Math.min(ans, arr[low]);
        break;
      }
      // If Left Part is sorted
      if (arr[low] <= arr[mid]) {
        // Keep the min
        ans = Math.min(ans, arr[low]);
        // Eliminate the left
        low = mid + 1;
      } // if right part is sorted
      else {
        // Keep the min
        ans = Math.min(ans, arr[mid]);
        high = mid - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
    int ans = findMin1(arr);
    System.out.println("The minimum element is: " + ans);
  }
}
