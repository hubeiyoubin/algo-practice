package com.two_pointers;

/**
 * @author yb
 * @date: 2021-2-3
 * 1616 分割两个字符串得到回文串
 */
public class algo_1616 {

    // 中心扩展法
    public boolean checkPalindromeFormation(String a, String b) {
        // 中心点
        int mid = a.length()/2 - 1;
        mid = Math.min(check(a,a,mid), check(b,b,mid));
        mid = Math.min(check(a,b,mid), check(b,a,mid));
        return mid < 0;
    }

    private int check(String a, String b, int left){
        // left + right = a.length - 1
        int right = a.length() - 1 - left;
        while(left >=0 && right <= a.length()-1){
            if(a.charAt(left) != b.charAt(right)){
                return left;
            }
            left --;
            right ++;
        }
        return left;
    }

    // 双指针， 提交不通过
    public boolean checkPalindromeFormation_(String a, String b) {
        int left = 0, right = a.length() - 1;
        while(left <= right){
            if(a.charAt(left) == a.charAt(right) || a.charAt(left) == b.charAt(right)
                    || b.charAt(left) == a.charAt(right) || b.charAt(left) == b.charAt(right)){
                left ++;
                right --;
            } else {
                return false;
            }
        }
        return true;
    }
}
