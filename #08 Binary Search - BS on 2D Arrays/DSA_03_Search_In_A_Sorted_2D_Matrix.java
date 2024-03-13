//https://www.codingninjas.com/studio/problems/search-in-a-sorted-2d-matrix_6917532?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_03_Search_In_A_Sorted_2D_Matrix {

  // Time Complexity: O(N X M), where N = given row number, M = given column
  // number.
  // Space Complexity: O(1) as we are not using any extra space.
  public static boolean searchElement(int[][] MATRIX, int target) {
    int n = MATRIX.length, m = MATRIX[0].length;
    // traverse the matrix:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (MATRIX[i][j] == target)
          return true;
      }
    }
    return false;
  }

  // Time Complexity: O(N*logM), where N = given row number, M = given column
  // number.
  // Space Complexity: O(1) as we are not using any extra space.
  public static boolean searchElement1(int[][] MATRIX, int target) {
    int n = MATRIX.length;
    // int m = MATRIX[0].length;

    for (int i = 0; i < n; i++) {
      boolean flag = binarySearch(MATRIX[i], target);
      if (flag == true)
        return true;
    }
    return false;
  }

  public static boolean binarySearch(int[] nums, int target) {
    int n = nums.length; // size of the array
    int low = 0, high = n - 1;

    // Perform the steps:
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target)
        return true;
      else if (target > nums[mid])
        low = mid + 1;
      else
        high = mid - 1;
    }
    return false;
  }

  // Time Complexity: O(N+M), where N = given row number, M = given column number.
  // Space Complexity: O(1) as we are not using any extra space.
  public static boolean searchElement2(int[][] MATRIX, int target) {
    int n = MATRIX.length;
    int m = MATRIX[0].length;
    int row = 0, col = m - 1;

    // traverse the matrix from (0, m-1):
    while (row < n && col >= 0) {
      if (MATRIX[row][col] == target)
        return true;
      else if (MATRIX[row][col] < target)
        row++;
      else
        col--;
    }
    return false;
  }

  //
  public static int[] searchElement3(int[][] MATRIX, int target) {
    int n = MATRIX.length;
    int m = MATRIX[0].length;
    int row = 0, col = m - 1;
    // traverse the matrix from (0, m-1):
    while (row < n && col >= 0) {
      if (MATRIX[row][col] == target)
        return new int[]{row,col};
      else if (MATRIX[row][col] < target)
        row++;
      else
        col--;
    }
    return new int[]{-1,-1};
  }

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 4, 7, 11, 15 },
        { 2, 5, 8, 12, 19 },
        { 3, 6, 9, 16, 22 },
        { 10, 13, 14, 17, 24 },
        { 18, 21, 23, 26, 30 }
    };

    int[] result = searchElement3(matrix, 30);
   // System.out.println(result ? "true" : "false");
    System.out.println("For the result of target: " + result[0] + ", " + result[1]);

    boolean result1 = searchElement(matrix, 8);
    System.out.println(result1 ? "true" : "false");
  }
}
