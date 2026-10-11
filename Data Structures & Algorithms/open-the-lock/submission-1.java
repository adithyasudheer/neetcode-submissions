class Solution {
    public int openLock(String[] deadends, String target) 
    {
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<deadends.length;i++)
        {
            hs.add(deadends[i]);
        }    
        if(hs.contains("0000"))
            return -1;
        Queue<String>q=new LinkedList<>();
        HashSet<String>vis=new HashSet<>();
        q.add("0000");
        vis.add("0000");
        int count=0;
        while(!q.isEmpty())
        {
            int sz=q.size();
            while(sz>0)
            {            
                String t=q.poll();
                if(t.equals(target))
                    return count;
                
                for(int i=0;i<t.length();i++)
                {
                    char[]ch=t.toCharArray();
                    ch[i]=(char)((ch[i]-'0'+1)%10+'0');
                    String res=new String(ch);
                    if(vis.contains(res)==false && hs.contains(res)==false)
                    {
                        q.offer(res);
                        vis.add(res);
                    }
                    ch=t.toCharArray();
                    ch[i]=(char)((ch[i]-'0'-1+10)%10+'0');
                    String res2=new String(ch);
                    if(vis.contains(res2)==false && hs.contains(res2)==false)
                    {
                        q.offer(res2);
                        vis.add(res2);
                    }
                }
                sz--;
            }
            count++;
        }
        return -1;
    }
}