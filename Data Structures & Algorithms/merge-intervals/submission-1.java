class Solution {
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(res.isEmpty())
                res.add(intervals[i]);
            else
            {
                int []t=res.get(res.size()-1);
                if(t[1]<intervals[i][0])
                    res.add(intervals[i]);
                else if(t[0]<=intervals[i][1])
                {
                    t[0]=Math.min(t[0],intervals[i][0]);
                    t[1]=Math.max(t[1],intervals[i][1]);
                    res.set(res.size()-1,t);
                }
                else
                    res.add(intervals[i]);
            }
        }    
        return res.toArray(new int [0][]);
    }
}
