package us.supercheng.algorithm.problems.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null)
            return ret;
        if(nums.length == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            ret.add(temp);
            return ret;
        }

        for(int i=0;i<nums.length;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            this.helper(nums, i, ret, list);
        }

        return ret;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ret, List<Integer> list) {
        if(index > nums.length-1)
            return;

        if(list.size() == nums.length) {
            ret.add(list);
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(i!=index) {
                List<Integer> temp = new ArrayList<>();
                boolean dupFlag = false;
                for(Integer each : list) {
                    if(each == nums[i]) {
                        dupFlag = true;
                        break;
                    }
                    temp.add(each);
                }
                if(!dupFlag) {
                    temp.add(nums[i]);
                    this.helper(nums, i, ret, temp);
                }
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ret;

        boolean [] visited = new boolean[nums.length];
        this.dfs(ret, nums, 0, new ArrayList<>(), visited);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int[] nums, int idx, List<Integer> list, boolean [] visited) {
        if(list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i=0;i<nums.length;i++)
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                this.dfs(ret, nums, i+1, list, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
    }
}