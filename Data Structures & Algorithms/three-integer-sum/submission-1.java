class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        HashSet<List<Integer>>hm=new HashSet<>();
        for(int i=0;i<nums.length-2;i++)
        {
            int l=i+1,r=nums.length-1;
            while(l<r)
            {
                if(nums[l]+nums[r]==(-nums[i]))
                {
                    List<Integer>temp=new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    //res.add(temp);
                    hm.add(temp);
                    //while(l<r && l<nums.length && nums[l]==temp.get(1))
                        l++;
                    //while(l<r && r>i && nums[r]==temp.get(2))
                        r--;
                }
                else if(nums[l]+nums[r]<(-nums[i]))
                    l++;
                else
                    r--;
            }
        }    
        for(List<Integer> l: hm)
            res.add(l);
        return res;
    }
}
