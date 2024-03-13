//https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

//Smallest index such that arr[index] > n
public class DSA_03_Implement_Upper_Bound {
  // Time Complexity: O(N), where N = size of the given array.
  // Space Complexity: O(1) as we are using no extra space.
  public static int upperBound(int[] arr, int n, int x) {
    for (int i = 0; i < n; i++) {
      if (arr[i] >= x)
        return i;
    }
    return n;
  }

  // Time Complexity: O(N), where N = size of the given array.
  // Space Complexity: O(1) as we are using no extra space.
  public static int upperBound1(int[] arr, int x, int n) {
    int low = 0, high = n - 1;
    int ans = n;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] > x) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}

  public static void main(String[] args) {
    int[] arr = { 3, 5, 8, 15, 19 };
    int n = arr.length;
    int x = 9;
    int ind = upperBound(arr, n, x);
    System.out.println("Lower Bound in the Index " + ind);
  }
}
