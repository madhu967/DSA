class Solution {

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
