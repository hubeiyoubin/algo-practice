package com.algo;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @date : 2019-11-19
 *
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class algo_0017 {
    //深度优先
    public List<String> letterCombinations_dfs(String digits) {
        List<String> list = new ArrayList<>();
        dfs(list, digits, "", 0);
        return list;
    }

    private void dfs(List<String> list, String digits, String res, int index) {
        if(digits.length() == index){
            list.add(res);
            return;
        }
        for(char c : getStringByChar(digits.charAt(index)).toCharArray()){
            dfs(list, digits, res + c, index + 1);
        }
    }


    private String getStringByChar(char c){
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"nmo");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map.get(c);
    }


    //广度优先
    public List<String> letterCombinations_bfs(String digits){
        LinkedList<String> list = new LinkedList<>();
        if(digits == null || digits.length() == 0)
            return list;
        String[] letters = {"abc","def","ghi","jkl","nmo","pqrs","tuv","wxyz"};
        list.add("");
        for(int i = 0; i < digits.length(); i ++){
            int index = digits.charAt(i) - '0' - 2;
            if(index < 0)
                throw new RuntimeException("输入数字要大于1");
            while(list.getFirst().length() == i){
                String pre = list.removeFirst();
                for(int j = 0; j < letters[index].length(); j ++){
                    System.out.println(pre + letters[index].charAt(j));
                    list.add(pre + letters[index].charAt(j));
                }
            }
        }
        return list;
    }



    public static void main(String[] args) {
        List<String> list = new algo_0017().letterCombinations_dfs("234");
        List<String> list2 = new algo_0017().letterCombinations_bfs("234");
        System.out.println(list.size());
        System.out.println(JSONObject.toJSONString(list));
        System.out.println(list2.size());
        System.out.println(JSONObject.toJSONString(list2));
    }
}
