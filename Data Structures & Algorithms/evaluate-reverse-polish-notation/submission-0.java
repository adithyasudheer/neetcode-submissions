class Solution {
    public int evalRPN(String[] tokens) 
    {
        Stack<String>st=new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+"))
            {
                int r=Integer.parseInt(st.peek());
                st.pop();
                int l=Integer.parseInt(st.peek());
                st.pop();
                String t=String.valueOf(l+r);
                st.push(t);
            }
            else if(tokens[i].equals("-"))
            {
                int r=Integer.parseInt(st.peek());
                st.pop();
                int l=Integer.parseInt(st.peek());
                st.pop();
                String t=String.valueOf(l-r);
                st.push(t);
            }
            else if(tokens[i].equals("*"))
            {
                int r=Integer.parseInt(st.peek());
                st.pop();
                int l=Integer.parseInt(st.peek());
                st.pop();
                String t=String.valueOf(l*r);
                st.push(t);
            }
            else if(tokens[i].equals("/"))
            {
                int r=Integer.parseInt(st.peek());
                st.pop();
                int l=Integer.parseInt(st.peek());
                st.pop();
                String t=String.valueOf(l/r);
                st.push(t);
            }
            else
            {
                st.push(tokens[i]);
            }
        }    
        int r=Integer.parseInt(st.peek());
        return r;
    }
}
