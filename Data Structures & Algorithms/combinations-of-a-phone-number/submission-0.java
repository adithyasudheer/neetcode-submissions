class Solution {
    private void getcomb(String digits,Map<String,String>m,List<String>res, int idx,String temp)
    {
        if(idx==digits.length())
        {
            res.add(new String(temp));
            return;
        }
        String values = m.getOrDefault(String.valueOf(digits.charAt(idx)), "");
        for(int i=0;i<values.length();i++)
        {
            getcomb(digits,m,res,idx+1,temp+values.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits)
    {
        if(digits.length()==0)
            return new ArrayList<>();
        Map<String,String>m=new HashMap<>();
        m.put("2","abc");
        m.put("3","def");
        m.put("4","ghi");
        m.put("5","jkl");
        m.put("6","mno");
        m.put("7","pqrs");
        m.put("8","tuv");
        m.put("9","wxyz");    
        List<String>ls=new ArrayList<>();
        getcomb(digits,m,ls,0,"");
        return ls;
    }
}
