import java.util.*;

class Solution {
    public int maximum69Number(int num) {
        int ans = 0;
        char s[] = String.valueOf(num).toCharArray();

        int fin = s.length;
        for (int i = 0; i < fin; i++) {
            if (s[i] == '6') {
                s[i] = '9';
                break;
            }
        }

        ans = Integer.parseInt(new String(s));
        return ans;
    }
}