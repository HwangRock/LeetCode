import java.util.*;

class Solution {

    static long giveNum(int n, int m) {
        long ans = 0;
        if (n % 2 == 0) { //m이하의 홀수의 수를 줘야함
            if (m % 2 == 0) {
                ans = m / 2;
            } else {
                ans = m / 2 + 1;
            }
        } else { //m이하의 짝수의 수를 줘야함
            ans = m / 2;
        }
        return ans;
    }

    public long flowerGame(int n, int m) {
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            long able = giveNum(i, m);
            ans += able;
        }

        return ans;
    }
}