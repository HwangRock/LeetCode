import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int maxi = 0;
        int fin = nums.length;

        for (int i = 0; i < fin; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int cnt = 0;
        for (int i = 0; i < fin; i++) {
            if (nums[i] == maxi) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }

        return ans;
    }
}