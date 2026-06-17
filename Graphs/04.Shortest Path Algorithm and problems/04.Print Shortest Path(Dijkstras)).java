import java.util.*;

class Pair {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {

    public List<Integer> shortestPath(int V, ArrayList<ArrayList<Pair>> adj, int src, int dest) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );

        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

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

                    parent[adjNode] = node; // store path

                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (dist[dest] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        int node = dest;

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(src);

        Collections.reverse(path);

        return path;
    }
}
