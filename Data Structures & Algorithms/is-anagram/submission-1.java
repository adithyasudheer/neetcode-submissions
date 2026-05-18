class Solution {
    public boolean isAnagram(String s, String t) 
    {
        char []sc=s.toCharArray();
        char []st=t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(st);
        if(Arrays.equals(st,sc))
            return true;
        return false;
    }
}
