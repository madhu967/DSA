class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        ArrayList<ArrayList<Integer>> revAdj=new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] indegree=new int[V];
        for(int u=0;u<V;u++){
            for(int v:graph[u]){
                revAdj.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> safe=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            safe.add(node);
            for (int neighbor : revAdj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        Collections.sort(safe);

        return safe;
    }
}
