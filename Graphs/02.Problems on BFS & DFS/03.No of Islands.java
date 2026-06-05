class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int islands=0;
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]='0';

                    while(!q.isEmpty()){
                        int[] curr=q.poll();
                        for(int[] d:dirs){
                            int r = curr[0] + d[0];
                            int c = curr[1] + d[1];

                            if (r >= 0 && r < n &&
                                c >= 0 && c < m &&
                                grid[r][c] == '1') {

                                grid[r][c] = '0';
                                q.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}






class Solution {
    void dfs(char [][]grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;

    }
}
