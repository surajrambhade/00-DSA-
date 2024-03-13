//https://www.codingninjas.com/studio/problems/rose-garden_2248080?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_04_Rose_Garden {

  // Time Complexity: O((max(arr[])-min(arr[])+1) * N), where {max(arr[]) ->
  // maximum element of the array, min(arr[]) -> minimum element of the array, N =
  // size of the array}.
  // Space Complexity: O(1)
  public static int roseGarden(int[] arr, int k, int m) {
    long val = (long) k * m;
    int n = arr.length;
    if (val > n)
      return -1;
    // find max and min
    int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      mini = Math.min(mini, arr[i]);
      maxi = Math.max(maxi, arr[i]);
    }
    for (int i = mini; i <= maxi; i++) {
      if (possible(arr, i, m, k)) {
        return i;
      }
    }
    return -1;
  }

  public static boolean possible(int[] arr, int day, int m, int k) {
    int n = arr.length;
    int cnt = 0;
    int noOfB = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] <= day) {
        cnt++;
      } else {
        noOfB += (cnt / k);
        cnt = 0;
      }
    }
    noOfB += (cnt / k);
    return noOfB >= m;
  }

  // Time Complexity: O(log(max(arr[])-min(arr[])+1) * N), where {max(arr[]) ->
  // maximum element of the array, min(arr[]) -> minimum element of the array, N =
  // size of the array}.
  // Space Complexity: O(1)
  public static int roseGarden1(int[] arr, int k, int m) {
    long val = (long) k * m;
    int n = arr.length;
    if (val > n)
      return -1;
    int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      mini = Math.min(mini, arr[i]);
      maxi = Math.max(maxi, arr[i]);
    }

    // Applying Binary Search
    int low = mini, high = maxi;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (possible(arr, mid, m, k)) {
        high = mid-1;
      }else{
        low = mid +1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[] arr = { 7, 7, 7, 7, 13, 11, 12, 7 };
    int k = 3;
    int m = 2;
    int ans = roseGarden1(arr, k, m);
    if (ans == -1)
      System.out.println("We cannot make m bouquets.");
    else
      System.out.println("We can make bouquets on day " + ans);
  }
}
