import java.util.PriorityQueue;

public class DSA_12_Minimize_Max_Distance_to_Gas_Station {

  // Brute Approch
  // Time Complexity: O(k*n) + O(n), n = size of the given array, k = no. of gas
  // stations to be placed.
  // Space Complexity: O(n-1)
  public static double MinimiseMaxDistance(int[] arr, int K) {
    int n = arr.length;
    int[] howMAny = new int[n - 1];

    // Pick and Place k gas
    for (int gasStation = 1; gasStation <= K; gasStation++) {
      // Find the maximun section
      // and insert the gas station
      double maxSection = -1;
      int maxInd = 1;
      for (int i = 0; i < n - 1; i++) {
        double diff = arr[i + 1] - arr[i];
        ;
        double sectionLenght = diff / (double) (howMAny[i] + 1);
        if (sectionLenght > maxSection) {
          maxSection = sectionLenght;
          maxInd = i;
        }
      }
      howMAny[maxInd]++; // Insert the current gas station
    }

    // find the maximum distance
    double maxAns = -1;
    for (int i = 0; i < n - 1; i++) {
      double diff = arr[i + 1] - arr[i];
      double sectionLenght = diff / (double) (howMAny[i] + 1);
      maxAns = Math.max(maxAns, sectionLenght);
    }
    return maxAns;
  }

  // Better Approch
  // Time Complexity: O(nlogn + klogn), n = size of the given array, k = no. of
  // gas stations to be placed.
  // Space Complexity: O(n-1)+O(n-1)
  public static class Pair {
    double first;
    int second;

    Pair(double first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public static double MinimiseMaxDistance1(int[] arr, int K) {
    int n = arr.length;
    int[] howMany = new int[n - 1];
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

    // insert the first n-1 element into pq with resepective distence value
    for (int i = 0; i < n - 1; i++) {
      pq.add(new Pair(arr[i + 1] - arr[i], i));
    }

    // Pick and place k gas station
    for (int gasStation = 1; gasStation <= K; gasStation++) {
      // Find maximum section and insert the gas station
      Pair tp = pq.poll();
      int secInd = tp.second;
      // insert the current gas station
      howMany[secInd]++;
      double iniDiff = arr[secInd + 1] - arr[secInd];
      double newSecLen = iniDiff / (double) (howMany[secInd] + 1);
      pq.add(new Pair(newSecLen, secInd));
    }
    return pq.peek().first;
  }

  // Time Complexity: O(n*log(Len)) + O(n), n = size of the given array, Len =
  // length of the answer space.
  // Space Complexity: O(1)
  public static double MinimiseMaxDistance2(int[] arr, int K) {
    int n = arr.length;
    double low = 0;
    double high = 0;
    // find the max distance
    for (int i = 0; i < n - 1; i++) {
      high = Math.max(high, (double) (arr[i + 1] - arr[i]));
    }
    // Apply Binary Search
    double diff = 1e-6;
    while (high - low > diff) {
      double mid = (low + high) / 2.0;
      int cnt = noOfGasStationRequired(mid, arr);
      if (cnt > K) {
        low = mid;
      } else {
        high = mid;
      }
    }
    return high;
  }

  private static int noOfGasStationRequired(double dist, int[] arr) {
    int n = arr.length;
    int cnt = 0;
    for (int i = 1; i < n; i++) {
      int noInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
      if ((arr[i] - arr[i - 1]) == (dist * noInBetween)) {
        noInBetween--;
      }
      cnt += noInBetween;
    }
    return cnt;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int k = 4;
    double ans = MinimiseMaxDistance2(arr, k);
    System.out.println("The answer is: " + ans);
  }
}
