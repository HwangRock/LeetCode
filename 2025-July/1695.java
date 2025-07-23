import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int fin = nums.length;
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < fin; i++) {
            int nu = nums[i];
            while (set.contains(nu)) {
                int a = q.poll();
                cur -= a;
                set.remove(a);
            }
            cur += nu;
            q.add(nu);
            set.add(nu);
            ans = Math.max(ans, cur);
        }
        
        return ans;
    }
}