class Solution {
    public String minWindow(String s, String t) 
    {
        if(t.length()>s.length())
            return "";
        Map<Character,Integer>hms=new HashMap<>();
        Map<Character,Integer>hmt=new HashMap<>();
        for(int i=0;i<t.length();i++)
            hmt.put(t.charAt(i),hmt.getOrDefault(t.charAt(i),0)+1);
        int needs=hmt.size(), have=0, minLen=Integer.MAX_VALUE;
        String ans="";
        for(int i=0,j=0;i<s.length();i++)
        {
            hms.put(s.charAt(i),hms.getOrDefault(s.charAt(i),0)+1);
            if(hmt.containsKey(s.charAt(i)) && hms.get(s.charAt(i))==hmt.get(s.charAt(i)))
            {
                have++;
            }
            
            if(have==needs)
            {
                if(i-j+1<minLen)
                {
                    ans=s.substring(j,i+1);
                    minLen=i+1-j;
                }
                while(j<i && have==needs)
                {
                    hms.put(s.charAt(j),hms.get(s.charAt(j))-1);
                    if(hmt.containsKey(s.charAt(j)) && hms.get(s.charAt(j))<hmt.get(s.charAt(j)))
                    {
                        have--;
                    }
                    j++;
                    if(have==needs && i-j+1<minLen)
                    {            
                        ans=s.substring(j,i+1);
                        minLen=i+1-j;
                    }
                }
            }            
        }
        return ans;
    }
}
