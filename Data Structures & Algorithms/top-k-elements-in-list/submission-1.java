class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int x:nums)
        {
            hm.put(x,hm.getOrDefault(x,0)+1);
        }   
        List<int[]>ls=new ArrayList<>(); 
        for(Map.Entry<Integer,Integer> e:hm.entrySet())
        {
            ls.add(new int[]{e.getValue(),e.getKey()});
        }
        ls.sort((a,b)->b[0]-a[0]);
        int []res=new int[k];
        for(int i=0;i<k&&i<ls.size();i++)
        {
            res[i]=(ls.get(i)[1]);
        }
        return res;
    }
}
