class PrefixNode{
    PrefixNode []next=new PrefixNode[26];
    boolean wordExists;
    PrefixNode()
    {
        for(int i=0;i<26;i++)
            next[i]=null;
        wordExists=false;
    }
}
class PrefixTree {
    PrefixNode root;
    public PrefixTree() {
        root=new PrefixNode();
    }

    public void insert(String word) 
    {
        PrefixNode ptr=root;
        for(int i=0;i<word.length();i++)
        {
            if(ptr.next[word.charAt(i)-'a']==null)
            {
                ptr.next[word.charAt(i)-'a']=new PrefixNode();
            }
            ptr=ptr.next[word.charAt(i)-'a'];
        }
        ptr.wordExists=true;
    }

    public boolean search(String word) {
        PrefixNode ptr=root;
        for(int i=0;i<word.length();i++)
        {
            if(ptr.next[word.charAt(i)-'a']==null)
            {
                return false;
            }
            ptr=ptr.next[word.charAt(i)-'a'];
        }
        return ptr.wordExists;
    }

    public boolean startsWith(String prefix) {
        PrefixNode ptr=root;
        for(int i=0;i<prefix.length();i++)
        {
            if(ptr.next[prefix.charAt(i)-'a']==null)
            {
                return false;
            }
            ptr=ptr.next[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
