class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int size =nums.size();
        vector<int> prefsum(size,0);
        prefsum[0]=nums[0];
        for(int i=1;i<nums.size();i++){
            prefsum[i] = prefsum[i-1]+nums[i];
        }
        int last=nums.size()-1;
        for(int i=0;i<nums.size();i++){
            if(prefsum[i] - nums[i] == prefsum[last]- prefsum[i]){
                return i;
            }
        }
        return -1;
    }
};