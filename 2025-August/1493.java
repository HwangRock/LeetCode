import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int fin = nums.length;
        int bef = 0;
        int memo[] = new int[fin];

        for (int i = 0; i < fin; i++) {
            if (nums[i] == 0) {
                if (i != 0) {
                    ans = Math.max(ans, memo[i - 1] + bef);
                    bef = memo[i - 1];
                }
            } else {
                if (i == 0) {
                    memo[i] = 1;
                } else {
                    memo[i] = memo[i - 1] + 1;
                }
            }
        }
        if (nums[fin - 1] == 1) { // 마지막이 1이라서 카운트를 빼먹는 경우
            ans = Math.max(ans, memo[fin - 1] + bef);
        }

        if (ans == fin) { // 모두 1이라서 하나를 지워야 하는 경우
            ans -= 1;
        }

        return ans;
    }
}