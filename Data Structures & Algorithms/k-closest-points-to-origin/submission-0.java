class Solution {
    public int[][] kClosest(int[][] points, int k) 
    {
        PriorityQueue<List<Integer>>pq=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        for(int i=0;i<points.length;i++)
        {
            pq.offer(Arrays.asList(points[i][0]*points[i][0]+points[i][1]*points[i][1],points[i][0],points[i][1]));
        }   
        int [][]res=new int [k][2]; 
        for(int i=0;!pq.isEmpty() && i<k;i++)
        {
            List<Integer>t=pq.poll();
            res[i][0]=t.get(1);
            res[i][1]=t.get(2);
        }
        return res;
    }
}
