package com.two_pointers;

/**
 * @author : youbin
 * @date : 2021/1/31 22:34
 * 828 统计子串中的唯一字符
 */
public class algo_0828 {
    /**
     *  思路很难想
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {
        int mod=1000000007;
        int ans=0;
        for(int i=0;i<s.length();i++){
            int n=s.charAt(i);
            int zuo=i-1;
            int you=i+1;
            while(zuo>=0&&s.charAt(zuo)!=n){
                zuo--;
            }
            while(you<s.length()&&s.charAt(you)!=n){
                you++;
            }
            //System.out.println(ans);
            ans=(ans+(i-zuo)*(you-i))%mod;
        }
        return ans;
    }
}
