//https://www.codingninjas.com/studio/problems/k-th-element-of-2-sorted-array_1164159?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class DSA_14_K_th_Element_of_Two_Sorted_Arrays {

  // Time Complexity : log(min(m,n))
  // Space Complexity: O(1)
  public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n1, int n2, int k) {
    if (n1 > n2) {
      return kthElement(arr2, arr1, n2, n1, k);
    }

    int low = Math.max(0, k - n2);
    int high = Math.min(k, n1);

    while (low <= high) {
      int mid1 = (low + high) >> 1;
      int mid2 = k - mid1;

      int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
      int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

      if (mid1 < n1)
        r1 = arr1.get(mid1);
      if (mid2 < n2)
        r2 = arr2.get(mid2);

      if (mid1 - 1 >= 0)
        l1 = arr1.get(mid1 - 1);
      if (mid2 - 1 >= 0)
        l2 = arr2.get(mid2 - 1);

      if (l1 <= r2 && l2 <= r1) {
        return Math.max(l1, l2);
      } else if (l1 > r2) {
        high = mid1 - 1;
      } else {
        low = mid1 + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // List<Integer> array1 = Arrays.asList(2, 3, 6, 7, 9);
    // List<Integer> array2 = Arrays.asList(1, 4, 8, 10);
    ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
    ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 4, 8, 10));
    int m = array1.size();
    int n = array2.size();
    int k = 5;
    System.out
        .println("The element at the kth position in the final sorted array is " + kthElement(array1, array2, m, n, k));
  }
}
