//https://www.codingninjas.com/studio/problems/capacity-to-ship-packages-within-d-days_1229379?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_06_Capacity_To_Ship_Packages_Within_D_Days {

  // Time Complexity: O(N * log(sum(weights[]) – max(weights[]) + 1)), where
  // sum(weights[]) = summation of all the weights, max(weights[]) = maximum of
  // all the weights, N = size of the weights array.
  // Space Complexity: O(1)
  public static int leastWeightCapacity(int[] weights, int d) {
    // Find the Max ans summation
    int maxi = Integer.MIN_VALUE, sum = 0;
    int n = weights.length;
    for (int i = 0; i < n; i++) {
      sum += weights[i];
      maxi = Math.max(maxi, weights[i]);
    }
    for (int i = maxi; i <= sum; i++) {
      if (findDays(weights, i) <= d) {
        return i;
      }
    }
    return -1;
  }

  public static int findDays(int[] weights, int cap) {
    int days = 1; // First day
    int load = 0;
    int n = weights.length;
    for (int i = 0; i < n; i++) {
      if (load + weights[i] > cap) {
        days += 1; // Move to next day
        load = weights[i];
      } else {
        load += weights[i];
      }
    }
    return days;
  }

  // Time Complexity: O(N * log(sum(weights[]) – max(weights[]) + 1)), where
  // sum(weights[]) = summation of all the weights, max(weights[]) = maximum of
  // all the weights, N = size of the weights array.
  // Space Complexity: O(1)
  public static int leastWeightCapacity1(int[] weights, int d) {
    // Find the Max ans summation
    int low = Integer.MIN_VALUE;
    int high = 0;
    for (int i = 0; i < weights.length; i++) {
      high += weights[i];
      low = Math.max(low, weights[i]);
    }
    while (low <= high) {
      int mid = low - (low - high) / 2;
      int noOfDays = findDays(weights, mid);
      if (noOfDays <= d) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[] weights = { 5, 4, 5, 2, 3, 4, 5, 6 };
    int d = 5;
    int ans = leastWeightCapacity(weights, d);
    System.out.println("The minimum capacity should be: " + ans);
  }
}
