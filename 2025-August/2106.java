import java.util.*;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int n = fruits.length;
        int[] pos = new int[n];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }

        for (int l = 0; l < n; l++) {
            int left = pos[l];
            if (left > startPos + k) {
                break;
            }

            int lo = l;
            int hi = n - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int right = pos[mid];

                int d1 = Math.abs(startPos - left) + (right - left);
                int d2 = Math.abs(startPos - right) + (right - left);
                int minSteps = Math.min(d1, d2);

                if (minSteps <= k) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            int sum = prefix[hi + 1] - prefix[l];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
