class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor=image[sr][sc];
        if(originalcolor== color){
            return image;
        }
        dfs(image,sr,sc,originalcolor,color);
        return image;
    }
    private void dfs(int[][] image,int r,int c,int originalcolor,int color){
        int n=image.length;
        int m=image[0].length;
        if(r<0 || r>=n || c<0 || c>=m || image[r][c]!=originalcolor){
            return;
        }
        image[r][c]=color;
        dfs(image,r+1,c,originalcolor,color);
        dfs(image, r - 1, c, originalcolor, color);
        dfs(image, r, c + 1, originalcolor, color);
        dfs(image, r, c - 1, originalcolor, color);
    }
}
