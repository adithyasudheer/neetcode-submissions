class Solution {
    public int eraseOverlapIntervals(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int c=0,pstart=0,pend=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(i==0)
            {
                pstart=intervals[i][0];
                pend=intervals[i][1];
            }
            else if(pend>intervals[i][0])//if there is overlap
            {
                c++;
                if(intervals[i][1]<pend)
                {
                    pstart=intervals[i][0];
                    pend=intervals[i][1];
                }
            }
            else
            {
                pstart=intervals[i][0];
                pend=intervals[i][1];
            }
        }    
        return c;
    }
}
