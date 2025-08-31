import java.util.*;

class Solution {

    final int maxi = Integer.MAX_VALUE;

    public int reverse(int x) {
        int ans = 0;
        boolean change = false;
        if (x < 0) {
            change = true;
            x = -x;
        }

        while (x > 0) {
            int cur = x % 10;
            if (!change && (ans > maxi / 10 || (ans == maxi / 10 && cur > 7))) {
                return 0;
            }
            if (change && (ans > maxi / 10 || (ans == maxi / 10 && cur > 8))) {
                return 0;
            }
            ans = ans * 10 + cur;
            x = x / 10;
        }

        if (change) {
            ans = -ans;
        }
        return ans;
    }
}