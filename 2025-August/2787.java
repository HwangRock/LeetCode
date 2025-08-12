import java.util.*;

import java.util.*;

class Solution {

    static int[][] memo;
    static int mod = 1_000_000_007;
    static int limit;

    static int recur(int a, int x, int i) {
        if (a == 0) {
            return 1;
        }
        if (i > limit) {
            return 0;
        }
        if (memo[a][i] != -1) {
            return memo[a][i];
        }

        int p = (int) Math.pow(i, x);
        if (p > a) {
            return 0;
        }

        long cur = 0;
        cur += recur(a, x, i + 1);
        cur += recur(a - p, x, i + 1);

        memo[a][i] = (int) (cur % mod);
        return memo[a][i];
    }

    public int numberOfWays(int n, int x) {
        limit = (int) Math.ceil(Math.pow(n, 1.0 / x));

        memo = new int[n + 1][limit + 2];
        for (int r = 0; r <= n; r++) {
            Arrays.fill(memo[r], -1);
        }

        return recur(n, x, 1);
    }
}
