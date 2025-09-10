class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; // users are 1..m
        java.util.List<java.util.HashSet<Integer>> know = new java.util.ArrayList<>(m + 1);
        know.add(new java.util.HashSet<>()); // dummy for 1-index
        for (int i = 0; i < m; i++) {
            java.util.HashSet<Integer> set = new java.util.HashSet<>();
            for (int lang : languages[i]) set.add(lang);
            know.add(set);
        }
        java.util.HashSet<Integer> candidates = new java.util.HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];

            boolean can = false;

            java.util.HashSet<Integer> a = know.get(u), b = know.get(v);
            if (a.size() < b.size()) {
                for (int lang : a) {
                    if (b.contains(lang)) { can = true; break; }
                }
            } else {
                for (int lang : b) {
                    if (a.contains(lang)) { can = true; break; }
                }
            }
            if (!can) {
                candidates.add(u);
                candidates.add(v);
            }
        }
        if (candidates.isEmpty()) return 0;
        int[] count = new int[n + 1];
        for (int u : candidates) {
            for (int lang : know.get(u)) {
                count[lang]++;
            }
        }

        int bestAlreadyKnow = 0;
        for (int l = 1; l <= n; l++) {
            bestAlreadyKnow = Math.max(bestAlreadyKnow, count[l]);
        }
        return candidates.size() - bestAlreadyKnow;
    }
}
