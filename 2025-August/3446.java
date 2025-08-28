import java.util.*;

class Solution {

    static int[] reverseSort(int[] arr) {
        int n = arr.length;
        int a[] = new int[n];
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            a[n - i - 1] = arr[i];
        }
        return a;
    }

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int ans[][] = new int[n][n];

        for (int i = n - 1; i >= 0; i--) { // 오른쪽 위 삼각형
            int fin = n - i;
            int cur[] = new int[fin];
            int x = i, y = 0;
            for (int j = 0; j < fin; j++) {
                cur[j] = grid[y][x];
                y++;
                x++;
            }
            Arrays.sort(cur);
            x = i;
            y = 0;
            for (int j = 0; j < fin; j++) {
                ans[y][x] = cur[j];
                y++;
                x++;
            }
        }
        for (int i = n - 1; i >= 0; i--) { // 왼쪽 아래 삼각형
            int fin = n - i;
            int cur[] = new int[fin];
            int y = i, x = 0;
            for (int j = 0; j < fin; j++) {
                cur[j] = grid[y][x];
                y++;
                x++;
            }
            cur = reverseSort(cur);
            y = i;
            x = 0;
            for (int j = 0; j < fin; j++) {
                ans[y][x] = cur[j];
                y++;
                x++;
            }
        }

        return ans;
    }
}