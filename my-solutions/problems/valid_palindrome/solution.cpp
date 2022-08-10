class Solution {
public:
    bool isPalindrome(string s) {
        int leftptr=0;
        int rightptr=s.size()-1;
        
        while(leftptr<rightptr){
            if(!isalnum(s[leftptr])){
                leftptr++;
                continue;
            }
            
            if(!isalnum(s[rightptr])){
                rightptr--;
                continue;
            }
            
            
            if(tolower(s[rightptr])!=tolower(s[leftptr]))
                return false;
            rightptr--;
            leftptr++;
            
        }
        return true;
    }
};