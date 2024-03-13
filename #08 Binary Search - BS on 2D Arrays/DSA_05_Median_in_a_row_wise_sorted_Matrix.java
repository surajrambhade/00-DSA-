//https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_05_Median_in_a_row_wise_sorted_Matrix {

  // Brute Approch
  // Time Complexity: O(row*col log(row*col)) for sorting the array where r*c
  // denotes the number of elements in the linear array.
  // Space Complexity: O(row*col) for storing elements in the linear array
  public static int findMedian(int matrix[][], int row, int col) {
    int[] median = new int[row * col];
    int index = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        median[index] = matrix[i][j];
        index++;
      }
    }
    return median[(row * col) / 2];
  }

  // Optimal Approch
  // Time Complexity: O(row*log col) since the upper bound function takes log c
  // time.
  // Space Complexity: O(1) since no extra space is required.
  public static int findMedian1(int matrix[][], int row, int col) {
    int low = Integer.MIN_VALUE;
    int high = col-1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      int cnt = 0;
      for (int i = 0; i < row; i++) {
        cnt += countSmallerThanMid(matrix[i], mid, col);
      }
      if (cnt <= (row * col) / 2)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return low;
  }

  private static int countSmallerThanMid(int[] a, int mid, int col) {
    int low = 0, high = col - 1;
    while (low <= high) {
      int md = (low + high) >> 1;
      if (a[md] <= mid) {
        low = md + 1;
      } else {
        high = md - 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[][] arr = { { 1, 3, 8 },
        { 2, 3, 4 },
        { 1, 2, 5 } };

    int row = 3, col = 3;
    System.out.println("The median of the row-wise sorted matrix is: " +
        findMedian1(arr, row, col));
  }
}
