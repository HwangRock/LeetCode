import java.io.*;
import java.util.*;

public class Main {

    static boolean visit[];
    static char val[];
    static int parent[];
    static char code[] = {'D', 'S', 'L', 'R'};

    static int calculate(int num, int i) {
        int nxt = 0;

        if (i == 0) {
            nxt = (num * 2) % 10000;
        } else if (i == 1) {
            if (num == 0) {
                nxt = 9999;
            } else {
                nxt = num - 1;
            }
        } else if (i == 2) {
            nxt = (num % 1000) * 10 + num / 1000;
        } else {
            nxt = (num % 10) * 1000 + num / 10;
        }

        return nxt;
    }

    static String solve(int a, int b) {
        String ans = "";
        Queue<Integer> q = new ArrayDeque<>();
        visit[a] = true;
        q.add(a);

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == b) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nxt = calculate(num, i);
                if (visit[nxt] == false) {
                    visit[nxt] = true;
                    parent[nxt] = num;
                    val[nxt] = code[i];
                    q.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cur = b;
        while (cur != a) {
            char c = val[cur];
            cur = parent[cur];
            sb.append(c);
        }

        ans = sb.reverse().toString();
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            visit = new boolean[10001];
            val = new char[10001];
            parent = new int[10001];
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(solve(a, b) + "\n");
        }
        bw.flush();
    }
}
