class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
        if(s.size()<=1)
            return s.size();
        int i=0,j=1;
        unordered_set<char>us;
        us.insert(s[i]);
        int mx=0;
        while(j<s.size())
        {
            if(us.find(s[j])!=us.end())
            {
                mx=max(mx,j-i);
                while(i<j && us.find(s[j])!=us.end())
                {
                    us.erase(s[i]);
                    i++;
                }
            }
            us.insert(s[j]);
            mx=max(mx,j-i+1);
            j++;
        }
        return mx;
    }
};
