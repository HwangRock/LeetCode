import java.io.*;
import java.util.*;

public class Main {

    static int grid[][];
    static boolean visit[][];
    static int ans = 0;

    static int n;
    static int m;

    static boolean rangeChk(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < m) {
            return true;
        }
        return false;
    }

    static int changeDir(int d) {
        int nd = d - 1;
        if (nd < 0) {
            nd = 3;
        }
        return nd;
    }

    static void solve(int y, int x, int dir) { // dir이 0-북, 1-동, 2-남, 3-서
        int ny = y;
        int nx = x;

        int seq = 0;
        for (int nd = changeDir(dir); seq < 4; nd = changeDir(nd)) {
            if (nd == 0) {
                ny--;
            } else if (nd == 1) {
                nx++;
            } else if (nd == 2) {
                ny++;
            } else {
                nx--;
            }
            if (rangeChk(ny, nx) && grid[ny][nx] == 0 && visit[ny][nx] == false) {
                ans++;
                visit[ny][nx] = true;
                solve(ny, nx, nd); // 다음 좌표로 넘어간 상황
                return;
            }
            ny = y;
            nx = x;
            seq++;
        }

        // 갈 좌표가 없어서 후진
        if (dir == 0) {
            y++;
        } else if (dir == 1) {
            x--;
        } else if (dir == 2) {
            y--;
        } else {
            x++;
        }
        if (rangeChk(y, x) && grid[y][x] == 0) {
            solve(y, x, dir);
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visit = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans++;
        visit[y][x] = true;
        solve(y, x, dir);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
