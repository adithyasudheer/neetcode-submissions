class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) 
    {
        int j=0;
        ArrayList<int[]>ls=new ArrayList<>();
        for(int i=0;i<triplets.length;i++)
        {
            for(j=0;j<3;j++)
            {
                if(triplets[i][j]>target[j])
                    break;
            }
            if(j==3)
                ls.add(triplets[i]);
        }
        int c=0;
        boolean flag[]=new boolean[3];
        for(int i=0;i<3;i++)
            flag[i]=false;
        for(int i=0;i<ls.size();i++)
        {
            for(j=0;j<3;j++)
            {
                if(ls.get(i)[j]==target[j])
                {
                    flag[j]=true;
                }
            }   
        }
        for(int i=0;i<3;i++)
            if(flag[i]==false)
                return false;
        return true;
    }
}
