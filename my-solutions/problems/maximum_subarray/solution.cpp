



class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0; int bestSum=INT_MIN;
        for(int i=0;i<nums.size();i++){
            sum+= nums[i];
            bestSum = max(bestSum, sum);
            if(sum<0) sum=0;
        }
        return bestSum;

    }


};

