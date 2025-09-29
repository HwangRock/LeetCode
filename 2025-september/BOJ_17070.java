
import java.io.*;
import java.util.*;

public class Main {

    static int n, cnt;
    static int[][] map;

    static void solve(int x, int y, int state) {
        if (x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }

        if (state == 0) {
            if (y + 1 < n && map[x][y + 1] == 0) {
                solve(x, y + 1, 0);
            }
        } else if (state == 1) {
            if (x + 1 < n && map[x + 1][y] == 0) {
                solve(x + 1, y, 1);
            }
        } else if (state == 2) {
            if (y + 1 < n && map[x][y + 1] == 0) {
                solve(x, y + 1, 0);
            }
            if (x + 1 < n && map[x + 1][y] == 0) {
                solve(x + 1, y, 1);
            }
        }

        if (x + 1 < n && y + 1 < n && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            solve(x + 1, y + 1, 2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cnt = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 1, 0);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
