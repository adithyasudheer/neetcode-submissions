class Solution {
    private void getPartitions(String s, int idx, List<List<String>>res,List<String>temp)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            String sub=s.substring(idx,i+1);
            String rev=new StringBuilder(sub).reverse().toString();
            if(rev.equals(sub))
            {
                temp.add(sub);
                getPartitions(s,i+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) 
    {
        List<List<String>>res=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        getPartitions(s,0,res,temp);
        return res;     
    }
}
