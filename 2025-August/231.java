import java.util.*;

class Solution {
    public boolean isPowerOfTwo(int n) {
        int chk = n & (n - 1);
        if (n > 0 && chk == 0) {
            return true;
        } else {
            return false;
        }
    }
}