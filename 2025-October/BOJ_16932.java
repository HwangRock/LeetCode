import java.io.*;
import java.util.*;

public class Main {
    static int g[][];
    static int area[][];

    static int cnt = 0;
    static int n, m;
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};

    static int bef[];
    static Stack<int[]>st=new Stack<>();

    static void dfs(int y, int x) {
        st.add(new int[]{y,x});
        area[y][x]=cnt;
        while(!st.isEmpty()){
            int cur[]=st.pop();
            int cy=cur[0];
            int cx=cur[1];
            bef[cnt]++;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m && g[ny][nx] == 1) {
                    if (area[ny][nx] == 0) {
                        area[ny][nx]=cnt;
                        st.add(new int[]{ny,nx});
                    }
                }
            }
        }
    }

    static int solve() {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && area[i][j] == 0) {
                    cnt++;
                    area[i][j] = cnt;
                    dfs(i, j);
                }
            }
        }

        int seen[] = new int[cnt + 1];
        int stamp = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 0) {
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dy[k];
                        int nj = j + dx[k];
                        if (0 <= ni && ni < n && 0 <= nj && nj < m) {
                            int aid = area[ni][nj];
                            if (aid > 0 && seen[aid] != stamp) {
                                seen[aid] = stamp;
                                sum += bef[aid];
                            }
                        }
                    }
                    ans = Math.max(ans, sum + 1);
                    stamp++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = new int[n][m];
        bef = new int[n * m + 1];
        area = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String c = st.nextToken();
                g[i][j] = c.charAt(0) - '0';
            }
        }
        bw.write(String.valueOf(solve()));
        bw.flush();
    }
}
