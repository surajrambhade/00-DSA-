//https://www.codingninjas.com/studio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Arrays;

public class DSA_06_First_nd_Last_Position_of_Ele_Sort_Arr {

  // Solution 1
  public static int[] firstAndLastPosition1(ArrayList<Integer> arr, int n, int k) {
    int first = -1;
    int last = -1;
    for (int i = 0; i < n; i++) {
      if (arr.get(i) == k) {
        if (first == -1)
          first = i;
        last = i;
      }
    }
    return new int[] { first, last };
  }

  // Solution 2
  public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
    int lb = lowerBound1(arr, n, k);
    if (lb == n || arr.get(lb) != k) {
      return new int[] { -1, -1 };
    }
    int ub = upperBound1(arr, n, k);
    return new int[] { lb, ub - 1 };
  }

  public static int lowerBound1(ArrayList<Integer> arr, int n, int x) {
    int low = 0;
    int high = n - 1;
    int ans = n;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr.get(mid) >= x) {
        ans = mid;
        // look for more small on left
        high = mid - 1;
      } else {
        low = mid + 1; // look for rigt
      }
    }
    return ans;
  }

  public static int upperBound1(ArrayList<Integer> arr, int n, int x) {
    int low = 0;
    int high = n - 1;
    int ans = n;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr.get(mid) > x) {
        ans = mid;
        // look for more small on left
        high = mid - 1;
      } else {
        low = mid + 1; // look for rigt
      }
    }
    return ans;
  }

  // Solution 3
  public static int[] firstAndLastPosition2(ArrayList<Integer> arr, int n, int k) {
    int first = firstOccerence(arr, n, k);
    if (first == -1) {
      return new int[] { -1, -1 };
    }
    int last = lastOccerence(arr, n, k);
    return new int[] { first, last };
  }

  public static int firstOccerence(ArrayList<Integer> arr, int n, int k) {
    int low = 0, high = n - 1;
    int frist = -1;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (arr.get(mid) == k) {
        frist = mid;
        // look for smaller index on left
        high = mid - 1;
      }else if (arr.get(mid) >k){
        high = mid -1;
      }else{
        low = mid+1;
      }
    }
    return frist;
  }

  public static int lastOccerence(ArrayList<Integer> arr, int n, int k) {
    int low = 0, high = n - 1;
    int last = -1;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (arr.get(mid) == k) {
        last = mid;
        // look for smaller index on right
        low = mid + 1;
      }else if (arr.get(mid) >k){
        // look for smaller index on left
        high = mid -1;
      }else{
        // look for smaller index on right
        low = mid+1;
      }
    }
    return last;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] { 2, 4, 6, 8, 8, 8, 11, 13 }));
    int n = 8, k = 8;
    int[] ans = firstAndLastPosition2(arr, n, k);
    System.out.println("The first and last positions are: "
        + ans[0] + " " + ans[1]);
  }
}
