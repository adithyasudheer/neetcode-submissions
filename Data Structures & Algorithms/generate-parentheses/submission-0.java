class Solution {
    private void gen(int n, int open, int close, List<String>res,String s)
    {
        if(open==close && open==n)
        {
            res.add(s);
            return;
        }
        if(open<n)
        {
            gen(n,open+1,close,res,s+"(");
        }
        if(close<open)
            gen(n,open,close+1,res,s+")");
    }
    public List<String> generateParenthesis(int n) 
    {
        List<String>res=new ArrayList<>();
        gen(n,0,0,res,"");
        return res;    
    }
}
