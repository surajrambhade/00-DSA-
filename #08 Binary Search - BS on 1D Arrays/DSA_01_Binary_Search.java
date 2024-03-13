//https://www.codingninjas.com/studio/problems/binary-search_972?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_01_Binary_Search {

  //time complexity is O(logN), where N = size of the given array.
  public static int search(int[] nums, int target) {

    int n = nums.length;
    int low = 0, high = n - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target)
        return mid;
      else if (target > mid) {
        low = mid + 1;
      } else
        high = mid - 1;
    }
    return -1;
  }

  // Optimal Approch tc -O(LogN)
  public static int search1(int[] nums, int target) {
    return binarySerch(nums, 0, nums.length - 1, target);
  }

  public static int binarySerch(int[] nums, int low, 
  int high, int target) {
    if (low > high)
      return -1;

    int mid = (low + high) / 2;
    if (nums[mid] == target) {
      return mid;
    } else if (target > nums[mid])
      return binarySerch(nums, mid + 1, high, target);
    return binarySerch(nums, low, mid - 1, target);
  }

  public static void main(String[] args) {
    int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
    int target = 6;
    int ind = search(a, target);
    if (ind == -1)
      System.out.println("The target is not present.");
    else
      System.out.println("The target is at index: " + ind);
  }
}
