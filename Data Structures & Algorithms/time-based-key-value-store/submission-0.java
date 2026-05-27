class Pair{
    String value;
    int timestamp;
    public Pair(String s,int t){
        value=s;
        timestamp=t;
    }
}
class TimeMap {

    Map<String,List<Pair>>m;
    public TimeMap() {
        m=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(m.containsKey(key))
        {
            m.get(key).add(new Pair(value,timestamp));
        }
        else
        {
            m.put(key, new ArrayList<>());
            m.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(m.containsKey(key))
        {
            List<Pair>x=m.get(key);
            String res="";
            int lo=0,hi=x.size()-1,mid;
            while(lo<=hi)
            {
                mid=lo+(hi-lo)/2;
                if(x.get(mid).timestamp<=timestamp)
                {
                    res=x.get(mid).value;
                    lo=mid+1;
                }
                else
                    hi=mid-1;
            }
            return res;
        }
        return "";
    }
}
