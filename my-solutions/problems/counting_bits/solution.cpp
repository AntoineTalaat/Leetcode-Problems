class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> v(n+1);
        for(int i=0;i<=n;i++){
            int temp=i;
            while(temp>0){
                if((temp&1)==1) v[i]++;
                temp=temp>>1;
            }
        }
        return v;
    }
};