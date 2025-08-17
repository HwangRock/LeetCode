import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }
}
