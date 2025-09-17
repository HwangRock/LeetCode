
import java.io.*;
import java.util.*;

public class Main {

    static void button(char s[], int id, int n) {
        if (id == 0) {
            for (int i = id; i <= id + 1; i++) {
                if (s[i] == '0') {
                    s[i] = '1';
                } else {
                    s[i] = '0';
                }
            }
        } else if (id == n - 1) {
            for (int i = id - 1; i < id + 1; i++) {
                if (s[i] == '0') {
                    s[i] = '1';
                } else {
                    s[i] = '0';
                }
            }
        } else {
            for (int i = id - 1; i <= id + 1; i++) {
                if (s[i] == '0') {
                    s[i] = '1';
                } else {
                    s[i] = '0';
                }
            }
        }
    }

    static int solve(char s[], char a[], int n) {
        int ans = 0;

        int seq1 = 1; // 0번째 버튼을 누른 경우
        int seq2 = 0; // 0번째 버튼을 안누름


        char fir[] = Arrays.copyOf(s, n);
        button(fir, 0, n);
        for (int i = 1; i < n; i++) {
            if (fir[i - 1] != a[i - 1]) {
                button(fir, i, n);
                seq1++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (fir[i] != a[i]) {
                seq1 = -1;
                break;
            }
        }

        char sec[] = Arrays.copyOf(s, n);
        for (int i = 1; i < n; i++) {
            if (sec[i - 1] != a[i - 1]) {
                button(sec, i, n);
                seq2++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (sec[i] != a[i]) {
                seq2 = -1;
                break;
            }
        }

        if (seq1 == -1 && seq2 == -1) {
            return -1;
        }

        if (seq1 == -1) {
            return seq2;
        }
        if (seq2 == -1) {
            return seq1;
        }
        ans = Math.min(seq1, seq2);

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char s[] = br.readLine().toCharArray();
        char a[] = br.readLine().toCharArray();
        bw.write(String.valueOf(solve(s, a, n)));
        bw.flush();
    }
}
