class Solution {
    int helper(int []coins,int target,int idx)
    {
        if(target==0)
            return 0;
        if(idx<0||idx>coins.length)
            return -1;
        int take=-1,notake=-1;
        if(coins[idx]<=target)
        {
            int res=helper(coins,target-coins[idx],idx);
            if(res!=-1)
                take=1+res;
        }
        notake=helper(coins,target,idx-1);
        if(take!=-1 || notake!=-1)
        {
            if(take!=-1 && notake!=-1)
                return Math.min(take,notake);
            else if(take!=-1)
                return take;
            return notake;
        }
        return -1;
    }
    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount,coins.length-1);
    }
}
