import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        long minVal = Long.MAX_VALUE;

        for (int x : basket1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            minVal = Math.min(minVal, x);
        }

        for (int x : basket2) {
            freq.put(x, freq.getOrDefault(x, 0) - 1);
            minVal = Math.min(minVal, x);
        }

        List<Integer> swapList = new ArrayList<>();

        for (int key : freq.keySet()) {
            int diff = freq.get(key);
            if (diff % 2 != 0) return -1;

            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                swapList.add(key);
            }
        }

        Collections.sort(swapList);
        long ans = 0;

        for (int i = 0; i < swapList.size() / 2; i++) {
            ans += Math.min(swapList.get(i), 2 * minVal);
        }

        return ans;
    }
}
