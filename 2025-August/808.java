import java.util.*;

class Solution {
    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }

        int N = (int) Math.ceil(n / 25.0);
        Map<String, Double> memo = new HashMap<>();

        return dfs(N, N, memo);
    }

    private double dfs(int a, int b, Map<String, Double> memo) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }

        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double res = 0.25 * (
                dfs(a - 4, b, memo) +
                        dfs(a - 3, b - 1, memo) +
                        dfs(a - 2, b - 2, memo) +
                        dfs(a - 1, b - 3, memo)
        );

        memo.put(key, res);
        return res;
    }
}
