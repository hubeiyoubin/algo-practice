package com.algo;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class algo_0009 {

    //先反转整数，再进行比较
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int ver = 0;
        int pre = x;
        while(x != 0){
            //反转无需判断是否越界，越界的肯定不是回文数
            ver = ver * 10 + x % 10;
            x = x / 10;
        }
        return pre == ver;
    }

    // 左右数字，一一对比
    public boolean isPalindrome_02(int x) {
        //边界判断
        if (x < 0)
            return false;

        int div = 1;
        while (x / div >= 10)
            div *= 10;

        while (x > 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    // 反转一半，比较左右两边
    public static boolean isPalindrome_03(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome_03(1234554321));
    }
}

