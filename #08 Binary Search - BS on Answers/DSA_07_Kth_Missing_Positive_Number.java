//https://www.codingninjas.com/studio/problems/kth-missing-element_893215?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_07_Kth_Missing_Positive_Number {

  // Time Complexity: O(N), N = size of the given array.
  // Space Complexity: O(1)
  public static int missingK(int[] vec, int n, int k) {
    for (int i = 0; i < n; i++) {
      if (vec[i] <= k)
        k++;// shifting k
      else
        break;
    }
    return k;
  }

  // kth missing number = vec[high] + k - (vec[high] - (high+1))
  // = vec[high] + k - vec[high] + high + 1
  // = k + high + 1.
  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1)
  public static int missingK1(int[] vec, int n, int k) {
    int low = 0, high = n - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int missing = vec[mid] - (mid + 1);
      if (missing < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return k + high + 1; //low +k; <- Also same

  }

  public static void main(String[] args) {
    int[] vec = { 4, 7, 9, 10 };
    int n = 4, k = 4;
    int ans = missingK1(vec, n, k);
    System.out.println("The missing number is: " + ans);
  }
}
