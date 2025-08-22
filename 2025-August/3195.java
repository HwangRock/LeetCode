import java.util.*;

class Solution {
    public int minimumArea(int[][] grid) {
        int ans = 0;
        int x1 = Integer.MAX_VALUE, x2 = -1, y1 = Integer.MAX_VALUE, y2 = -1;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (x1 > i) {
                        x1 = i;
                    }
                    if (x2 < i) {
                        x2 = i;
                    }

                    if (y1 > j) {
                        y1 = j;
                    }
                    if (y2 < j) {
                        y2 = j;
                    }
                }
            }
        }

        int dx = 0, dy = 0;
        if (x1 == x2) {
            dx = 1;
        } else {
            dx = x2 - x1 + 1;
        }

        if (y1 == y2) {
            dy = 1;
        } else {
            dy = y2 - y1 + 1;
        }

        ans = dx * dy;
        return ans;
    }
}