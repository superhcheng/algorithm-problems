package us.supercheng.algorithm.problems.leetcode.singleelementinasortedarray;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int num = 0;

        for (int each : nums)
            num = num ^ each;

        return num;
    }
}