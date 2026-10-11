class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int l=0,r=0,sum=0,anslen=Integer.MAX_VALUE;
        while(l<=r && r<nums.length)
        {
            sum+=nums[r];
            if(sum<target)
                r++;
            else
            {
                while(sum>=target)
                {
                    anslen=Math.min(anslen,r-l+1);
                    sum-=nums[l];
                    l++;
                }
                r++;
            }
        }    
        if(anslen==Integer.MAX_VALUE)
            return 0;
        return anslen;
    }
}