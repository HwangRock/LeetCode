import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static String[] solve(int h, int t) {
        String ans[] = new String[2];

        boolean able = false;
        int i = 0;
        for (i = 0; i < t; i++) {
            int a = -pq.poll();
            if (h > a) {
                able = true;
                break;
            } else {
                if (a == 1) {
                    pq.add(-a);
                } else {
                    a = a / 2;
                    pq.add(-a);
                }
            }
        }

        if (!pq.isEmpty()) {
            int a = -pq.poll();
            if (h > a) {
                able = true;
            }
            pq.add(-a);
        }

        if (able) {
            ans[0] = "YES";
            ans[1] = String.valueOf(i);
        } else {
            ans[0] = "NO";
            ans[1] = String.valueOf(-pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            pq.add(-a);
        }

        String ans[] = solve(h, t);
        bw.write(ans[0] + "\n" + ans[1]);
        bw.flush();
    }
}
