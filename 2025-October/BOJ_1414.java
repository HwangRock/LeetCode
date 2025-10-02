
import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    static int par[];

    static int find(int a) {
        if (par[a] < 0) {
            return a;
        }
        par[a] = find(par[a]);
        return par[a];
    }

    static void merge(int a, int b) {
        a = find(a);
        b = find(b);

        if (par[a] < par[b]) {
            par[a] += par[b];
            par[b] = a;
        } else {
            par[b] += par[a];
            par[a] = b;
        }
    }

    static int solve(int n, int cur) {
        int ans = 0;

        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = -1;
        }
        while (!pq.isEmpty()) {
            int a[] = pq.poll();
            if (find(a[1]) != find(a[2])) {
                merge(a[1], a[2]);
                ans += a[0];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (find(i) != find(i + 1)) {
                return -1;
            }
        }
        ans = cur - ans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cur = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c != '0') {
                    int a = 0;
                    if (c >= 'a') {
                        a = c - 'a' + 1;
                    } else {
                        a = c - 'A' + 27;
                    }
                    cur += a;
                    pq.add(new int[]{a, i, j});
                }
            }
        }
        bw.write(String.valueOf(solve(n, cur)));
        bw.flush();
    }
}
