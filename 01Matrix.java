// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - we are traversing 
// the matrix and calling dfs on 1s. At the 1s, we figure out the top,bottom,left and right
//and use dp and recursion to get the min + 1

public class 01Matrix {
    //dfs based dp : o(mn)
    int m, n;
    int result[][];
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.result = new int[m][n];
        for(int i = 0; i < m ;i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    result[i][j] = dfs(mat,i,j);
                }
            }

        }
        return result;
    }

    private int dfs(int[][] mat, int i, int j){
        //base 
        if(i > 0 && mat[i-1][j] == 0) return 1;
        if(j > 0 && mat[i][j-1] == 0) return 1;
        if(i < m-1 && mat[i+1][j] == 0) return 1;
        if(j < n-1 && mat[i][j+1] == 0) return 1;

        //logic 
        int top = 9999, bottom = 9999, left = 9999, right = 9999;
        if(i > 0 && result[i-1][j] != 0){
            top = result[i-1][j];
        }
        if(j > 0 && result[i][j-1] != 0){
            left = result[i][j-1];
        }

        if(i < m-1){
            if(result[i+1][j] == 0){
                result[i+1][j] = dfs(mat, i+1, j);
            }
            bottom = result[i+1][j];
        }
        if(j < n-1){
            if(result[i][j+1] == 0){
                //recurse on right
                result[i][j+1] = dfs(mat,i,j+1);
            }
            right = result[i][j+1];
        }
        return 1+ Math.min(top, Math.min(bottom, Math.min(left, right)));

    }

    //better bfs - o(mn) 
    // int dirs[][];
    // int m, n;
    // public int[][] updateMatrix(int[][] mat) {
    //     this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    //     this.m = mat.length;
    //     this.n = mat[0].length;
    //     Queue<int[]> q = new LinkedList<>();
    //     for(int i = 0; i < m ;i++){
    //         for(int j = 0; j < n; j++){
    //             if(mat[i][j] == 0){
    //                 q.offer(new int[]{i,j});
    //             }
    //             else if(mat[i][j] == 1){
    //                 mat[i][j] = -1;
    //             }
    //         }
    //     }
    //     // int dist = 1;
    //     while(!q.isEmpty()){
    //         // int size = q.size(); other option 
    //         // for(int i  = 0 ;i <size; i++){
    //             int[] curr = q.poll();
    //             for(int[] d: dirs){
    //                 int r = curr[0] + d[0];
    //                 int c = curr[1] + d[1];
    //                 if(r >= 0 && r < m && c >=0 && c < n && mat[r][c] == -1){
    //                     // mat[r][c] = dist;
    //                     mat[r][c] = mat[curr[0]][curr[1]] + 1;
    //                     q.offer(new int[]{r,c});
    //                 }
    //             }
    //         // }
    //         // dist++;
    //     }
    //     return mat;
    // }


    //bfs o(m^2 n^2)
    // int dirs[][];
    // int m, n;
    // public int[][] updateMatrix(int[][] mat) {
    //     this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    //     this.m = mat.length;
    //     this.n = mat[0].length;
    //     for(int i = 0; i < m ;i++){
    //         for(int j = 0; j < n; j++){
    //             if(mat[i][j] == 1){
    //                 mat[i][j] = bfs(mat,i,j);
    //             }
    //         }
    //     }
    //     return mat;
    // }

    // private int bfs(int[][] mat, int i, int j){
    //     Queue<int[]> q = new LinkedList<>();
    //     boolean[][] visited = new boolean[m][n];
    //     int dist = 1;
    //     q.offer(new int[]{i,j});
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         for(int k = 0; k < size; k++){
    //             int[] curr = q.poll();
    //             for(int d[] : dirs){
    //                 int nr = curr[0] + d[0];
    //                 int nc = curr[1] + d[1];
    //                 if(nr >= 0 && nr < m && nc >= 0 && nc < n){
    //                     if(mat[nr][nc] == 0) return dist;
    //                     else{
    //                         if(!visited[nr][nc]){
    //                             q.offer(new int[]{nr, nc});
    //                             visited[nr][nc] = true;
    //                         }
    //                     }
    //                 }
    //             } 
    //         }
    //         dist++; 
    //     }


    //     return -1;
    // }
}
