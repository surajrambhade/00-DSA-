//https://www.codingninjas.com/studio/problems/find-peak-element_7449073?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_04_Find_A_Peak_Element {

  public static int[] findPeakGrid(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int low = 0, high = m - 1;
    while (low <= high) {
      int mid = (low + high) >> 1;
      int maxRowIndex = findMaxRowIndex(mat, n, m, mid);
      int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
      int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;
      if (mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right) {
        return new int[] { maxRowIndex, mid };
      } else if (mat[maxRowIndex][mid] < left) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }

    }
    return new int[] { -1, -1 };
  }

  static int findMaxRowIndex(int[][] mat, int n, int m, int col) {
    int maxValue = -1;
    int index = -1;
    for (int i = 0; i < n; i++) {
      if (mat[i][col] > maxValue) {
        maxValue = mat[i][col];
        index = i;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      { 1, 4, 7, 11, 15 },
      { 2, 5, 8, 12, 19 },
      { 3, 6, 9, 16, 22 },
      { 10, 13, 14, 17, 24 },
      { 18, 21, 23, 26, 30 }
  };

  int[] result = findPeakGrid(matrix);
  System.out.println("Peak element found at row: " + result[0] + ", column: " + result[1]);

  }
}
