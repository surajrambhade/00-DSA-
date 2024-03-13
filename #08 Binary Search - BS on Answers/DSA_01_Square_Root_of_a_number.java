//https://www.codingninjas.com/studio/problems/square-root-integral_893351?leftPanelTab=0%3Futm_source%3Dstriver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_01_Square_Root_of_a_number {

  // Time Complexity: O(N), N = the given number.
  // Space Complexity: O(1) as we are not using any extra space.
  public static int sqrtN(long N) {
    int ans = 0;
    for (long i = 0; i <= N; i++) {
      long val = i * i;
      if (val <= (long) N) {
        ans = (int) i;
      } else {
        break;
      }
    }
    return ans;
  }

  // Optimal Approch 1
  // Time Complexity: O(N), N = size of the given array.
  // Space Complexity: O(1)
  public static int sqrtN1(long N) {
    int ans = (int) Math.sqrt(N);
    return ans;
  }

  // Optimal Approch 2
  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1)
  public static int sqrtN2(long N) {
    long low = 1,high  = N;
    //int ans = 1;
    while (low <= high) {
      long mid = low - (low - high)/2;
      //long val = mid * mid;
      if (mid * mid <= N) {
        //ans = (int) mid;
        low = mid+1;
      }else{
        high = mid-1;
      }
    }
    return (int)high;
  }

  public static void main(String[] args) {
    int n = 28;
    int ans = sqrtN(n);
    System.out.println("The floor of square root of " + n + " is: " + ans);
  }
}
