
class Solution {
        map<pair<int,int>,bool> pacific,atlantic;
        int directions[4][2]=
        {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        int rows,cols;
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        rows=heights.size();
        cols=heights[0].size();
        for(int i=0;i<rows;i++){
            pacific[make_pair(i,0)]=true;
            atlantic[make_pair(i,cols-1)]=true;
        }
        for(int j=0;j<heights[0].size();j++){
            pacific[make_pair(0,j)]=true;
            atlantic[make_pair(rows-1,j)]=true;
        }

        vector<vector<int>> ans;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                set<pair<int,int>> visitedAtl,visitedPac;
                bool atl,pac;

                if(atlantic.find(make_pair(i,j))!= atlantic.end())
                    atl=atlantic[make_pair(i,j)];
                else{
                    atl=dfs(heights,i,j,false,visitedAtl);
                    atlantic[make_pair(i,j)]=atl;
                }


                if(pacific.find(make_pair(i,j))!= pacific.end())
                    pac=pacific[make_pair(i,j)];
                else{
                    pac=dfs(heights,i,j,true,visitedPac);
                    pacific[make_pair(i,j)]=pac;
                }

                if(atl && pac){
                    vector<int> temp;
                    temp.push_back(i);
                    temp.push_back(j);
                    ans.push_back(temp);
                }
            }
        }
        return ans;
    }

    bool dfs(vector<vector<int>>& heights,int i,int j,bool pac,set<pair<int,int>> v){
        //dfs

        if(pac&&(i==0||j==0)) return true;
        if(!pac&&(i==rows-1||j==cols-1)) return true;
        v.insert(make_pair(i,j));
        for(int di=0;di<4;di++){
            if(directions[di][0]+i<0 || directions[di][0]+i>=rows) continue;
            if(directions[di][1]+j<0 || directions[di][1]+j>=cols) continue;

            if(v.find(make_pair(directions[di][0]+i,directions[di][1]+j))==v.end()
               && (heights[i][j] >= heights[directions[di][0]+i][directions[di][1]+j])){

               bool temp;

                if(pac&&pacific.find(make_pair(directions[di][0]+i,directions[di][1]+j))!=pacific.end())
                    temp = pacific[make_pair(directions[di][0]+i,directions[di][1]+j)];
                else if(!pac && atlantic.find(make_pair(directions[di][0]+i,directions[di][1]+j))!=atlantic.end())
                    temp = atlantic[make_pair(directions[di][0]+i,directions[di][1]+j)];
                else
                    temp = dfs(heights,directions[di][0]+i,directions[di][1]+j,pac,v);
                if(temp) return true;
            }

        }
        return false;
    }

};
