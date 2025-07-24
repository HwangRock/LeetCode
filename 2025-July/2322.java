import java.util.*;

class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] subXor;
    int[] inTime, outTime;
    int timer = 0;
    int totalXor;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        tree = new ArrayList[n];
        subXor = new int[n];
        inTime = new int[n];
        outTime = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        totalXor = dfs(0, -1);

        int ans = Integer.MAX_VALUE;
        int m = edges.length;

        for (int i = 0; i < m; i++) {
            int a = getChild(edges[i][0], edges[i][1]);
            for (int j = i + 1; j < m; j++) {
                int b = getChild(edges[j][0], edges[j][1]);
                
                if (isAncestor(a, b)) {
                    int x = subXor[b];
                    int y = subXor[a] ^ subXor[b];
                    int z = totalXor ^ subXor[a];
                    ans = Math.min(ans, getScore(x, y, z));
                } else if (isAncestor(b, a)) {
                    int x = subXor[a];
                    int y = subXor[b] ^ subXor[a];
                    int z = totalXor ^ subXor[b];
                    ans = Math.min(ans, getScore(x, y, z));
                } else {
                    int x = subXor[a];
                    int y = subXor[b];
                    int z = totalXor ^ x ^ y;
                    ans = Math.min(ans, getScore(x, y, z));
                }
            }
        }
        return ans;
    }

    private int dfs(int u, int parent) {
        inTime[u] = ++timer;
        int xor = nums[u];
        for (int v : tree[u]) {
            if (v != parent) {
                xor ^= dfs(v, u);
            }
        }
        subXor[u] = xor;
        outTime[u] = ++timer;
        return xor;
    }

    private boolean isAncestor(int u, int v) {
        return inTime[u] < inTime[v] && outTime[v] < outTime[u];
    }

    private int getChild(int u, int v) {
        if(inTime[u] > inTime[v]){
            return u;
        }
        else{
            return v;
        }
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}
