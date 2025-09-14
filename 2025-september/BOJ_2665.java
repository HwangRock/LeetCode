import java.io.*;
import java.util.*;

public class Main {

    static char g[][];
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    static boolean visit[][];

    static int solve(int n) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        }); // 0번은 밟은 검은 발판, 1번은 y좌표, 2번은 x좌표
        pq.add(new int[]{0, 0, 0});
        visit[0][0] = true;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            if (cur[1] == n - 1 && cur[2] == n - 1) {
                ans = cur[0];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int y = cur[1] + dy[i];
                int x = cur[2] + dx[i];
                if (y >= 0 && y < n && x >= 0 && x < n && !visit[y][x]) {
                    if (g[y][x] == '1') {
                        pq.add(new int[]{cur[0], y, x});
                    } else {
                        pq.add(new int[]{cur[0] + 1, y, x});
                    }
                    visit[y][x] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        g = new char[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
            }
        }
        bw.write(String.valueOf(solve(n)));
        bw.flush();
    }
}