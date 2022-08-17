class Solution {
public:
    int maxArea(vector<int>& height) {
        int start=0;
        int end=height.size()-1;
        
        int mx = 0;
        while(start < end){
            mx = max(mx, (end-start)*min(height[start],height[end]));
            if(height[end]>height[start])
                start++;
            else 
                end--;
        }
        return mx;
        
    }
};