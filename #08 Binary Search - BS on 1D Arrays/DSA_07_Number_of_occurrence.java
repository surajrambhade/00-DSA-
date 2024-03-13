//https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM


public class DSA_07_Number_of_occurrence {
  public static int[] firstAndLastPosition(int[] arr, int n, int k) {
    int first = firstOccerence(arr, n, k);
    if (first == -1) {
      return new int[] { -1, -1 };
    }
    int last = lastOccerence(arr, n, k);
    return new int[] { first, last };
  }

  public static int firstOccerence(int[] arr, int n, int k) {
    int low = 0, high = n - 1;
    int frist = -1;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (arr[mid] == k) {
        frist = mid;
        // look for smaller index on left
        high = mid - 1;
      }else if (arr[mid] >k){
        high = mid -1;
      }else{
        low = mid+1;
      }
    }
    return frist;
  }

  public static int lastOccerence(int[] arr, int n, int k) {
    int low = 0, high = n - 1;
    int last = -1;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      if (arr[mid] == k) {
        last = mid;
        // look for smaller index on right
        low = mid + 1;
      }else if (arr[mid] >k){
        // look for smaller index on left
        high = mid -1;
      }else{
        // look for smaller index on right
        low = mid+1;
      }
    }
    return last;
  }
  public static int count(int arr[], int n, int x) {
        int[] ans = firstAndLastPosition(arr, n, x);
        if (ans[0] == -1) {
          return 0;
        }
        return ans[1] - ans[0] +1;
  }
  public static void main(String[] args) {
    int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
    int n = 8, x = 8;
    int ans = count(arr, n, x);
    System.out.println("The number of occurrences is: " + ans);
  }
}
