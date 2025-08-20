import java.util.*;

class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int memo[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        memo[i][j] = 1;
                    } else {
                        int m1 = Math.min(memo[i - 1][j], memo[i][j - 1]);
                        memo[i][j] = Math.min(memo[i - 1][j - 1], m1) + 1;
                    }
                }
                ans += memo[i][j];
            }
        }
        return ans;
    }
}