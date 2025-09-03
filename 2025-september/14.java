import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        int fin = strs.length;

        ans = strs[0];
        int la = ans.length();
        for (int i = 1; i < fin; i++) {
            String s = strs[i];
            int ls = s.length();

            int fin2 = Math.min(la, ls);
            for (int j = 0; j < fin2; j++) {
                if (ans.charAt(j) == s.charAt(j)) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
            }

            int lc = sb.length();
            ans = sb.toString();
            la = lc;
            sb.setLength(0);
        }

        return ans;
    }
}