class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int index1=0;
        int index2=numbers.size()-1;
        vector<int> v;
        while (index1<index2){
            if(numbers[index1]+numbers[index2]<target) index1++;
            else if(numbers[index1]+numbers[index2]>target) index2--;
            else {
                v.push_back(index1+1);
                v.push_back(index2+1);
                break;
            }
        }
        return v;
    }
};