class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> triangle;
        vector<int> row1;
        row1.push_back(1);
        triangle.push_back(row1);


        for(int i=1;i<numRows;i++){
            cout<<i<<endl;
            vector<int> row;
            row.push_back(triangle[i-1][0]);
            for(int j=1;j<triangle[i-1].size();j++){
                row.push_back(triangle[i-1][j-1]+triangle[i-1][j]);                
            }
            row.push_back(triangle[i-1][triangle[i-1].size()-1]);
            triangle.push_back(row);
        }
        
        return triangle;
    }
};