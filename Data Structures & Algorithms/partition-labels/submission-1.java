class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer>m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i), i);

        }
        List<Integer>res=new ArrayList<>();
        int start = 0;
        int endpos = 0;

        for (int i = 0; i < s.length(); i++) {

            endpos = Math.max(endpos, m.get(s.charAt(i)));

            if (i == endpos) {
                res.add(endpos - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
