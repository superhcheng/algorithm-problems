package us.supercheng.algorithm.problems.test;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String s = "aabb";
        Solution app = new Solution();
        List<List<String>> res = app.partition(s);

        for(List<String> row : res) {
            for(String each : row)
                PrintHelper.echo(each + ", ");
            PrintHelper.echoLn("");
        }
    }

    public List<List<String>> partition(String s) {
        if(s == null || s.length() < 1)
            return new ArrayList();

        List<List<String>> ret = new ArrayList();
        this.helper(ret, new ArrayList(), s);
        return ret;
    }

    private void helper(List<List<String>> ret, List<String> list, String s) {
        if(s.length() == 0) {
            ret.add(new ArrayList(list));
            return;
        }

        for(int i=0;i<s.length();i++) {
            String each = s.substring(0, i+1);
            if(this.isP(each)) {
                list.add(each);
                this.helper(ret, list, s.substring(i+1));
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isP(String a) {
        if(a.length() == 1)
            return true;
        for(int l=0,r=a.length()-1;l<r;l++,r--)
            if(a.charAt(l) != a.charAt(r))
                return false;
        return true;
    }
}