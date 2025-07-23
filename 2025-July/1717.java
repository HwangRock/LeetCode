import java.util.*;

class Solution {

    static int pnt = 0;

    static String change(Deque<Character> st) {
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.removeLast());
        }
        return sb.toString();
    }

    static String removeAB(String s, int x) {
        pnt = 0;
        Deque<Character> st = new ArrayDeque<>();
        int fin = s.length();
        for (int i = 0; i < fin; i++) {
            char c = s.charAt(i);
            if (c == 'b' && !st.isEmpty() && st.peek() == 'a') {
                st.pop();
                pnt += x;
            } else {
                st.push(c);
            }
        }

        return change(st);
    }

    static String removeBA(String s, int y) {
        pnt = 0;
        Deque<Character> st = new ArrayDeque<>();
        int fin = s.length();
        for (int i = 0; i < fin; i++) {
            char c = s.charAt(i);
            if (c == 'a' && !st.isEmpty() && st.peek() == 'b') {
                st.pop();
                pnt += y;
            } else {
                st.push(c);
            }
        }

        return change(st);
    }

    public int maximumGain(String s, int x, int y) {
        int ans = 0;

        if (x >= y) {
            String fir = removeAB(s, x);
            ans += pnt;
            removeBA(fir, y);
            ans += pnt;
        } else {
            String fir = removeBA(s, y);
            ans += pnt;
            removeAB(fir, x);
            ans += pnt;
        }

        return ans;
    }
}