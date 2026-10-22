class Solution {
    public boolean canReach(String s, int minJump, int maxJump)
    {
        boolean []f=new boolean [s.length()];
        Arrays.fill(f,false);
        for(int i=0;i<s.length();i++)
        {
            if((i==0 && s.charAt(i)=='0')||(f[i]==true))
            {
                for(int j=i+minJump;j<=i+maxJump && j<s.length() ;j++)
                {
                    if(s.charAt(j)=='0')
                    {
                        f[j]=true;
                        if(j==s.length()-1)
                            return true;
                    }
                }
            }
        }  
        return f[s.length()-1];  
    }
}