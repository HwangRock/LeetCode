import java.util.*;

class Solution {
    public String largestGoodInteger(String num) {
        StringBuilder ans = new StringBuilder();
        int fin = num.length();
        int bit[] = new int[fin];
        char maxi = ' ';

        for (int i = 1; i < fin; i++) {
            char c = num.charAt(i);
            char bef = num.charAt(i - 1);
            if (c == bef) {
                bit[i] = bit[i - 1] + 1;
            }
            if (bit[i] == 2) {
                if (maxi == ' ' || c > maxi) {
                    maxi = c;
                }
            }
        }

        if (maxi == ' ') {
            return "";
        } else {
            for (int i = 0; i < 3; i++) {
                ans.append(maxi);
            }
            return ans.toString();
        }
    }
}