class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size()==0 || nums2.size()==0) return  -1;
        vector<int> vec1;
        vector<int> vec2;
        if(nums1[0]<=nums2[0]){
            //nums 1 smaller
            vec1=nums1;
            vec2=nums2;
       }else{
            vec1=nums2;
            vec2=nums1;
        }


        for(int i=0;i<vec1.size();i++){
            if(binary_search(vec2.begin(),vec2.end(),vec1[i])){
                return vec1[i];
            }
        }
        return -1;
    }
};