class Solution {
    private void perm(int[] nums, int l, List<List<Integer>>res )
    {
        if(l>=nums.length)
        {
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
                temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=l;i<nums.length;i++)
        {
            int t=nums[i];
            nums[i]=nums[l];
            nums[l]=t;
            perm(nums,l+1,res);
            t=nums[i];
            nums[i]=nums[l];
            nums[l]=t;
        }
    }
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>>res=new ArrayList<>();
        // List<Integer>temp=new ArrayList<>();
        perm(nums,0,res);    
        return res;
    }
}
