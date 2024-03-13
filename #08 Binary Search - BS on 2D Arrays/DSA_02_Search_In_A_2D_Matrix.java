//https://www.codingninjas.com/studio/problems/search-in-a-2d-matrix_980531?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Arrays;

public class DSA_02_Search_In_A_2D_Matrix {

  // Brute Approch
  // Time Complexity: O(N X M), where N = given row number, M = given column
  // number.
  // Space Complexity: O(1)
  static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
    int n = mat.size(), m = mat.get(0).size();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat.get(i).get(j) == target)
          return true;
      }
    }
    return false;
  }

  // Better Approch
  // Time Complexity: O(N + logM), where N = given row number, M = given column
  // number.
  // Space Complexity: O(1) as we are not using any extra space.
  static boolean searchMatrix1(ArrayList<ArrayList<Integer>> mat, int target) {
    int n = mat.size(), m = mat.get(0).size();

    for (int i = 0; i < n; i++) {
      if (mat.get(i).get(0) <= target && target <= mat.get(i).get(m - 1))
        return binarySearch(mat.get(i), target);
    }
    return false;
  }

  private static boolean binarySearch(ArrayList<Integer> nums, int target) {
    int n = nums.size();
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums.get(mid) == target)
        return true;
      else if (nums.get(mid) < target)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return false;
  }

  // Optimal Approch
  // Time Complexity: O(log(NxM)), where N = given row number, M = given column
  // number.
  // Space Complexity: O(1) as we are not using any extra space.
  static boolean searchMatrix2(ArrayList<ArrayList<Integer>> mat, int target) {
    int n = mat.size(), m = mat.get(0).size();
    int low = 0, high = n * m - 1;

    while (low <= high) {
      int mid = (low + high) >> 1;
      int row = mid / m, col = mid % m;
      if (mat.get(row).get(col) == target)
        return true;
      else if (mat.get(row).get(col) < target)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
    matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
    matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));
    boolean result = searchMatrix2(matrix, 8);
    System.out.println(result ? "true" : "false");
  }
}
