//https://www.codingninjas.com/studio/problems/row-of-a-matrix-with-maximum-ones_982768?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;;

public class DSA_01_Row_with_max_1s {
  // Brute Approch
  // Time Complexity: O(n X m)
  // Space Complexity: O(1)
  public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
    int cnt_Max = 0;
    int index = -1;
    // Travers the matrix
    for (int i = 0; i < n; i++) {
      int cnt_Ones = 0;
      for (int j = 0; j < m; j++) {
        cnt_Ones += matrix.get(i).get(j);
      }
      if (cnt_Ones > cnt_Max) {
        cnt_Max = cnt_Ones;
        index = i;
      }
    }
    return index;
  }

  // Optimal Approch
  // Time Complexity: O(n X logm), where n = given row number, m = given column
  // number.
  // Space Complexity: O(1) as we are not using any extra space.
  public static int maximumOnesRow1(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
    int cnt_Max = 0;
    int index = -1;
    // Travers the matrix
    for (int i = 0; i < n; i++) {
      int cntOnes = m - firstOccerence(matrix.get(i), m, 1);
      if (cntOnes > cnt_Max) {
        cnt_Max = cntOnes;
        index = i;
      }
    }
    return index;
  }

  public static int firstOccerence(ArrayList<Integer> arr, int n, int k) {
    int low = 0, high = n - 1;
    int frist = n; // Hypothitically Initialize first occurrence to be at the end of the array
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (arr.get(mid) >= k) {
        frist = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return frist;
  }

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
    matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
    int n = 3, m = 3;
    System.out.println("The Row With Maximun Number Of 1's is: " + maximumOnesRow(matrix, n, m));
  }
}
