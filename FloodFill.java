// Time Complexity : o (mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - we are doing 
//normal dfs here, we check if the r and c are in bounds, and equal to the oldcolor
//if yes then we update it and call dfs on its neighbors.

public class FloodFill{
    //dfs approach
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        this.m = image.length;
        this.n = image[0].length;
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        helper(image, sr, sc, oldColor, color);
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int oldColor, int color){
        //base
        if(sr >= m || sr < 0 || sc >= n || sc < 0 || image[sr][sc] != oldColor) return;
        
        //logic 
        image[sr][sc] = color;

        //recurse 
        for(int d[]: dirs){
            int r = sr + d[0];
            int c = sc + d[1];
            helper(image, r, c, oldColor, color);
        }
    }

    //bfs approach
    // int[][] dirs;
    // int m,n;
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    //     this.m = image.length;
    //     this.n = image[0].length;
    //     int oldColor = image[sr][sc];
    //     if(oldColor == color) return image;
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(sr);
    //     q.offer(sc);
    //     image[sr][sc] = color;
    //     while(!q.isEmpty()){
    //         int r = q.poll();
    //         int c = q.poll();
    //         for(int d[]: dirs){
    //             int nr = r + d[0];
    //             int nc = c + d[1];
    //             if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor){
    //                 q.offer(nr);
    //                 q.offer(nc);
    //                 image[nr][nc] = color;
    //             }
    //         }
    //     }
    //     return image;
    // }
}