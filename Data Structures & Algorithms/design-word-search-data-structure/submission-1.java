class TrieNode
{
    TrieNode []next=new TrieNode[26];
    boolean isEnd;
    TrieNode()
    {
        isEnd=false;
        for(int i=0;i<26;i++)
            next[i]=null;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
            if(temp.next[word.charAt(i)-'a']==null)
            {
                temp.next[word.charAt(i)-'a']=new TrieNode();
            }
            temp=temp.next[word.charAt(i)-'a'];
        }
        temp.isEnd=true;
    }

    boolean bsearch(String word, int pos,TrieNode r) 
    {
        if(pos==word.length())
        {
            return r.isEnd;
        }            
        if(word.charAt(pos)!='.')
        {
            if(r.next[word.charAt(pos)-'a']!=null)
                return bsearch(word,pos+1,r.next[word.charAt(pos)-'a']);
            else
                return false;
        }
        else
        {
            for(int i=0;i<26;i++)
            {
                if(r.next[i]!=null && bsearch(word,pos+1,r.next[i]))
                    return true;
            }
        }
        return false;
    }

    public boolean search(String word) 
    {
        return bsearch(word,0,root);
    }
}
