package us.supercheng.algorithm.problems.leetcode.keyboardrow;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String [] arr = {"Hello", "Alaska", "Dad", "Peace"};
        PrintHelper.echoLn(Arrays.toString(new App().findWords(arr)));
        PrintHelper.echoLn(Arrays.toString(new App().findWords2(arr)));
    }

    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        // 3rd Row
        map.put('z',3);
        map.put('x',3);
        map.put('c',3);
        map.put('v',3);
        map.put('b',3);
        map.put('n',3);
        map.put('m',3);
        map.put('Z',3);
        map.put('X',3);
        map.put('C',3);
        map.put('V',3);
        map.put('B',3);
        map.put('N',3);
        map.put('M',3);
        // 2nd Row
        map.put('a',2);
        map.put('s',2);
        map.put('d',2);
        map.put('f',2);
        map.put('g',2);
        map.put('h',2);
        map.put('j',2);
        map.put('k',2);
        map.put('l',2);
        map.put('A',2);
        map.put('S',2);
        map.put('D',2);
        map.put('F',2);
        map.put('G',2);
        map.put('H',2);
        map.put('J',2);
        map.put('K',2);
        map.put('L',2);
        ArrayList<String> list = new ArrayList<>();
        for(String each : words) {
            if(each.length() > 1) {
                Integer row = map.get((each.charAt(0)));
                for(int i=1;i<each.length();i++) {
                    if(row != map.get(each.charAt(i)))
                        break;
                    if(i==each.length()-1)
                        list.add(each);
                }
            } else
                list.add(each);
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] findWords2(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            char[] chars = words[i].toCharArray();
            boolean isToAdd = true;
            int rowIndex = this.getRowNum(chars[0]);
            for(int j=1;j<chars.length && chars.length > 1;j++) {
                if(rowIndex != this.getRowNum(chars[j])) {
                    isToAdd = false;
                    break;
                }
            }
            if(isToAdd)
                list.add(words[i]);
        }
        return list.toArray(new String[list.size()]);
    }

    private int getRowNum(char ch) {
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";
        if(row2.indexOf(ch) >=0)
            return 2;
        if(row3.indexOf(ch) >=0)
            return 3;
        return 1;
    }
}