class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combineHelper(candidates, target, 0, 0);
        return ans;
    }
    public void combineHelper(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        else if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            combineHelper(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}