import java.util.*;


class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int[] prefixSum=new int[nums.length+1];
        
        int count=0;
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        prefixSum[0]=0;
        for(int i=1;i<nums.length+1;i++){
                prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }
        
        
        
        
        for(int i=0;i<=nums.length;i++){
          
            if(ht.get(prefixSum[i]-k)!=null){
                count+=ht.get(prefixSum[i]-k);
            }
            Integer prev= ht.get(prefixSum[i]);
            if(prev!=null)  ht.put(prefixSum[i],prev +1 );
            else ht.put(prefixSum[i],1);
            
        }
    
        return count;
    }
}