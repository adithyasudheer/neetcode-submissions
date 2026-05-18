class Solution {
public:
    bool hasDuplicate(vector<int>& nums) 
    {
        unordered_set<int>us;
        for(int x:nums)
        {
            if(us.find(x)!=us.end())
                return true;
            us.insert(x);
        }    
        return false;
    }
};