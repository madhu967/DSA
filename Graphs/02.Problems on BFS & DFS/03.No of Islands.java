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
