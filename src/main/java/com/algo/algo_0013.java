package com.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * @date : 2019-11-15
 *
 * 13. 罗马数字转整数
 *
 */
public class algo_0013 {
//    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//    int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static int romanToInt(String s) {

        Map<String,Integer> map = new HashMap();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        int num = 0;
        for(int i = 0; i < s.length(); ){
            if(i < s.length() - 1 && map.containsKey(s.substring(i,i + 2))){
                num = num + map.get(s.substring(i,i + 2));
                i += 2;
            }else{
                num = num + map.get(Character.toString(s.charAt(i)));
                i ++;
            }
        }
        return num;
    }


    public static int romanToInt_02(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Map<Character,Integer> map = new HashMap();
        map.put('M',1000);
        //map.put("CM",900);
        map.put('D',500);
        //map.put("CD",400);
        map.put('C',100);
        //map.put("XC",90);
        map.put('L',50);
       // map.put("XL",40);
        map.put('X',10);
        //map.put("IX",9);
        map.put('V',5);
        //map.put("IV",4);
        map.put('I',1);
        int sum = 0;
        int pre = map.get(s.charAt(0));
        for(int i = 1; i < s.length(); i ++){
           int cur = map.get(s.charAt(i));
           if(cur > pre){
               sum = sum - pre;
           }else{
               sum = sum + pre;
           }
           pre = cur;
        }
        sum = sum + pre;
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCI"));
        System.out.println(romanToInt_02("MCMXCI"));
    }
}
