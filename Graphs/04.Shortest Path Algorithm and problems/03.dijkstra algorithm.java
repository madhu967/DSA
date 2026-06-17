import java.util.*;

class Pair {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int node = curr.node;
            int dis = curr.dist;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.dist;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }
}
