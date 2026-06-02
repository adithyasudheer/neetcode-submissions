class Solution {
    public int findDuplicate(int[] nums) 
    {
        int slow=0,fast=0;
        do
        {
            slow=nums[slow];
            fast=nums[fast];
            fast=nums[fast];
        }while(slow!=fast);
        int ptr=0;
        while(ptr!=slow)
        {
            slow=nums[slow];
            ptr=nums[ptr];
        }
        return slow;
    }
}
