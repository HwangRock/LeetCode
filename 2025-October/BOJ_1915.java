import java.io.*;
import java.util.*;


public class Main {
    static char gr[][];

    static int solve(int n, int m) {
        int ans = 0;

        int memo[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (gr[i][j] == '1') {
                        memo[i][j] = 1;
                    }
                } else {
                    if (gr[i][j] == '1') {
                        int mini = Math.min(memo[i - 1][j], memo[i][j - 1]);
                        memo[i][j] = Math.min(memo[i - 1][j - 1], mini) + 1;
                    }
                }
                ans = Math.max(ans, memo[i][j]);
            }
        }

        return ans * ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        gr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                gr[i][j] = s.charAt(j);
            }
        }
        bw.write(String.valueOf(solve(n, m)));
        bw.flush();
    }
}
