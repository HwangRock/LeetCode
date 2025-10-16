import java.io.*;
import java.util.*;


public class Main {
    static List<List<Integer>> lis = new ArrayList<>();
    static int ans[];
    static int child[];

    static void solve(int n) {
        Queue<Integer> sta = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (child[i] == 0) {
                sta.add(i);
                ans[i] = 1;
            }
        }

        while (!sta.isEmpty()) {
            int cur = sta.poll();

            int fin = lis.get(cur).size();
            for (int i = 0; i < fin; i++) {
                int nxt = lis.get(cur).get(i);
                if (ans[nxt] < ans[cur] + 1) {
                    ans[nxt] = ans[cur] + 1;
                }
                child[nxt]--;
                if (child[nxt] == 0) {
                    sta.add(nxt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ans = new int[n + 1];
        child = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            lis.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lis.get(a).add(b);
            child[b]++;
        }
        solve(n);
        for (int i = 1; i <= n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
