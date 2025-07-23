import java.util.*;

class Solution {
    public long minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len / 3;

        long minSum[] = new long[len];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < len; i++) {
            pq1.offer(nums[i]);
            sum += nums[i];

            if (pq1.size() > n) {
                sum -= pq1.poll();
            }

            if (pq1.size() == n) {
                minSum[i] = sum;
            } else {
                minSum[i] = Long.MAX_VALUE;
            }
        }

        long maxSum[] = new long[len];
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        sum=0;

        for (int i = len - 1; i >= 0; i--) {
            pq2.offer(nums[i]);
            sum += nums[i];

            if (pq2.size() > n) {
                sum -= pq2.poll();
            }

            if (pq2.size() == n) {
                maxSum[i] = sum;
            } else {
                maxSum[i] = Long.MIN_VALUE;
            }
        }

        long answer = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (maxSum[i + 1] != Long.MIN_VALUE) {
                long diff = minSum[i] - maxSum[i + 1];
                answer = Math.min(answer, diff);
            }
        }

        return answer; 
    }
}
