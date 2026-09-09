class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int tgas=0,tcost=0;
        for(int i=0;i<gas.length;i++)    
        {
            tgas+=gas[i];
            tcost+=cost[i];
        }
        if(tgas<tcost)
            return -1;
        int st=0, tank=0;
        for(int i=0;i<gas.length;i++)
        {
            if(tank<0)
            {
                tank=0;
                st=i;
            }
            tank+=gas[i]-cost[i];
        }
        if(tank<0)
            return -1;
        return st;
    }
}
