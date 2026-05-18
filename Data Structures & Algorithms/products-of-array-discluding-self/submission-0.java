class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int []l=new int[nums.length];
        int []r=new int[nums.length];    
        l[0]=nums[0];
        r[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            l[i]=l[i-1]*nums[i];
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            r[i]=r[i+1]*nums[i];
        }
        int []res=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            res[i]=((i>0)?l[i-1]:1)*((i<nums.length-1)?r[i+1]:1);
        }
        return res;
    }
}  
