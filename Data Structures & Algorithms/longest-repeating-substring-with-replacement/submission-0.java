class Solution {
    public int characterReplacement(String s, int k) 
    {
        int maxfreq=0,l=0,r=0,ans=0;
        HashMap<Character,Integer>hm=new HashMap<>();
        while(r<s.length()) 
        {
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            maxfreq=Math.max(maxfreq,hm.get(s.charAt(r)));
            if(r-l+1-maxfreq>k)
            {
                while(r-l+1-maxfreq>k)
                {
                    hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                    l++;
                }
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }   
        return ans;
    }
}
