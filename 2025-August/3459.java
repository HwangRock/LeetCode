import java.util.*;

class Solution {

    int memo[][][][];
    List<int[]> start;
    int n, m;
    int graph[][];

    static final int[] dy = {-1, -1, 1, 1};
    static final int[] dx = {-1, 1, -1, 1};
    static final int[] dd = {1, 3, 0, 2};

    boolean isRange(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < m) {
            return true;
        } else {
            return false;
        }
    }

    boolean isSequence(int y, int x, int ny, int nx) {
        int cur = graph[y][x];
        int nxt = graph[ny][nx];
        if (cur == 1 && nxt == 2) {
            return true;
        }
        if (cur == 2 && nxt == 0) {
            return true;
        }
        if (cur == 0 && nxt == 2) {
            return true;
        }

        return false;
    }

    int dfs(int y, int x, int dir, int state) {
        if (memo[y][x][dir][state] != -1) {
            return memo[y][x][dir][state];
        }
        memo[y][x][dir][state] = 0;
        if (state == 1) { // 이미 방향 바꿈
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (isRange(ny, nx) && isSequence(y, x, ny, nx)) {
                memo[y][x][dir][state] = Math.max(memo[y][x][dir][state], dfs(ny, nx, dir, 1) + 1);
            }
        } else { // 아직 방향 안바꿈
            if (graph[y][x] == 1) {
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (isRange(ny, nx) && isSequence(y, x, ny, nx)) {
                        memo[y][x][dir][state] = Math.max(memo[y][x][dir][state], dfs(ny, nx, i, 0) + 1);
                    }
                }
            } else {
                int nd = dd[dir]; // 전환하는 경우
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                if (isRange(ny, nx) && isSequence(y, x, ny, nx)) {
                    memo[y][x][dir][state] = Math.max(memo[y][x][dir][state], dfs(ny, nx, nd, 1) + 1);
                }

                ny = y + dy[dir]; // 방향 그대로하는 경우
                nx = x + dx[dir];
                if (isRange(ny, nx) && isSequence(y, x, ny, nx)) {
                    memo[y][x][dir][state] = Math.max(memo[y][x][dir][state], dfs(ny, nx, dir, 0) + 1);
                }
            }
        }
        return memo[y][x][dir][state];
    }

    int solve() {
        int ans = 0;
        int fin = start.size();
        if (fin == 0) {
            return ans;
        } else {
            for (int i = 0; i < fin; i++) {
                int cur[] = start.get(i);
                for (int d = 0; d < 4; d++) {
                    ans = Math.max(ans, dfs(cur[0], cur[1], d, 0));
                }
            }
            return ans + 1;
        }
    }

    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        graph = grid;
        memo = new int[n][m][4][2];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                for (int d = 0; d < 4; d++) {
                    Arrays.fill(memo[y][x][d], -1);
                }
            }
        }
        start = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start.add(new int[]{i, j});
                }
            }
        }
        int ans = solve();
        return ans;
    }
}