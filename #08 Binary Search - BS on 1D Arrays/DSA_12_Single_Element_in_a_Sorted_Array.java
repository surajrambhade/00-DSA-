//https://www.codingninjas.com/studio/problems/unique-element-in-sorted-array_1112654?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Arrays;

public class DSA_12_Single_Element_in_a_Sorted_Array {

  // Time Complexity: O(N), N = size of the given array.
  // Space Complexity: O(1) as we are not using any extra space.
  public static int singleNonDuplicate(ArrayList<Integer> arr) {
    int n = arr.size();
    if (n == 1)
      return arr.get(0);

    for (int i = 0; i < n; i++) {
      // Check for first index
      if (i == 0) {
        if (!arr.get(i).equals(arr.get(i + 1)))
          return arr.get(i);
      } else if (i == n - 1) {
        if (!arr.get(i).equals(arr.get(i - 1)))
          return arr.get(i);
      } else {
        if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1)))
          return arr.get(i);
      }
    }
    return -1;
  }

  public static int singleNonDuplicate1(ArrayList<Integer> arr) {
    int n = arr.size(); // size of the array.
    int ans = 0;
    // XOR all the elements:
    for (int i = 0; i < n; i++) {
      ans = ans ^ arr.get(i);
    }
    return ans;
  }

  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1) as we are not using any extra space.
  // If the current index is even, the element at the next odd index will be the
  // same as the current element.
  // If the current index is odd, the element at the preceding even index will be
  // the same as the current element.
  // Index -(Even, Odd) -> Element is on right half, Eleminate left
  // INdex -(Odd,Even) -> Element is on left half, Eleminate Right
  public static int singleNonDuplicate2(ArrayList<Integer> arr) {
    int n = arr.size();
    // Edge cases:
    if (n == 1)
      return arr.get(0);
    if (arr.get(0) != arr.get(1))
      return arr.get(0);
    if (arr.get(n - 1) != arr.get(n - 2))
      return arr.get(n - 1);

    int low = 1, high = n - 2;
    while (low <= high) {
      int mid = low + (high - low)/2;
      // If arr[mid] is the single element:
      if (arr.get(mid) != arr.get(mid + 1) && arr.get(mid) != arr.get(mid - 1)) {
        return arr.get(mid);
      }
      // We are in the left:
      if ((mid % 2 == 1 && arr.get(mid) == arr.get(mid - 1)) ||
          (mid % 2 == 0 && arr.get(mid) == arr.get(mid + 1))) {
        // Eliminate the left half:
        low = mid + 1;
      } else {
        // We are in the right:
        // Eliminate the right half:
        high = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));
    int ans = singleNonDuplicate2(arr);
    System.out.println("The single element is: " + ans);
  }
}
