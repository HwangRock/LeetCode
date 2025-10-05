
import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
    );

    static int solve() {
        int ans = 1;
        int fir[] = pq.poll();
        int w = fir[0];
        int t = fir[1];
        while (!pq.isEmpty()) {
            int a[] = pq.poll();
            if (a[0] <= w || a[1] <= t) {
                ans++;
            }
            if (t >= a[1]) {
                w = a[0];
                t = a[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                pq.add(new int[]{a, b});
            }
            bw.write(solve() + "\n");
        }
        bw.flush();
    }
}
