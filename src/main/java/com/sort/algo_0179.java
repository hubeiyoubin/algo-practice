package com.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author yb
 * @date: 2021-2-18
 * 179 最大数
 */
public class algo_0179 {

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for(String str: strs){
            sb.append(str);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }


    // jdk 8 lambda
    public String largestNumber_(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (String s :
                Arrays.stream(nums)
                        .boxed()
                        .map(Object::toString)
                        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                        .collect(Collectors.toList())) {
            sb.append(s);
        }

        String result = sb.toString();

        return result.startsWith("0") ? "0" : result;
    }
}
