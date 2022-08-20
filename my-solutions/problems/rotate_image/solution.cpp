class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n=matrix.size();
        
        for(int i=0;i<n/2;i++)
            swapRows(matrix,i,n-i-1);
            
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swapSquares(matrix,i,j,j,i);
            }
        }
        
        
    }
    
    void swapRows(vector<vector<int>>& matrix,int r1,int r2){
        for(int i=0;i<matrix.size();i++){
            swapSquares(matrix,r1,i,r2,i);
        }
    }
    
    void swapSquares(vector<vector<int>>& matrix,int r1,int c1,int r2,int c2){
        int temp=matrix[r1][c1];
        matrix[r1][c1]=matrix[r2][c2];
        matrix[r2][c2]=temp;
    }
    
    
    
    // 7 4 9
    // 2 5 8
    // 1 6 3
    
};