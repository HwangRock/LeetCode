class Solution {
    public int rob(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int memo[] = new int[n];
        if (n <= 2) {
            if (n == 1) {
                ans = nums[0];
            } else {
                ans = Math.max(nums[0], nums[1]);
            }
        } else {
            memo[0] = nums[0];
            memo[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                memo[i] = Math.max(memo[i - 2] + nums[i], memo[i - 1]);
            }
            ans = memo[n - 1];
        }
        return ans;
    }
}