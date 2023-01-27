class Solution {
    public int dayOfYear(String date) {
        String[] dateParts = date.split("-");
        if(dateParts.length!=3) 
            System.out.println("weird stuff");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        int[] monthLength={0, 31,28,31 ,30,31,30 ,31,31,30 ,31,30,31};

        int diff=day;
        for(int i=1;i<month;i++)
            diff+=monthLength[i];

        if(month>2 && year%4==0){
            if(year%100!=0) //not a century
                diff+=1;
            else{
                if(year%400==0)
                    diff+=1;
            }
        }
        

        return diff;
    }
}