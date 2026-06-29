class Solution {
    int l;
    String res;
    public String longestPalindrome(String s) 
    {
        if(s.length()==0)
            return "";
        if(s.length()==1)
            return s;
        l=1;
        res=s.substring(0,1);
        for(int i=0;i<s.length();i++)
        {
            //even
            for(int k=i,j=i+1;k>=0 && j<s.length() ;k--,j++)
            {
                if(s.charAt(k)!=s.charAt(j))
                    break;
                if(j-k+1>l)
                {
                    l=j-k+1;
                    res=s.substring(k,j+1);
                }
                
            }
            //odd
            for(int k=i-1,j=i+1;k>=0 && j<s.length() ;k--,j++)
            {
                if(s.charAt(k)!=s.charAt(j))
                    break;
                if(j-k+1>l)
                {
                    l=j-k+1;
                    res=s.substring(k,j+1);
                }
            }
        }
        return res;
    }
}
