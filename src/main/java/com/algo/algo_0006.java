package com.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2019-11-12
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class algo_0006 {

/*    public static String convert(String s, int numRows) {
        if(numRows < 2)
            return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);

            if(i == 0 || i == numRows -1)
                flag = - flag;

            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows)
            res.append(row);

        return res.toString();
    }*/


    // 打印Z字型
    public static String convertAndPrintZ(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>(numRows);
        int rows = 0;
        while(rows < numRows){
            list.add(new StringBuilder());
            rows ++;
        }
        int i = 0;
        int flag = -1;
        for(char c : s.toCharArray()){
            list.get(i).append(c);
            if(i == 0 || i == numRows - 1){
                flag = flag * -1;
            }

            if(i != 0 && i != numRows - 1 && flag == -1){
                int j = i+flag;
                while(j >= 0 && j < numRows -1 ) {
                    list.get(j).append(" ");
                    j --;
                }
                int k = i-flag;
                while(k > 0 && k <= numRows -1 ) {
                    list.get(k).append(" ");
                    k ++;
                }
            }

            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            System.out.println(""+sb.toString());
            res.append(sb);
        }
        return res.toString();
    }

    public static String convert_01(String s, int numRows){
        if(numRows == 1 || s.length() <= numRows)
            return s;
        List<StringBuilder> list = new ArrayList<>(numRows);
        int size = 0;
        while(size < numRows){
            list.add(new StringBuilder());
            size ++;
        }
        int i = 0;
        int flag = -1;
        for(char c : s.toCharArray()){
            list.get(i).append(c);
            if(i == 0 || i == numRows - 1){
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            res.append(sb);
        }
        return res.toString();
    }

    public static String convert_02(String s, int numRows) {
        if(numRows == 1)
            return s;

        int len = Math.min(s.length(), numRows);
        String []rows = new String[len];
        for(int i = 0; i< len; i++) rows[i] = "";
        int loc = 0;
        boolean down = false;

        for(int i=0;i<s.length();i++) {
            rows[loc] += s.substring(i,i+1);
            if(loc == 0 || loc == numRows - 1)
                down = !down;
            loc += down ? 1 : -1;
        }

        String ans = "";
        for(String row : rows) {
            ans += row;
        }
        return ans;
    }

    public static void main(String[] args) {
       // System.out.println(convertAndPrintZ("ABCDEFGHIJKLMNOPQRSTU",5));
        System.out.println(convert_01("LEETCODEISHIRING",16));
    }
}
