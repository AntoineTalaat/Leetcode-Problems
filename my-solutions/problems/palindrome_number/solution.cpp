class Solution {
public:
    bool isPalindrome(int x) {
        long long ans=0;
        int temp=x;
        while(temp>0){
            ans+=temp%10;
            temp/=10;
            if(temp!=0) ans*=10;
        }
        return ans==x;
    }
};