class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        if(nums.length==0)
            return new int[0];
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=0;i<k && i<nums.length;i++)
        {
            while(dq.size()>0 && nums[i]>nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
        }    
        int []res=new int[nums.length-k+1];
        res[0]=nums[dq.peekFirst()];
        for(int i=k;i<nums.length;i++)
        {
            while(dq.size()>0 && nums[i]>nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
            while(dq.size()>0 && dq.peekFirst()<=i-k)
                dq.pollFirst();
            res[i-k+1]=nums[dq.peekFirst()];
        }
        return res;
    }
}
