import java.util.*;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long total = 0;
        int maxLeft = 0;
        int secondMaxLeft = 0;
        long[] gain = new long[n + 1];
        List<Integer>[] conflicts = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            conflicts[i] = new ArrayList<>();
        }

        for (int[] pair : conflictingPairs) {
            int a = pair[0];
            int b = pair[1];
            int right = Math.max(a, b);
            int left = Math.min(a, b);
            conflicts[right].add(left);
        }

        for (int r = 1; r <= n; r++) {
            for (int l : conflicts[r]) {
                if (l > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = l;
                } else if (l > secondMaxLeft) {
                    secondMaxLeft = l;
                }
            }

            total += r - maxLeft;
            gain[maxLeft] += maxLeft - secondMaxLeft;
        }

        long maxGain = 0;
        for (long g : gain) {
            maxGain = Math.max(maxGain, g);
        }

        return total + maxGain;
    }
}
