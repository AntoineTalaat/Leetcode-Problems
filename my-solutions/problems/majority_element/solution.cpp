class Solution {
public:
    int majorityElement(vector<int>& nums) {
        return findMajorityElement(nums,0,nums.size()-1);
    }

    int findMajorityElement(vector<int>& nums,int start, int end){
        // base case
        if(start == end) return nums[start];

        // divide
        int mid = (start + end)/2;
        cout << "division is " << start<<" " << mid<< " " << end <<"\n";

        int first = findMajorityElement(nums,start,mid);
        int firstCount = countOccurances(nums,start,end,first);

        int second = findMajorityElement(nums,mid+1,end);
        int secondCount = countOccurances(nums, start,end,second);
        cout<< first << " " << firstCount <<" - " <<second<<" " << secondCount << "\n\n";
        // combine 
        if(secondCount > firstCount)
            return second;
        else 
            return first;
    }

    int countOccurances(vector<int>& nums, int start, int end, int target){
        int counter = 0;
        for(int i=start;i<=end;i++){
            if(target == nums[i])
                counter++;
        }
        return counter;
    }

    
};