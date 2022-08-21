class Solution {
    map<int,int> steps;

public:
    int climbStairs(int n) {
        steps[1]=1;
        steps[2]=2;
        steps[0]=0;
        
        return getSteps(n);
        
        
    }
    
    int getSteps(int n){
        if(n<=2) return steps[n];
        else if(steps[n]>0) return steps[n];
        else{
            int x=getSteps(n-1);
            steps[n-1]=x;
            int y=getSteps(n-2);
            steps[n-2]=y;
            steps[n]=x+y;
            return x+y;
            
        }
    }
};