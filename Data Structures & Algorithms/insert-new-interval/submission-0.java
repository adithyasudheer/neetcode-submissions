class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        List<int[]>res=new ArrayList<>();
        int i=0;
        while(i<intervals.length)
        {
            if(intervals[i][1] >= newInterval[0])
                break;
            res.add(intervals[i]);
            i++;
        }    
        while(i<intervals.length)
        {
            if(newInterval[1]<intervals[i][0])
                break;
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<intervals.length)
        {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
