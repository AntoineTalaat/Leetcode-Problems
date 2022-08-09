class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> m,im;
        vector<int> ans;
        for(int i=0;i<nums.size();i++) {m[nums[i]]++; im[nums[i]]=i;}
        for(int i=0;i<nums.size();i++) if( m[target - nums[i]]>0 && im[target - nums[i]]!=i){
            ans.push_back(i);
            ans.push_back(im[target - nums[i]]);
            break;
        }
        return ans;
    }
};