class Solution {
public:
    int maxProfit(vector<int>& prices) 
    {
        vector<int>v(prices.size(),0);
        int mx;
        for(int i=prices.size()-1;i>=0;i--)
        {
            if( i== prices.size()-1 )
                mx=prices[i];
            else
                mx=max(mx,prices[i]);
            v[i]=mx;
        }
        mx=0;    
        for(int i=0;i<prices.size();i++)
            mx=max(mx,v[i]-prices[i]);
        return mx;
    }
};
