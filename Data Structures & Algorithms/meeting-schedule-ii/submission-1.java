/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) 
    {
        List<int[]>ls=new ArrayList<>();
        for(int i=0;i<intervals.size();i++)
        {
            int[]t=new int[2];
            t[0]= intervals.get(i).start;
            t[1]= 1;
            ls.add(t);
            int[]y=new int[2];
            y[0]= intervals.get(i).end;
            y[1]= -1;
            ls.add(y);
        }
        Collections.sort(ls,(a,b)->{
            if(a[0]!=b[0])
                return Integer.compare(a[0],b[0]);
            else
                return Integer.compare(a[1],b[1]);
        });
        int mx=0,room=0;
        for(int i=0;i<ls.size();i++)
        {
            room+=ls.get(i)[1];
            mx=Math.max(mx,room);
        }
        return mx;
    }
}
