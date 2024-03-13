//https://www.codingninjas.com/studio/problems/allocate-books_1090540?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DSA_09_Allocate_Books {

  // Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the
  // array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all
  // array elements.
  // Space Complexity: O(1)
  public static int findPages(ArrayList<Integer> arr, int n, int m) {
    // book allocation impossible
    if (m > n)
      return -1;
    int low = Collections.max(arr);
    int high = arr.stream().mapToInt(Integer::intValue).sum();
    for (int pages = low; pages <= high; pages++) {
      if (countStudents(arr, pages) == m) { 
        return pages;
      }
    }
    return low;
  }

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

  // Time Complexity: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the
  // array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all
  // array elements.
  // Space Complexity: O(1)
  public static int findPages1(ArrayList<Integer> arr, int n, int m) {
    if (m > n)
      return -1;
    int low = Collections.max(arr);
    int high = arr.stream().mapToInt(Integer::intValue).sum();
    while (low <= high) {
      int mid = (low+high)/2;
      int student = countStudents(arr, mid);
      if (student > m) {
        low = mid+1;
      }else{
        high = mid-1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
    int n = 5;
    int m = 4;
    int ans = findPages1(arr, n, m);
    System.out.println("The answer is: " + ans);
  }
}
