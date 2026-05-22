class Solution {
public:
    int subarraySum(vector<int>& nums, int k) 
    {
        map<int,int>m;
        int c=0,s=0;
        m[0]=1;
        for(int i=0;i<nums.size();i++)
        {
            s+=nums[i];
            
            //if(s==k)
            //    c++;
            if(m.find(s-k)!=m.end())
                c+=m[s-k];
            m[s]++;
        }    
        return c;
    }
};