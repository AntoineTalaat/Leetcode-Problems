class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> v;
        if(strs.size()==0) return v;
        
        vector<string> cpy=strs;
        for(int i=0;i<strs.size();i++) sort(cpy[i].begin(),cpy[i].end());
        
        map<string,vector<string>> m;
        for(int i=0;i<strs.size();i++){
            if(m.find(cpy[i])!=m.end()){
                m[cpy[i]].push_back(strs[i]);
            }else{
                vector<string> temp;
                temp.push_back(strs[i]);
                m[cpy[i]]=temp;
            }
        }
        
        
        for(auto const& x : m){
            v.push_back(x.second);    
        }
        return v;
    }

};