class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = 1 ;
        int max = (int)1e9;
        
        if(m*k>bloomDay.length) return -1;
        while (min<max){
            int mid=(min+max)/2;
            Boolean[] bloomed = new Boolean[bloomDay.length];
            
            for(int i = 0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid) bloomed[i]=true;
                else bloomed[i]=false;
            }
            
            int count=0;
            int bouq=0;
            for(int i=0;i<bloomed.length;i++){
                if(bloomed[i]){
                    count++;
                    if(count==k){
                        bouq++;
                        count=0;        
                }
                } else if(!bloomed[i]){
                    count = 0;
                }
                
                
            }
            
            if(bouq<m)//need more bloomed
                min = mid+1;
            else 
                max = mid;
        }
        return max;
        
    }
    

}