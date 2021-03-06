package us.supercheng.algorithm.problems.leetcode.singlenumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int [] arr = {4,1,2,1,2};
        int a = app.singleNumber3(arr);
        System.out.println("Final Result: " + a);
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1;i += 2) {
            int num = nums[i];
            if(num != nums[i+1]) {
                return num;
            }
        }
        return nums[nums.length-1];
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber3(int[] nums) {
        int each = 0;
        for(int i=0;i<nums.length;i++) {
            System.out.println("Before: " + each + " i: " + nums[i]);
            each ^= nums[i];
            System.out.println("After: " + each + " i: " + nums[i]);
        }
        return each;
    }
}