import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    private int modPow(long a, long e, int mod) {
        long res = 1, base = a % mod;
        while (e > 0) {
            if ((e & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            e >>= 1;
        }
        return (int) res;
    }

    public int[] productQueries(int n, int[][] queries) {

        java.util.ArrayList<Integer> exp = new java.util.ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                exp.add(i);
            }
        }

        int m = exp.size();
        long[] pref = new long[m + 1];
        for (int i = 0; i < m; i++) {
            pref[i + 1] = pref[i] + exp.get(i);
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            long sumExp = pref[r + 1] - pref[l];
            ans[i] = modPow(2, sumExp, MOD);
        }
        return ans;
    }
}
