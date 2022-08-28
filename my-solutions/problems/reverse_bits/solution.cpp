class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t rev=(n&1);
        n=n>>1;
        int bits=32;
        while(n>0 && rev<= INT_MAX){
           
            rev=rev<<1;
            rev=rev|(n&1);
            n=n>>1;
            bits--;
        }
        while(--bits){
                rev=rev<<1;

        }
        return rev;
    }
};