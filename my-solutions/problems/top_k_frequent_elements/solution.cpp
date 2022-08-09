class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {

        map<int,int> m;
        int mx=0;
        for(int i=0; i<nums.size();i++){
            int curr = ++m[nums[i]];
            if(curr>mx) mx=curr;
        }

        vector<int> v[mx];
        for(auto const& x : m){
            int mxLvl = x.second;     
            v[mxLvl-1].push_back(x.first);
            
        }
        vector<int> allx;
        for(int i=mx-1 ; i>=0 ;i--)
            for(int j=0;j<v[i].size();j++)
                allx.push_back(v[i][j]);
        
        vector<int> temp;
        for(int i=0;i<k;i++) temp.push_back(allx[i]);
        return temp;
    }
};