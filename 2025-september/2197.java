import java.util.*;

class Solution {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Long> tmp = new ArrayList<>();
        int n = nums.length;

        tmp.add((long) nums[0]);
        int id = 0;

        for (int i = 1; i < n; i++) {
            long cur = nums[i];

            while (!tmp.isEmpty()) {
                long g = gcd(tmp.get(id), cur);
                if (g == 1) {
                    break;
                }
                long lcm = (tmp.get(id) / g) * cur;
                tmp.remove(id);
                cur = lcm;
                id--;
            }
            tmp.add(cur);
            id++;
        }

        for (int i = 0; i <= id; i++) {
            ans.add(tmp.get(i).intValue());
        }

        return ans;
    }
}
