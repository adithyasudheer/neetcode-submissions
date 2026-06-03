class MedianFinder {
    PriorityQueue<Integer>maxheap,minheap;
    public MedianFinder() {
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty())
            maxheap.offer(num);
        else if(maxheap.peek()<num)
        {
            minheap.offer(num);
            if(Math.abs(maxheap.size()-minheap.size())>1)
            {
                if(maxheap.size()>minheap.size())
                {
                    int t=maxheap.peek();
                    maxheap.poll();
                    minheap.offer(t);
                }
                else
                {
                    int t=minheap.peek();
                    minheap.poll();
                    maxheap.offer(t);
                }
            }
        }
        else
        {
            maxheap.offer(num);
            if(Math.abs(maxheap.size()-minheap.size())>1)
            {
                if(maxheap.size()>minheap.size())
                {
                    int t=maxheap.peek();
                    maxheap.poll();
                    minheap.offer(t);
                }
                else
                {
                    int t=minheap.peek();
                    minheap.poll();
                    maxheap.offer(t);
                }
            }
        }
    }
    
    public double findMedian() {
        if(maxheap.isEmpty() && minheap.isEmpty())
            return 0.0;
        else if((maxheap.size()+minheap.size())%2==0)
        {
            double val=(maxheap.peek()+minheap.peek())/2.0;
            return val;
        }
        else
        {
            if(maxheap.size()>minheap.size())
                return (double)maxheap.peek();
            else
                return (double)minheap.peek();
        }
    }
}
