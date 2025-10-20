import java.io.*;
import java.util.*;


public class Main {

    static long solve(int n) {
        long memo[] = new long[101];
        long buf[] = new long[101];

        buf[1] = 1;
        memo[1] = 1;

        for (int i = 1; i < 100; i++) {
            if (i + 1 <= 100 && memo[i] + buf[i] == memo[i + 1]) {
                buf[i + 1] = Math.max(buf[i], buf[i + 1]);
            } else if (i + 1 <= 100 && memo[i] + buf[i] > memo[i + 1]) {
                buf[i + 1] = buf[i];
                memo[i + 1] = memo[i] + buf[i];
            }

            if (i + 2 <= 100 && memo[i] + buf[i] * 2 == memo[i + 2]) {
                buf[i + 2] = Math.max(buf[i], buf[i + 2]);
            } else if (i + 2 <= 100 && memo[i] + buf[i] * 2 > memo[i + 2]) {
                buf[i + 2] = buf[i];
                memo[i + 2] = memo[i] + buf[i] * 2;
            }

            if (i + 3 <= 100 && 2 * memo[i] == memo[i + 3]) {
                buf[i + 3] = Math.max(memo[i], buf[i + 3]);
            } else if (i + 3 <= 100 && 2 * memo[i] > memo[i + 3]) {
                buf[i + 3] = memo[i];
                memo[i + 3] = 2 * memo[i];
            }

            if (i + 4 <= 100 && 3 * memo[i] == memo[i + 4]) {
                buf[i + 4] = Math.max(memo[i], buf[i + 4]);
            } else if (i + 4 <= 100 && 3 * memo[i] > memo[i + 4]) {
                buf[i + 4] = memo[i];
                memo[i + 4] = 3 * memo[i];
            }
        }

        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(solve(n)));
        bw.flush();
    }
}
