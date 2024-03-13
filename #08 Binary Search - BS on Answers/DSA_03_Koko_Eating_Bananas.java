//https://www.codingninjas.com/studio/problems/minimum-rate-to-eat-bananas_7449064?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class DSA_03_Koko_Eating_Bananas {

  // Time Complexity: O(max(a[]) * N), where max(a[]) is the maximum element in
  // the array and N = size of the array.
  // Space Complexity: O(1) as we are not using any extra space to solve this
  // problem.
  public static int minimumRateToEatBananas(int[] v, int h) {
    int maxi = findMax(v);
    for (int i = 1; i <= maxi; i++) {
      int reqTime = calTotalHours(v, i);
      if (reqTime <= h) {
        return i;
      }
    }
    // return dummy statement
    return maxi;
  }

  public static int findMax(int[] v) {
    int n = v.length;
    int maxi = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxi = Math.max(maxi, v[i]);
    }
    return maxi;
  }

  public static int calTotalHours(int[] v, int hourly) {
    int n = v.length;
    int toralHours = 0;
    for (int i = 0; i < n; i++) {
      toralHours += Math.ceil((double) v[i] / (double) hourly);
    }
    return toralHours;
  }

  // Time Complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element
  // in the array and N = size of the array.
  // Space Complexity: O(1)
  public static int minimumRateToEatBananas1(int[] v, int h) {
    int low =1, high = findMax(v);
    //int ans =Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low - (low-high)/2;
      int totlaHour= calTotalHours(v, mid);
      if (totlaHour <=h) {
        high = mid -1;
      }
      else{
        low = mid +1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[] v = { 7, 15, 6, 3 };
    int h = 8;
    int ans = minimumRateToEatBananas1(v, h);
    System.out.println("Koko should eat at least " + ans + " bananas/hr.");
  }
}
