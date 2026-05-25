class Solution {
    public boolean checkInclusion(String s1, String s2)
    {
        if(s2.length()<s1.length())
            return false;
        List<Integer>counts1=new ArrayList<>();
        List<Integer>counts2=new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            counts1.add(i,0);
            counts2.add(i,0);
        }
        for(int i=0;i<s1.length();i++)
        {
            counts1.set(s1.charAt(i)-'a',counts1.get(s1.charAt(i)-'a')+1);
            counts2.set(s2.charAt(i)-'a',counts2.get(s2.charAt(i)-'a')+1);
        }
        if(counts1.equals(counts2))
            return true;
        for(int i=s1.length();i<s2.length();i++)
        {
            counts2.set(s2.charAt(i)-'a',counts2.get(s2.charAt(i)-'a')+1);
            counts2.set(s2.charAt(i-s1.length())-'a',counts2.get(s2.charAt(i-s1.length())-'a')-1);
            if(counts1.equals(counts2))
                return true;
        }
        return false;
    }
}
