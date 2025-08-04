import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        int visit[] = new int[100001];
        int l = 0;
        int fin = fruits.length;
        int cur = 0;
        for (int i = 0; i < fin; i++) {
            if (!set.contains(fruits[i])) {
                set.add(fruits[i]);
            }
            visit[fruits[i]]++;
            cur++;
            while (set.size() >= 3) {
                visit[fruits[l]]--;
                if (visit[fruits[l]] == 0) {
                    set.remove(fruits[l]);
                }
                l++;
                cur--;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}