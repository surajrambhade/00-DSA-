//https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse

public class DSA_02_Find_Nth_Root_Of_M {

  // Time Complexity: O(M), M = the given number.
  // Space Complexity: O(1) as we are not using any extra space.
  public static int NthRoot(int n, int m) {
    for (int i = 1; i <= m; i++) {
      long val = calculatePower(i, n);
      if (val == (long) m) {
        return i;
      } else if (val > (long) m) {
        break;
      }
    }
    return -1;
  }

  private static long calculatePower(int base, int exponent) {
    long result = 1;
    long num = base; // Initialize num with the base value

    while (exponent > 0) {
      if (exponent % 2 == 1) {
        result *= num; // Multiply result by num if exponent is odd
        exponent--; // Decrement exponent by 1
      } else {
        num *= num; // Square the num if exponent is even
        exponent /= 2; // Divide exponent by 2
      }
    }
    return result;
  }

  // Time Complexity: O(logN), N = size of the given array.
  // Space Complexity: O(1)
  public static int NthRoot1(int n, int m) {
    int low = 1, high = m;
    while (low <= high) {
      int mid = low - (low - high) / 2;
      int midN = func(mid, n, m);
      if (midN == 1) {
        return mid;
      } else if (midN == 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  // return 1 if == m
  // return 0 if < m
  // return 2 if > m
  private static int func(int mid, int n, int m) {
    long ans = 1;
    for (int i = 1; i <= n; i++) {
      ans = ans * mid;
      if (ans > m)
        return 2;
    }
    if (ans == m)
      return 1;
    return 0;
  }

  public static void main(String[] args) {
    int n = 3, m = 27;
    int ans = NthRoot1(n, m);
    System.out.println("The answer is: " + ans);
  }
}
