class Solution {
    int[][]dir=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    int dfs(int i, int j, int[][]matrix,int [][]dp)
    {
        if(i>=matrix.length || i<0 ||j>=matrix[0].length || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int res=1;
        for(int k=0;k<dir.length;k++)
        {
            int nx=j+dir[k][0],ny=i+dir[k][1];
            if(nx>=0 && nx<matrix[0].length && ny>=0 && ny<matrix.length && matrix[ny][nx]>matrix[i][j])
            {
                res=Math.max(res,1+dfs(ny,nx,matrix,dp));
            }
        }
        return dp[i][j]=res;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int [][]dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            Arrays.fill(dp[i],-1);
        int ans=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                ans=Math.max(ans,dfs(i,j,matrix,dp));
            }
        }        
        return ans;
    }
}
