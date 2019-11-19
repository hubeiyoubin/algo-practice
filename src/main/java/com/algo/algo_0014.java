package com.algo;

/**
 * @date : 2019-11-17
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class algo_0014 {

    //逐个匹配
    public String longestCommonPrefix_02(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i ++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    //水平扫描法
    public String longestCommonPrefix_01(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
    public String longestCommonPrefix_011(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for(int i = 0; i < strs[0].length(); i ++){
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j ++){
                if(c != strs[j].charAt(i) || i == strs[j].length())
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    //分治法
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            System.out.println("strs[l]---"+strs[l]);
            return strs[l];
        } else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            System.out.println("lcpLeft---"+lcpLeft);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            System.out.println("lcpRight---"+lcpRight);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }
    //String[] strs = {"oa-adcin","oa-adcd","oa-adcd"};
    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) ){
                System.out.println("1---"+left.substring(0, i));
                return left.substring(0, i);
            }

        }
        System.out.println("2---"+left.substring(0, min));
        return left.substring(0, min);
    }


    //二分法
    public String longestCommonPrefix_03(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    //二分法
    public String longestCommonPrefix_04(String[] strs) {
        if (null == strs || strs.length == 0){
            return "";
        }
        int right = strs[0].length();
        for(int i = 1; i < strs.length; i ++){
            right = Math.min(right, strs[i].length());
        }
        int left = 0;
        while(left <= right){
            int mid = (right - left >> 2) + left;
            if(isCommonPrefix_02(strs,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return strs[0].substring(0,(right - left >> 2) + left);
    }

    private boolean isCommonPrefix_02(String[] strs, int mid) {
        for(int i = 0; i < strs.length; i ++){
            if(!strs[i].startsWith(strs[0].substring(0, mid)))
                return false;
        }
        return true;
    }


    public String longestCommonPrefix_fenzhi(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        return longCommonPre(strs, 0 , strs.length - 1);
    }

    private String longCommonPre(String[] strs, int left, int right) {
        if(left == right){
            return strs[left];
        } else {
            int mid = left + (right - left >> 2);
            String lcpLeft = longCommonPre(strs, left, mid);
            System.out.println("lcpLeft---"+lcpLeft);
            String lcpRight = longCommonPre(strs,mid + 1,right);
            System.out.println("lcpRight---"+lcpRight);
            System.out.println("lcpLeft-2---"+lcpLeft);
            return commonLeftRight(lcpLeft,lcpRight);
        }
    }

    private String commonLeftRight(String lcpLeft, String lcpRight) {
        for(int i = 0; i < lcpLeft.length(); i ++){
            if(i == lcpRight.length() || lcpLeft.charAt(i) != lcpRight.charAt(i)){
                System.out.println("1--"+lcpLeft.substring(0 , i));
                return lcpLeft.substring(0 , i);
            }
        }
        System.out.println("2--"+lcpLeft);
        return lcpLeft;
    }

    public static void main(String[] args) {
        String s = "admin";
        String p = "admi";
        String[] strs = {"oa-adcin","oa-adcd","oa-adcd"};
        System.out.println(new algo_0014().longestCommonPrefix_fenzhi(strs));
    }
}
