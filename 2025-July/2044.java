import java.util.*;

class Solution {
    static boolean visit[];

    static int btrack(int[] nums, int fin, int dpt, int maxi) {
        if (dpt == fin) {
            int cur = 0;
            for (int i = 0; i < fin; i++) {
                if (visit[i] == true) {
                    cur = cur | nums[i];
                }
            }
            if (cur == maxi) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int cur = 0;
            visit[dpt] = true;
            cur += btrack(nums, fin, dpt + 1, maxi);
            visit[dpt] = false;
            cur += btrack(nums, fin, dpt + 1, maxi);
            return cur;
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        int ans = 0;
        int fin = nums.length;
        visit = new boolean[fin];
        int maxi = 0;
        for (int i = 0; i < fin; i++) {
            maxi = maxi | nums[i];
        }
        ans = btrack(nums, fin, 0, maxi);
        return ans;
    }
}