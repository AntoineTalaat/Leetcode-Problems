class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<int> cpy=nums;
        sort(cpy.begin(),cpy.end());
        int s=nums.size();
        vector<vector<int>> v;
        for(int i=0;i<s-1;i++){
            int index1=i+1;
            int index2=s-1;
            
            while(index1<index2){
                if(cpy[i]+cpy[index1]+cpy[index2]==0)
                {
                    vector<int> ans;
                    ans.push_back(cpy[i]);
                    ans.push_back(cpy[index1]);
                    ans.push_back(cpy[index2]);
                    v.push_back(ans);
                    while(index1<index2 && ans[1]==cpy[index1]) index1++;
                    while(index1<index2 && ans[2]==cpy[index2]) index2--;

                }else if(cpy[i]+cpy[index1]+cpy[index2]<0) index1++;
                else index2--;
            }
            
            
            while(i<s-1 && cpy[i+1]==cpy[i]) i++;
        }
        
        return v;
    }
};