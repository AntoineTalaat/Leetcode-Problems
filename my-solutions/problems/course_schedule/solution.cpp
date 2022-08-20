class Solution {
    vector<vector<int>> graph;
    bool done[];

public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        bool starting[numCourses];
        bool done[numCourses];
        for(int i=0;i<numCourses;i++) {
            vector<int> temp;
            graph.push_back(temp);
            starting[i]=true;
            done[i]=false;
        }
        for(int i=0;i<prerequisites.size();i++){
            graph[prerequisites[i][1]].push_back(prerequisites[i][0]);
            starting[prerequisites[i][0]]=false;
        }
        
        bool ans=true;
        for(int i=0;i<numCourses;i++){
            if(starting[i]) {
                map<int,bool> sequence;
                if(!done[i])
                    done[i]=dfs(sequence,i,done);
            }
        }
        
        for(int i=0;i<numCourses;i++) {ans = ans&& done[i];
                                      // cout<<done[i]<<"\n";
                                      }
        
        return ans;
    }
    
    bool dfs(map<int,bool> visited,int node,bool* done){
        // cout<<"dfs now "<<node<<"\n";
        visited[node]=true;
        bool res=true;
        for(int n:graph[node]){
            if(visited[n]) return false;
            else {
                if(done[n]) res = true;
                else res= dfs(visited,n,done);
                
                
                if(res) done[n]=res;
                else return false;
            }
        }
        done[node]=res;
        return res;
    }
};