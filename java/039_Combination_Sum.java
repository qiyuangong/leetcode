//039_Combination_Sum
class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int clen =candidates.length;
        for (int i = 0; i < clen; i++) {
            List<Integer> tlist = new ArrayList<Integer>();
            tlist.add(candidates[i]);
            backtracking(candidates, i, 1, (target - candidates[i]), tlist);
        }
        return answer;
    }
    private void backtracking(int[] candidates, int index, int tsize, int target, List<Integer> temp) {
        if (target == 0) {
            answer.add(new ArrayList(temp));
            return;
        }
        
        for (int i = index, len = candidates.length; i < len; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                backtracking(candidates, i, (tsize + 1), (target - candidates[i]), temp);
                temp.remove(tsize);
            }
        }
    }
}

