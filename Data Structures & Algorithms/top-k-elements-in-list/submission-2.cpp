class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) 
    {
        priority_queue<pair<int,int>, vector<pair<int,int>>>pq;
        unordered_map<int,int>um;
        for(int x:nums)
        {
            um[x]++;
        }
        for(auto x:um)
        {
            pq.push(make_pair(x.second,x.first));
        }
        vector<int>res;
        while(k)
        {
            res.push_back(pq.top().second);
            pq.pop();
            k--;
        }
        return res;
    }
};
