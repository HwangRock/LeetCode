class Solution {

    public String longestPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        int fin = s.length();
        int li = 0;
        int ri = 0;
        int len = 1;
        boolean memo[][] = new boolean[fin][fin];

        for (int i = 0; i < fin; i++) {
            memo[i][i] = true;
        }

        for (int k = 2; k <= fin; k++) {
            for (int i = 0; i < fin; i++) {
                int j = i + k - 1;
                if (j >= fin) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (k <= 3) {
                        memo[i][j] = true;
                    } else {
                        memo[i][j] = memo[i + 1][j - 1];
                    }
                }

                if (memo[i][j] && k > len) {
                    li = i;
                    ri = j;
                    len = k;
                }
            }
        }

        for (int i = li; i <= ri; i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}