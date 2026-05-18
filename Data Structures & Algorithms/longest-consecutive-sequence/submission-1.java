class Solution {
    public int longestConsecutive(int[] nums)
    {
        TreeSet<Integer>ts=new TreeSet<>();
        for(int x:nums)
            ts.add(x);
        int prev=0,count=0,mxcount=0;
        boolean first=false;
        for(Integer x:ts)
        {
            if(first==false)
            {
                prev=x;
                first=true;
                count=1;
                mxcount=1;
            }
            else
            {
                if(x==prev+1)
                {
                    count++;
                    mxcount=Math.max(mxcount,count);
                }
                else
                {
                    count=1;
                }
                prev=x;
            }
        }    
        return mxcount;
    }
}
