class Solution {
public:
    bool squareIsWhite(string coordinates) {
        //even black, odd white
        char letter=coordinates[0];
        char num=coordinates[1];
        
        int res=letter-'a'+num-'1';
        return res%2==1;
    }
};