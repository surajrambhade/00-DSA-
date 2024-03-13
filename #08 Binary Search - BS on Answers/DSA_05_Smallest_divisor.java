//https://www.codingninjas.com/studio/problems/smallest-divisor-with-the-given-limit_1755882?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_05_Smallest_divisor {

  // Time Complexity: O(max(arr[])*N), where max(arr[]) = maximum element in the
  // array, N = size of the array
  // Space Complexity: O(1)
  public static int smallestDivisor(int arr[], int limit) {
    int n = arr.length;
    int maxi = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      maxi = Math.max(maxi, arr[i]);
    }

    for (int d = 1; d <= maxi; d++) {
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += Math.ceil((double) arr[i] / (double) d);
      }
      if (sum <= limit)
        return d;
    }
    return -1;
  }

  // Time Complexity: O(log(max(arr[]))*N), where max(arr[]) = maximum element in
  // the array, N = size of the array.
  // Space Complexity: O(1)
  public static int smallestDivisor1(int arr[], int limit) {
    int n = arr.length;
    if (n > limit)
      return -1;
    int maxi = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxi = Math.max(maxi, arr[i]);
    }
    int low = 1, high = maxi;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (sumByD(arr, mid) <= limit) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static int sumByD(int[] arr, int div) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += Math.ceil((double) arr[i] / (double) div);
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int limit = 8;
    int ans = smallestDivisor1(arr, limit);
    System.out.println("The minimum divisor is: " + ans);
  }
}
