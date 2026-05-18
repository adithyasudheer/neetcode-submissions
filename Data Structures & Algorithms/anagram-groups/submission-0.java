class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>res=new ArrayList<>();
        HashMap<String,List<String>>hm=new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++)
        {
            char [] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String key=new String(temp);
            if(hm.containsKey(key))
                hm.get(key).add(strs[i]);
            else
            {
                ArrayList<String>ls=new ArrayList<>();
                ls.add(strs[i]);
                hm.put(key,ls);
            }
        }
        for(List<String> x:hm.values())
        {
            res.add(x);
        }
        return res;
    }
}
