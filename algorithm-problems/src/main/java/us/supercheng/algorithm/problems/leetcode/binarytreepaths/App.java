package us.supercheng.algorithm.problems.leetcode.binarytreepaths;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String [] args) {
        App app = new App();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);

        a.left = b;
        b.right = d;
        a.right = c;

        for(String each : app.binaryTreePaths(a))
            System.out.println(each);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null)
            return list;
        this.helper(root, list, "");
        return list;
    }

    public void helper(TreeNode root, List<String> list, String eachStr) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            eachStr += root.val;
            list.add(eachStr);
        } else if(root.left != null && root.right == null) {
            this.helper(root.left, list, eachStr + root.val + "->");
        } else if(root.left == null && root.right != null) {
            this.helper(root.right, list, eachStr + root.val + "->");
        } else {
            this.helper(root.left, list, eachStr + root.val + "->");
            this.helper(root.right, list, eachStr + root.val + "->");
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<String> list = new ArrayList<>();

        if (root.left == null && root.right == null) {
            list.add(Integer.toString(root.val));
            return list;
        }

        if (root.left != null)
            for (String each : this.binaryTreePaths(root.left))
                list.add(root.val + "->" + each);

        if (root.right != null)
            for (String each : this.binaryTreePaths(root.right))
                list.add(root.val + "->" + each);

        return list;
    }
}