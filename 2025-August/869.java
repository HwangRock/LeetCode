import java.util.*;

class Solution {
    static HashSet<String> set = new HashSet<>();

    static String check(int n) {
        int bit[] = new int[10];
        while (n != 0) {
            int a = n % 10;
            bit[a]++;
            n = n / 10;
        }
        return Arrays.toString(bit);
    }

    public boolean reorderedPowerOf2(int n) {
        int fin=(int)Math.pow(2,30);
        for (long i = 1; i <= fin; i = i * 2) {
            String cur = check((int)i);
            set.add(cur);
        }
        String nbit = check(n);
        if (set.contains(nbit)) {
            return true;
        } else {
            return false;
        }
    }
}