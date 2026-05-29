class Solution {
    public boolean check(int[]weights, int days, int val)
    {
        int sum=weights[0],count=1;
        for(int i=1;i<weights.length;i++)
        {
            if(sum+weights[i]>val)
            {
                count++;
                sum=weights[i];
            }
            else if(weights[i]<=val)
                sum+=weights[i];
            else
                return false;
        }
        if(count<=days)
            return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) 
    {
        int lo=0,hi=0,mid;
        for(int i=0;i<weights.length;i++)    
        {
            lo=Math.max(lo,weights[i]);
            hi+=weights[i];
        }
        int ans=hi;
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            if(check(weights,days,mid))
            {
                ans=Math.min(ans,mid);
                hi=mid-1;
            }
            else
                lo=mid+1;
        }
        return ans;
    }
}