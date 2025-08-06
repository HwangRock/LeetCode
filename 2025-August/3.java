import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        HashSet<Character> h = new HashSet<>();

        int cur = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (!h.contains(c)) {
                cur++;
                h.add(c);
            } else {
                while (r < n && s.charAt(l) != c) {
                    h.remove(s.charAt(l));
                    l++;
                    cur--;
                }
                l++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}