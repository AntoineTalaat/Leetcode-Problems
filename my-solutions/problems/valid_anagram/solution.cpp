class Solution {
public:
    bool isAnagram(string s, string t) {
        //hashing works 
        map<int,int> s1,s2;
        for(int i=0;i<s.size();i++) s1[s[i]]++;
        for(int i=0;i<t.size();i++) s2[t[i]]++;
        
        if(s.size()!=t.size()) return false;
        
        bool result = true;
        for(int i=0 ;i<s.size();i++) {
            result = result && s1[s[i]]==s2[s[i]];
            if(result==false) break;
        }
        return result;
        
        }
};