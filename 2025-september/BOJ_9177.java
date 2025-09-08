import java.io.*;
import java.util.*;

public class Main {

    static String n, m, t;
    static Boolean memo[][];

    static boolean solve(int a, int b, int c, int af, int bf, int cf) {

        if (memo[a][b] != null) {
            return memo[a][b];
        }

        if (c == cf) { // 종료
            if (a == af && b == bf) {
                return true;
            } else {
                return false;
            }
        }

        boolean cur = false;
        if (a < af && n.charAt(a) == t.charAt(c)) { // n의 자릿수를 쓰는 경우
            cur |= solve(a + 1, b, c + 1, af, bf, cf);
        }
        if (!cur && b < bf && m.charAt(b) == t.charAt(c)) { // m의 자릿수를 쓰는 경우
            cur |= solve(a, b + 1, c + 1, af, bf, cf);
        }
        memo[a][b] = cur;

        return memo[a][b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String s[] = br.readLine().split(" ");
            n = s[0];
            m = s[1];
            t = s[2];
            memo = new Boolean[n.length() + 1][m.length() + 1];
            bw.write("Data set " + (i + 1) + ": ");
            if (solve(0, 0, 0, n.length(), m.length(), t.length())) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }
}
