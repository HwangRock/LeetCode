import java.util.*;

class Solution {

    static double gain(int a, int b) {
        return (double) (a + 1) / (b + 1) - (double) a / b;
    }

    static PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare((double) gain(b[0], b[1]), gain(a[0], a[1])));

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double ans = 0;
        int cl = classes.length;
        for (int i = 0; i < cl; i++) {
            pq.add(new int[]{classes[i][0], classes[i][1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int cur[] = pq.poll();
            cur[0]++;
            cur[1]++;
            pq.add(cur);
        }

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            double a = (double) cur[0] / cur[1];
            ans += a;
        }

        return ans / cl;
    }
}