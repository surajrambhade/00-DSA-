import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DSA_11_Painters_Partition_Problem {

  public static int countStudents(ArrayList<Integer> arr, int pages) {
    int n = arr.size(); // size of array
    int students = 1;
    long pagesStudent = 0;
    for (int i = 0; i < n; i++) {
      if (pagesStudent + arr.get(i) <= pages) {
        // add pages to current student
        pagesStudent += arr.get(i);
      } else {
        // add pages to next student
        students++;
        pagesStudent = arr.get(i);
      }
    }
    return students;
  }

  public static int findPages1(ArrayList<Integer> arr, int n, int m) {
    if (m > n)
      return -1;
    int low = Collections.max(arr);
    int high = arr.stream().mapToInt(Integer::intValue).sum();
    while (low <= high) {
      int mid = (low + high) / 2;
      int student = countStudents(arr, mid);
      if (student > m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
    int n = boards.size();
    return findPages1(boards, n, k);
  }

  public static void main(String[] args) {
    ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
    int k = 2;
    int ans = findLargestMinDistance(boards, k);
    System.out.println("The answer is: " + ans);
  }
}
