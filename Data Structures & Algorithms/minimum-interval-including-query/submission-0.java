class Query{
    int val,index;
    Query(int v,int i)
    {
        val=v;
        index=i;
    }
}
class PriorityEntry{
    int len,end;
    PriorityEntry(int l, int e)
    {
        len=l;
        end=e;
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) 
    {
        List<Query>lq=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            Query q=new Query(queries[i],i);
            lq.add(q);
        }
        Collections.sort(lq,(a,b)->Integer.compare(a.val,b.val));
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<PriorityEntry>pq=new PriorityQueue<>((a,b)->Integer.compare(a.len,b.len));
        int[]res=new int[queries.length];
        int idx=0;
        for(int i=0;i<lq.size();i++)
        {
            while(idx<intervals.length && intervals[idx][0]<=lq.get(i).val)
            {
                PriorityEntry pe=new PriorityEntry(intervals[idx][1]-intervals[idx][0]+1,intervals[idx][1]);
                pq.offer(pe);
                idx++;
            }
            boolean flag=false;
            while(!pq.isEmpty())
            {
                if(pq.peek().end<lq.get(i).val)
                    pq.poll();
                else
                {
                    res[lq.get(i).index]=pq.peek().len;
                    flag=true;
                    break;
                }
            }
            if(flag==false)
                res[lq.get(i).index]=-1;
        }
        return res;
    }
}
