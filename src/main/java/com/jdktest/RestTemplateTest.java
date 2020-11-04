package com.jdktest;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author yb
 * @date: 2020-10-22
 */
public class RestTemplateTest {

    public static void main(String[] args) {
        for(int a = 1; a <= 120; a ++){
            for(int b = 1; b <= 120; b ++){
                for(int c = 1; c <= 120; c ++){
                    if(  120%a == 0
                        && 120%b == 0
                        && 120%c == 0
                        && a%12 == b%12
                            && a%15 == c%15
                            && a%15 ==0
                            && a%12 ==0
                            && c%15 ==0
                            && b%12 ==0
                            && getMaxGongYue(a,b)==12
                            && getMaxGongYue(a,c)==15
                            && a%60==0
                            && getMinThreeBei(a,b,c) == 120){
                        System.out.println("a="+a+",b="+b+",c="+c);
                        System.out.println(a+b+c);
                    }
                }
            }
        }
    }


    /**
     * 求最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int getMaxGongYue(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    //求最小公倍数
    //最大公约数与最小公倍数的关系是    a * b= 最大公约数*最小公倍数
    public static int getMinBei(int a,int b){
        return  a*b/getMaxGongYue(a,b);
    }

    @Test
    public void getBC(){
        int a= getMinThreeBei(60,24, 15);
        System.out.println(a);
    }

    public static int getMinThreeBei(int a, int b, int c){
        int max = Math.max(a,b);
        max = Math.min(max, c);
        for(int i = max; i <= a * b * c; i ++){
            if(i % a == 0 && i % b ==0 && i % c ==0){
                return i;
            }
        }
        return a * b * c;
    }


}
