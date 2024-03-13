//https://www.codingninjas.com/studio/problems/rotation_7449070?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_11_how_many_times_array_has_been_rotated {

  // Time Complexity: O(N), N = size of the given array.
  // Space Complexity: O(1)
  public static int findKRotation1(int[] arr) {
    int n = arr.length; //size of array.
    int ans = Integer.MAX_VALUE, index = -1;
    for (int i = 0; i < n; i++) {
        if (arr[i] < ans) {
            ans = arr[i];
            index = i;
        }
    }
    return index;
}

  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1)
  public static int findKRotation(int[] arr) {
    int n = arr.length;
    int low = 0, high = n - 1;
    int ans = Integer.MAX_VALUE;
    int index = -1;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      // search space is already sorted
      // then arr[low] will always be
      // the minimum in that search space:
      if (arr[low] <= arr[high]) {
        if (arr[low] < ans) {
          index = low;
          ans = arr[low];
        }
        break;
      }
      // If Left Part is sorted
      if (arr[low] <= arr[mid]) {
        // Keep the min
        if (arr[low] < ans) {
          index = low;
          ans = arr[low];
        }
        // Eliminate the left
        low = mid + 1;
      } // if right part is sorted
      else {
        // Keep the min
        high = mid - 1;
        if (arr[mid] < ans) {
          index = mid;
          ans = arr[mid];
        }
      }
    }
    return index;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
    int ans = findKRotation(arr);
    System.out.println("The array is rotated " + ans + " times.");
  }
}
