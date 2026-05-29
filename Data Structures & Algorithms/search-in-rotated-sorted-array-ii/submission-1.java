class Solution {
    public boolean search(int[] nums, int target) 
    {
        int lo=0,hi=nums.length-1,mid;
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            if(nums[mid]==target)
                return true;
            else if(nums[lo]==nums[mid] && nums[mid]==nums[hi])
            {
                lo++;
                hi--;
            }
            else if(nums[mid]>=nums[lo])
            {
                if(target>=nums[lo] && target<=nums[mid])
                    hi=mid-1;
                else 
                    lo=mid+1;
            }
            else
            {
                if(target>=nums[mid] && target<=nums[hi])
                    lo=mid+1;
                else 
                    hi=mid-1;
            }
        }    
        return false;
    }
}