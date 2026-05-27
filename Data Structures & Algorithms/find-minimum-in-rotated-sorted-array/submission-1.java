class Solution {
    public int findMin(int[] nums) {
        int lo=0,hi=nums.length-1,mid;
        while(lo<hi)
        {
            mid=lo+(hi-lo)/2;
            if(nums[mid]>nums[hi])
                lo=mid+1;
            else
                hi=mid;
        }
        return nums[lo];
    }
}
