class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int removed=0;
        int last = nums.size()-1;
        int pointer = last;

        while(pointer>=0){
            if(nums[pointer] == val){
                swap(nums[pointer],nums[last]);
                last--;
                removed++;
            }
            pointer--;
        }
        // cout<<nums.size()<<endl;
        // nums.resize(nums.size()-removed);
        // cout<<nums.size()<<endl;
        // for(int i=0;i<nums.size();i++)
        //     cout<<nums[i]<<" ";
        return nums.size()-removed;
    }
};