import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[] = new int[m * n];
        int i = 0;
        int j = 0;
        int seq = 0;

        while (seq < n * m) {
            while (true) {
                ans[seq] = mat[i][j];
                seq++;
                if (seq == m * n) {
                    return ans;
                }

                if (i - 1 < 0 || j + 1 >= n) {
                    if (i - 1 < 0 && j + 1 >= n) {
                        i++;
                    } else if (i - 1 < 0) {
                        j++;
                    } else {
                        i++;
                    }
                    break;
                }
                i--;
                j++;
            }

            while (true) {
                ans[seq] = mat[i][j];
                seq++;
                if (seq == m * n) {
                    return ans;
                }

                if (i + 1 >= m || j - 1 < 0) {
                    if (i + 1 >= m && j - 1 < 0) {
                        j++;
                    } else if (i + 1 >= m) {
                        j++;
                    } else {
                        i++;
                    }
                    break;
                }
                i++;
                j--;
            }
        }

        return ans;
    }
}
