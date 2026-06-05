class Object{
    int count;
    char ch;
    Object(int c,char chr)
    {
        count=c;
        ch=chr;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) 
    {
        Map<Character,Integer>hm=new HashMap<>();
        for(char ch:tasks)
        {
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }    
        PriorityQueue<Object>pq= new PriorityQueue<>((a,b)->{return b.count-a.count;});
        for(Map.Entry<Character,Integer>me:hm.entrySet())
        {
            Object t=new Object(me.getValue(),me.getKey());
            pq.offer(t);
        }
        int resCount=0,tempn=0;
        while(!pq.isEmpty())
        {
            List<Object>lobj=new ArrayList<>();
            tempn=0;
            while(tempn<=n && !pq.isEmpty())
            {
                Object obj=pq.poll();                
                resCount++;
                tempn++;
                obj.count=obj.count-1;
                if(obj.count!=0)
                    lobj.add(obj);
            }
            if (pq.isEmpty() && lobj.isEmpty())
                break;
            if(tempn!=n+1)
                resCount+=n+1-tempn;
            if(lobj.size()>0)
            {
                for(Object o:lobj)
                    pq.offer(o);
            }
        }
        return resCount;
    }
}
