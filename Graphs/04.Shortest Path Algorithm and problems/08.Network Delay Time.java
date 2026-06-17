import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int dis = curr[1];

            for(int[] nei : adj.get(node)) {

                int adjNode = nei[0];
                int wt = nei[1];

                if(dis + wt < dist[adjNode]) {

                    dist[adjNode] = dis + wt;

                    pq.offer(new int[]{
                        adjNode,
                        dist[adjNode]
                    });
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {

            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
