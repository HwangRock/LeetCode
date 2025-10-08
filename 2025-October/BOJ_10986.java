import java.io.*;
import java.util.*;


public class Main {

    static long solve(int num[], int n, int m) {
        long ans = 0;
        int sum = 0;
        long freq[] = new long[m];
        freq[0] = 1;
        for (int i = 0; i < n; i++) {
            sum = (sum + num[i]) % m;
            ans += freq[sum];
            freq[sum]++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int num[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(solve(num, n, m)));
        bw.flush();
    }
}
