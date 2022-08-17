class Solution {
    set<pair<int,int>> visited;
    vector<vector<char>> land;
    int islands=0;
    int rows,cols;

public:
    int numIslands(vector<vector<char>>& grid) {   
        land=grid;
        rows=grid.size();
        if(rows==0){
            return 0;
        } 
        cols=grid[0].size();
        
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited.find(make_pair(i,j))==visited.end() && land[i][j] == '1')
                {
                    bfs(i,j);
                    islands++;
                }
            }
        }
        
        return islands;
            
    }
    
    
    void bfs(int xx,int yy){
        queue<pair<int,int>> q;
        visited.insert(make_pair(xx,yy));
        q.push(make_pair(xx,yy));
        int directions[4][2]={{0,1},{1,0},{-1,0},{0,-1}};
        
                 
        while (q.empty()==false){
            
            pair<int,int> p=q.front();
            q.pop();
            int x,y;
            x=p.first;
            y=p.second;
            

            for(int di=0;di<4;di++){
                int a=directions[di][0];
                int b=directions[di][1];
                if(a+x<rows && b+y<cols 
                   && a+x>=0 && b+y>=0
                   && land[a+x][b+y]=='1'  
                   && visited.find(make_pair(a+x,b+y))==visited.end() )
                    q.push(make_pair(a+x,b+y));
                    visited.insert(make_pair(a+x,b+y));
                
            }
            
        }

        
    }

};