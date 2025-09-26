
import java.io.*;
import java.util.*;

public class Main {
    static long memo[][];


    static long solve(int a, int b) {
        if (a == 0 && b == 0) {
            return 1;
        }
        if (memo[a][b] != 0) {
            return memo[a][b];
        }
        if (a > 0) {
            memo[a][b] += solve(a - 1, b + 1);
        }
        if (b > 0) {
            memo[a][b] += solve(a, b - 1);
        }
        return memo[a][b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        memo = new long[31][31];
        solve(30, 0);
        int n;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            bw.write(memo[n][0] + "\n");
        }
        bw.flush();
    }
}
