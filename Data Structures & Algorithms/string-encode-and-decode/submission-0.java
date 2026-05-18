class Solution {

    public String encode(List<String> strs) 
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.size();i++)
        {
            sb.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) 
    {
        List<String>res=new ArrayList<>();
        for(int j=0,i=0;i<str.length();)
        {
            while(str.charAt(i)!='#')
                i++;
            int len=Integer.parseInt(str.substring(j,i));
            i++;
            String temp=str.substring(i,i+len);
            res.add(temp);
            i+=len;
            j=i;
        }
        return res;
    }
}
