class Solution {
    private void backtrack(int[] candidates, int target, int pos,List<Integer>temp,List<List<Integer>>res)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<0 || pos>=candidates.length)
            return;
        for(int i = pos; i < candidates.length; i++)
        {
            if(i > pos && candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i] > target)
                break;

            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
        // backtrack(candidates, target,pos+1,temp,res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        // Set<List<Integer>>res=new HashSet<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,temp,res);
        // for(List<Integer>x:res)
        //     finalres.add(x);
        return res;
    }
}
