class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
    int n = nums.size();
    map<int,int> m;
    for(int i=0;i<n;i++){
        m[nums[i]]++;
    }
    vector<int> v;
    for(int i=1;i<=n;i++)
        if(m.find(i)==m.end())
            v.push_back(i);

    return v;
}
};