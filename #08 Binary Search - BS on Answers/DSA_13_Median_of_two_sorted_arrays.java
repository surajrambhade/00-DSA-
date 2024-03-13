//https://www.codingninjas.com/studio/problems/median-of-two-sorted-arrays_985294?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.List;

public class DSA_13_Median_of_two_sorted_arrays {

  // Brute Approch
  // Time Complexity: O(n1+n2), where n1 and n2 are the sizes of the given arrays.
  // Space Complexity: O(n1+n2), where n1 and n2 are the sizes of the given
  // arrays.
  public static double median(int[] a, int[] b) {
    int n1 = a.length;
    int n2 = b.length;
    List<Integer> arr3 = new ArrayList<>();
    // Apply merge sort step
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (a[i] < b[j]) {
        arr3.add(a[i++]);
      } else {
        arr3.add(b[j++]);
      }
    }
    while (i < n1) {
      arr3.add(a[i++]);
    }
    while (j < n2) {
      arr3.add(b[j++]);
    }

    // Find the median
    int n = n1 + n2;
    if (n % 2 == 1) {
      return (double) arr3.get(n / 2);
    }
    double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
    return median;
  }

  // Better Approch
  // Time Complexity: O(n1+n2), where n1 and n2 are the sizes of the given arrays.
  // Space Complexity: O(1)
  public static double median1(int[] a, int[] b) {
    int n1 = a.length;
    int n2 = b.length;
    int n = n1 + n2;
    // Required Index
    int ind2 = n / 2;
    int ind1 = ind2 - 1;
    int cnt = 0;
    int ind1e1 = -1, ind2e1 = -1;
    // apply the merge step
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (a[i] < b[j]) {
        if (cnt == ind1)
          ind1e1 = a[i];
        if (cnt == ind2)
          ind2e1 = a[i];
        cnt++;
        i++;
      } else {
        if (cnt == ind1)
          ind1e1 = b[j];
        if (cnt == ind2)
          ind2e1 = b[j];
        cnt++;
        j++;
      }
    }
    while (i < n1) {
      if (cnt == ind1)
        ind1e1 = a[i];
      if (cnt == ind2)
        ind2e1 = a[i];
      cnt++;
      i++;
    }
    while (j < n2) {
      if (cnt == ind1)
        ind1e1 = b[j];
      if (cnt == ind2)
        ind2e1 = b[j];
      cnt++;
      j++;
    }
    if (n % 2 == 1)
      return (double) ind2e1;
    return (double) ((double) (ind1e1 + ind2e1)) / 2.0;
  }

  // Time Complexity: O(log(min(n1,n2))), where n1 and n2 are the sizes of two
  // given arrays.
  // Space Complexity: O(1) as no extra space is used.
  public static double median2(int[] a, int[] b) {
    int n1 = a.length, n2 = b.length;
    // If n1 is bigger swap the arrays
    if (n1 > n2)
      return median2(b, a);
    int n = n1 + n2;
    int left = (n1 + n2 + 1) / 2; // lenght of left half

    int low = 0, high = n1;
    while (low <= high) {
      int mid1 = (low + high) >> 1;
      int mid2 = left - mid1;
      // Calculate l1,l2,r1 and r2;
      int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
      int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
      int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
      int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1) {
        if (n % 2 == 1)
          return Math.max(l1, l2);
        else
          return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
      } else if (l1 > l2)
        high = mid1 - 1;
      else
        low = mid1 + 1;
    }
    return 0;
  }

  // Same Code
  public static double median3(int[] a, int[] b) {
    int n1 = a.length;
    int n2 = b.length;

    // If the length of array a is greater than the length of array b,
    // swap the arrays to ensure that array a is smaller or equal in size
    if (n1 > n2)
      return median(b, a); // Call median function with arrays swapped

    int n = n1 + n2; // Total length of the combined arrays
    int left = (n1 + n2 + 1) / 2; // Index to partition the combined arrays into two parts
    int low = 0, high = n1; // Initialize low and high pointers for binary search

    // Binary search to find the correct partition point
    while (low <= high) {
      int mid1 = (low + high) >> 1; // Calculate mid point of array a
      int mid2 = left - mid1; // Calculate mid point of array b based on mid1

      // Initialize variables to store values to the left and right of mid points
      int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
      int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

      // Update values if mid points are within array bounds
      if (mid1 < n1)
        r1 = a[mid1];
      if (mid2 < n2)
        r2 = b[mid2];
      if (mid1 - 1 >= 0)
        l1 = a[mid1 - 1];
      if (mid2 - 1 >= 0)
        l2 = b[mid2 - 1];

      // Check if the partition is correct
      if (l1 <= r2 && l2 <= r1) {
        // If the total number of elements is odd, return the maximum of left partitions
        if (n % 2 == 1)
          return Math.max(l1, l2);
        // If the total number of elements is even, return the average of the maximum of
        // left and minimum of right
        else
          return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
      } else if (l1 > r2) {
        // If l1 is greater than r2, move towards left of array a
        high = mid1 - 1;
      } else {
        // If l2 is greater than r1, move towards right of array a
        low = mid1 + 1;
      }
    }
    return 0; // Return 0 if arrays are empty or no median found
  }

  public static void main(String[] args) {
    int[] a = { 1, 4, 7, 10, 12 };
    int[] b = { 2, 3, 6, 15 };
    System.out.println("The Median of the two sorted Arrays is  " + median3(a, b));
  }
}
