import java.util.*;

class Pair {
    int v, wt;

    Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class Solution {

    private void dfs(int node, ArrayList<ArrayList<Pair>> adj,
                     boolean[] vis, Stack<Integer> st) {

        vis[node] = true;

        for (Pair it : adj.get(node)) {
            if (!vis[it.v]) {
                dfs(it.v, adj, vis, st);
            }
        }

        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        // Topological Sort
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0; // source

        // Process in topo order
        while (!st.isEmpty()) {

            int node = st.pop();

            if (dist[node] != Integer.MAX_VALUE) {

                for (Pair it : adj.get(node)) {

                    int v = it.v;
                    int wt = it.wt;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
