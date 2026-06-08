class Solution {
    private void fillSubsets(int[] nums,List<List<Integer>>res, ArrayList<Integer>temp,int idx)
    {
        if(idx==nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        fillSubsets(nums,res,temp,idx+1);
        temp.remove(temp.size()-1);
        fillSubsets(nums,res,temp,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>>res=new ArrayList<>();
        fillSubsets(nums,res,new ArrayList<Integer>(),0);
        return res;    
    }
}
