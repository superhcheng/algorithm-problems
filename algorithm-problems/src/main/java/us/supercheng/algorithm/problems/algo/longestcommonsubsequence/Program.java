package us.supercheng.algorithm.problems.algo.longestcommonsubsequence;

import java.util.*;

public class Program {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<Character> ret = new ArrayList<>();
        int len1 = str1.length();
        int len2 = str2.length();

        String[][] dp = new String[len1+1][len2+1];
        Arrays.fill(dp[0], "");
        for (int i=1; i<=len1; i++)
            dp[i][0] = "";

        for (int i=1; i<=len1; i++)
            for (int j=1; j<=len2; j++) {
                char a = str1.charAt(i-1);
                if (a == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + a;
                else
                    dp[i][j] = dp[i][j-1].length() > dp[i-1][j].length() ? dp[i][j-1] : dp[i-1][j];
            }

        for (char c : dp[len1][len2].toCharArray())
            ret.add(c);

        return ret;
    }

}

