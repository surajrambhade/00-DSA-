public class DSA_04_Search_Insert_Position {

  // Time Complexity: O(N), where N = size of the given array.
  // Space Complexity: O(1) as we are using no extra space.
  public static int searchInsert(int[] arr, int x) {
    int n = arr.length;
    int low = 0, high = n - 1;
    int ans = n;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] >= x) {
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
    int x = 9;
    int ind = searchInsert(arr, x);
    System.out.println("Lower Bound in the Index " + ind);
  }
}
