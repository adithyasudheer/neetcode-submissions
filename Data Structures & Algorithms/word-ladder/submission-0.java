class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String>hs=new HashSet<>();
        Set<String>vis=new HashSet<>();
        for(String s:wordList)
            hs.add(s);
        if(!hs.contains(endWord))
            return 0;
        Queue<String>q=new LinkedList<>();
        q.offer(beginWord);
        vis.add(beginWord);
        int count=0;
        while(!q.isEmpty())
        {
            int sz=q.size();
            while(sz!=0)
            {
                String s=q.poll();
                char []chs=s.toCharArray();
                if(s.equals(endWord))
                    return count+1;
                for(int k=0;k<chs.length;k++)
                {
                    char original = chs[k];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[k] = c;
                        String newString = new String(chs);
                        if (hs.contains(newString) && !vis.contains(newString)) {
                            q.offer(newString);
                            vis.add(newString);
                        }
                    }
                    chs[k] = original;
                }
                sz--;
            }
            count++;
        }
        return 0;
    }
}
