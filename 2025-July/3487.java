import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        HashSet<Integer> h = new HashSet<>();
        int fin = nums.length;
        for (int i = 0; i < fin; i++) {
            h.clear();
            int cur = 0;
            for (int j = i; j < fin; j++) {
                if (h.contains(nums[j])) {
                    continue;
                }
                if (cur == 0 || cur + nums[j] > cur) {
                    cur += nums[j];
                    h.add(nums[j]);
                }
                ans = Math.max(ans, cur);
            }
        }

        return ans;
    }
}