//https://www.codingninjas.com/studio/problems/largest-subarray-sum-minimized_7461751?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_10_Largest_Subarray_Sum_Minimized {

  // Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the
  // array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all
  // array elements.
  // Space Complexity: O(1)
  public static int largestSubarraySumMinimized1(int[] a, int k) {
    int low = a[0];
    int high = 0;
    // find maximum and summation:
    for (int i = 0; i < a.length; i++) {
      low = Math.max(low, a[i]);
      high += a[i];
    }

    for (int maxSum = low; maxSum <= high; maxSum++) {
      if (countPartitions(a, maxSum) == k)
        return maxSum;
    }
    return low;
  }

  // Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the
  // array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all
  // array elements.
  // Space Complexity: O(1)
  public static int largestSubarraySumMinimized(int[] a, int k) {
    int n = a.length;
    int low = Integer.MIN_VALUE;
    int high = 0;
    // Find Ma Summation
    for (int i = 0; i < n; i++) {
      low = Math.max(low, a[i]);
      high += a[i];
    }

    while (low <= high) {
      int mid = low - (low - high) / 2;
      int partitions = countPartitions(a, mid);
      if (partitions > k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private static int countPartitions(int[] a, int maxSum) {
    int n = a.length;
    int partitions = 1;
    int subarraySum = 0;
    for (int i = 0; i < n; i++) {
      if (subarraySum + a[i] <= maxSum) {
        subarraySum += a[i];
      } else {
        partitions++;
        subarraySum = a[i];
      }
    }
    return partitions;
  }

  public static void main(String[] args) {
    int[] a = { 10, 20, 30, 40 };
    int k = 2;
    int ans = largestSubarraySumMinimized(a, k);
    System.out.println("The answer is: " + ans);
  }
}
