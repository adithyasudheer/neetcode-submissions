class Solution {
    public int carFleet(int target, int[] position, int[] speed) 
    {
        double []time=new double [position.length];
        for(int i=0;i<position.length;i++)
            time[i]=(double)(target-position[i])/speed[i];
        Integer []idx=new Integer[position.length];
        for(int i=0;i<position.length;i++)
            idx[i]=i;
        Arrays.sort(idx,(a,b)->{return Integer.compare(position[a],position[b]);});
        double []sortedTime=new double[position.length];
        for(int i=0;i<position.length;i++)
            sortedTime[i]=time[idx[i]];

        Stack<Double>s=new Stack<>();
        for(int i=0;i<position.length;i++)
        {
            if(s.isEmpty())
                s.push(sortedTime[i]);
            else
            {
                while(!s.isEmpty() && sortedTime[i]>=s.peek())
                    s.pop();
                s.push(sortedTime[i]);
            }
        }    
        return s.size();
    }
}