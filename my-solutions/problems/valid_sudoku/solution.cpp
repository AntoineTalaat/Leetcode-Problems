class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        set<int> rows[9];
        int rowsNum[9]={0};
        set<int> cols[9];
        int colsNum[9]={0};
        set<int> squares[9];
        int squareNum[9]={0};
        
        int squareDist[9][9]={
            {0,0,0,1,1,1,2,2,2},
            {0,0,0,1,1,1,2,2,2},
            {0,0,0,1,1,1,2,2,2},
            {3,3,3,4,4,4,5,5,5},
            {3,3,3,4,4,4,5,5,5},
            {3,3,3,4,4,4,5,5,5},
            {6,6,6,7,7,7,8,8,8},
            {6,6,6,7,7,7,8,8,8},
            {6,6,6,7,7,7,8,8,8}
        };
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    rows[i].insert(board[i][j]); rowsNum[i]++;
                    cols[j].insert(board[i][j]); colsNum[j]++;
                    squares[squareDist[i][j]].insert(board[i][j]); squareNum[squareDist[i][j]]++;
                }
            }
        }
        
        bool result = true;
        for(int i=0;i<9;i++) result = result && (rowsNum[i]==rows[i].size());
        for(int i=0;i<9;i++) result = result && (colsNum[i]==cols[i].size());
        for(int i=0;i<9;i++) result = result && (squareNum[i]==squares[i].size());

        return result;
        
        
    }
};