class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        //if(matrix.isEmpty())
        //    return false;
        int r=matrix.length,c=matrix[0].length;
        int lo=0,hi=r*c-1,mid;
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;

            if(target==matrix[mid/c][mid%c])
                return true;
            else if(target<matrix[mid/c][mid%c])
                hi=mid-1;
            else
                lo=mid+1;
        }    
        return false;
    }
}
