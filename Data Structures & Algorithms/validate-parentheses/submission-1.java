class Solution {
    public boolean isValid(String s) 
    {
        Deque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='['||ch=='{'||ch=='(')
                st.push(ch);
            else if(st.isEmpty())
                return false;
            else
            {
                char t=st.peek();
                if((t=='[' && ch!=']')||(t=='{' && ch!='}')||(t=='(' && ch!=')'))
                    return false;
                st.pop();
            }
        }    
        if(!st.isEmpty())
            return false;
        return true;
    }
}
