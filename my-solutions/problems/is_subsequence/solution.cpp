class Solution {
public:
    bool isSubsequence(string s, string t) {
        // need to know if s is subsequence of t
        if(s.size()>t.size())
            return false;
        
        int sInd=0;
        int tInd=0;
        int counter = 0;
        while(sInd<s.size()  && tInd<t.size()){
            while(s[sInd]!=t[tInd]  && tInd<t.size()) tInd++;
            if(tInd!=t.size()) {sInd++;tInd++;}
        }
        return sInd==s.size();

        
    }
};