import java.util.*;

class Solution {
    private static final double TARGET = 24.0;
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        java.util.List<Double> nums = new java.util.ArrayList<>(4);
        for (int x : cards)
            nums.add((double) x);
        return dfs(nums);
    }

    private boolean dfs(java.util.List<Double> nums) {
        int n = nums.size();
        if (n == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPS;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i), b = nums.get(j);

                java.util.List<Double> rest = new java.util.ArrayList<>(n - 1);
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j)
                        rest.add(nums.get(k));
                }

                double[] candidates = new double[] {
                        a + b,
                        a - b,
                        b - a,
                        a * b,
                        Math.abs(b) < EPS ? Double.NaN : a / b,
                        Math.abs(a) < EPS ? Double.NaN : b / a
                };

                for (double val : candidates) {
                    if (Double.isNaN(val))
                        continue;
                    rest.add(val);
                    if (dfs(rest))
                        return true;
                    rest.remove(rest.size() - 1);
                }
            }
        }
        return false;
    }
}
