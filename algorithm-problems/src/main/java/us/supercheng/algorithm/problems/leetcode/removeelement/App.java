package us.supercheng.algorithm.problems.leetcode.removeelement;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int counter = app.removeElement(arr, 4);
        for(int i=0;i<counter;i++)
            System.out.print(arr[i]);
    }

    public int removeElement(int[] nums, int val) {
        int removeCount = 0;
        for(int i=0;i<nums.length;i++)
            if(nums[i] != val)
                nums[removeCount++] = nums[i];
        return removeCount;
    }

    public int removeElement2(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right)
            if (nums[left] == val)
                nums[left] = nums[--right];
            else
                left++;

        return left;
    }
}