class Solution {
    public int maxArea(int[] heights) 
    {
        int i=0,j=heights.length-1;
        int mx=0;
        while(i<j)
        {
            mx=Math.max(mx,Math.min(heights[i],heights[j])*(j-i));
            if(heights[i]<heights[j])
                i++;
            else
                j--;
        }        
        return mx;
    }
}
