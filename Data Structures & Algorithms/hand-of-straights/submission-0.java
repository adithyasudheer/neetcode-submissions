class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        if(hand.length%groupSize!=0)
            return false;
        Map<Integer,Integer>m=new HashMap<>();
        for(int x:hand)
        {
            m.put(x,m.getOrDefault(x,0)+1);
        }    
        Arrays.sort(hand);
        for(int x:hand)
        {
            if(m.getOrDefault(x,0)>0)
            {
                for(int i=0;i<groupSize;i++)
                {
                    if(m.getOrDefault(x+i,0)<=0)
                        return false;
                    m.put(x+i,m.getOrDefault(x+i,0)-1);
                }
            }
        }
        return true;
    }
}
