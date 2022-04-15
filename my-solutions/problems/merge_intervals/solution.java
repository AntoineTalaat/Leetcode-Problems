class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result=new ArrayList<>();
        
        Arrays.sort(intervals, (Comparator) (o1, o2) -> {
                int[] x = (int[]) o1;
                int[] y =  (int[]) o2;

                if(x[0] == y[0]) return 0;
                else if(x[0]>y[0]) return 1;
                else return -1;
            });
        
        int subStart=intervals[0][0];
        int subEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=subEnd){
                //overlapping
                subEnd=Math.max(intervals[i][1],subEnd);
            } else {
                int[] temp = new int[2];
                temp[0]=subStart;
                temp[1]=subEnd;
                result.add(temp);
                
                subStart=intervals[i][0];
                subEnd=intervals[i][1];
            }
        }
        int[] temp = new int[2];
        temp[0]=subStart;
        temp[1]=subEnd;
        result.add(temp);
        
        int[][] output= new int[result.size()][2];
        
        
        for(int i=0;i<result.size();i++){
            output[i][0]=result.get(i)[0];   
            output[i][1]=result.get(i)[1];

        }
        
        return output;
        
        
    }
}