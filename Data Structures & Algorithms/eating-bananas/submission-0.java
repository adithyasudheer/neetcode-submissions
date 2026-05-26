class Solution {
    public boolean check(int[] piles, int mid, int h)
    {
        int hrs=0;

        for(int i=0;i<piles.length;i++)
        {
            hrs+=Math.ceil((piles[i]+mid-1)/mid);

        }

        return hrs<=h;
    }
    public int minEatingSpeed(int[] piles, int h) 
    {
        int hi=Integer.MIN_VALUE,lo=0,mid,ans=0;
        for(int i=0;i<piles.length;i++)
            hi=Math.max(hi,piles[i]);
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            if(check(piles,mid+1,h))
            {
                ans=mid+1;
                hi=mid-1;
            } 
            else
                lo=mid+1;
        }
        return ans;
    }
}
