import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<int[]> move = new ArrayList<>();

    static int other(int a, int b) {
        return 6 - a - b;
    }

    static void solve(int n, int arr[], int end) {
        if (n <= 0) {
            return;
        }
        int cur = arr[n];
        int ot = other(cur, end);
        solve(n - 1, arr, ot); // 현재 위에 있는 원판을 제3으로.

        move.add(new int[]{cur, end}); // 현재를 이동.

        int na[] = new int[n + 1];
        for (int i = 1; i <= n - 1; i++) {
            na[i] = ot;
        }
        solve(n - 1, na, end); // 제3에 있는 원판을 목표로 이동.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = 1;
        }
        solve(n, arr, 3);
        int fin = move.size();
        bw.write(fin + "\n");
        for (int i = 0; i < fin; i++) {
            int cur[] = move.get(i);
            bw.write(cur[0] + " " + cur[1] + "\n");
        }
        bw.flush();
    }
}
