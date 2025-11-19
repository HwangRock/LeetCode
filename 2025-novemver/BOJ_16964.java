import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Integer, Set<Integer>> graph = new HashMap<>();

    static boolean solve(int n, int num[]) {

        if (num[0] != 1) {
            return false;
        }

        Deque<Integer> s = new ArrayDeque<>();
        s.push(num[0]);

        for (int i = 1; i < n; i++) {
            int cur = s.peek();

            if (!graph.get(cur).contains(num[i])) {
                return false;
            }

            graph.get(cur).remove(num[i]);
            graph.get(num[i]).remove(cur);

            while (!s.isEmpty() && graph.get(cur).isEmpty()) {
                s.pop();
                if (!s.isEmpty()) {
                    cur = s.peek();
                }
            }

            if (!graph.get(num[i]).isEmpty()) {
                s.push(num[i]);
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        String c[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(c[i]);
        }
        boolean ans = solve(n, num);
        if (ans) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
    }
}