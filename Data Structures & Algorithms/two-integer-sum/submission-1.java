class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int []res=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i]))
            {
                res[0]=hm.get(target-nums[i]);
                res[1]=i;
                break;
            }
            hm.put(nums[i],i);
        }
        return res;
        // Arrays.sort(nums);
        // int []res=new int[2];
        // for(int i=0,j=nums.length-1;i<j;)
        // {
        //     if(nums[i]+nums[j]==target)
        //     {
        //         res[0]=i;
        //         res[1]=j;
        //         break;
        //     }
        //     else if(nums[i]+nums[j]<target)
        //         i++;
        //     else
        //         j--;
        // }    
        // return res;
        

    }
}
