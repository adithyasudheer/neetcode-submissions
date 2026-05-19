class Solution {
    public int trap(int[] heights) 
    {
        int []l=new int[heights.length]; 
        int []r=new int[heights.length]; 
        int mx=0; 
        for(int i=0;i<heights.length;i++) 
        { 
            mx=Math.max(heights[i],mx); 
            l[i]=Math.max(heights[i],mx); 
        } 
        mx=0; 
        for(int i=heights.length-1;i>=0;i--) 
        { 
            mx=Math.max(heights[i],mx); 
            r[i]=Math.max(heights[i],mx); 
        } 
        int res=0; 
        for(int i=0;i<heights.length;i++) 
        { 
            int h=Math.min(l[i],r[i]); 
            res+=((h>heights[i])?h-heights[i]:0); 
        } 
        return res;
    }
}
