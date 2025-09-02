import java.util.*;

class Solution {

    static int sorting(int a[], int b[]) {
        if (a[1] != b[1]) {
            return b[1] - a[1];
        }
        return a[0] - b[0];
    }

    static boolean check(int x1, int y1, int x2, int y2) {
        if (y1 >= y2 && x1 <= x2) {
            return true;
        }
        return false;
    }

    static boolean inside(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((x1 <= x3 && y1 >= y3) && (x3 <= x2 && y3 >= y2)) {
            return true;
        }
        return false;
    }

    public int numberOfPairs(int[][] points) {
        int ans = 0;
        int fin = points.length;
        Arrays.sort(points, Solution::sorting);

        for (int a = 0; a < fin; a++) {
            int x1 = points[a][0];
            int y1 = points[a][1];
            for (int b = a + 1; b < fin; b++) {
                int x2 = points[b][0];
                int y2 = points[b][1];
                if (check(x1, y1, x2, y2)) {
                    boolean able = true;
                    for (int i = a + 1; i < b; i++) {
                        int x3 = points[i][0];
                        int y3 = points[i][1];
                        if (inside(x1, y1, x2, y2, x3, y3)) {
                            able = false;
                            break;
                        }
                    }
                    if (able) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}