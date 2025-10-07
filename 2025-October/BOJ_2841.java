
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static int solve(int num[][], int n) {
        int ans = 0;

        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 1; i <= 6; i++) stacks[i] = new Stack<>();

        for (int i = 0; i < n; i++) {
            int line = num[i][0];
            int fret = num[i][1];
            Stack<Integer> s = stacks[line];
            while (!s.isEmpty() && s.peek() > fret) {
                s.pop();
                ans++;
            }
            if (!s.isEmpty() && s.peek() == fret) {
                continue;
            }
            s.push(fret);
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int inp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inp[i][0] = Integer.parseInt(st.nextToken());
            inp[i][1] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(solve(inp, n)));
        bw.flush();
    }
}
