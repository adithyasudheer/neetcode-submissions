class Solution {
    private void comb(int[] nums, int target, int sum, int pos, List<List<Integer>>res, List<Integer>temp )
    {
        if(sum==target)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        else if(pos>=nums.length || sum>target)
            return;
        if(sum+nums[pos]<=target)
        {
            temp.add(nums[pos]);
            comb(nums,target,sum+nums[pos],pos,res,temp);
            temp.remove(temp.size()-1);
        }
        comb(nums,target,sum,pos+1,res,temp);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        comb(nums,target,0,0,res,temp);
        return res;    
    }
}
