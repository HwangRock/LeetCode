import java.util.*;

class Solution {

    static long calculateSum(List<Integer> nums) {
        long ans = 0;

        int fin = nums.size();
        for (int i = 0; i < fin; i++) {
            long cur = (long) nums.get(i);
            ans = ans + cur * (cur + 1) / 2;
        }

        return ans;
    }

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int fin = nums.length;
        int seq = 0;
        List<Integer> inp = new ArrayList<>();
        for (int i = 0; i < fin; i++) {
            if (nums[i] == 0) {
                seq++;
            } else {
                if (seq > 0) {
                    inp.add(seq);
                    seq = 0;
                }
            }
        }
        if (seq > 0) {
            inp.add(seq);
        }
        ans = calculateSum(inp);
        return ans;
    }
}