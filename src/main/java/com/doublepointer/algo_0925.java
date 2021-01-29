package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-29
 * 925 长按键入
 */
public class algo_0925 {

    /**
     * 双指针简化
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName_(String name, String typed) {
        //"aalex", typed = "aaaaaleex"
        if(name == null || typed == null ||name.length() > typed.length())
            return false;
        int i = 0, j = 0;
        while(j < typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            } else if(j > 0 && j < typed.length() && typed.charAt(j-1) == typed.charAt(j)){
                j ++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public boolean isLongPressedName(String name, String typed) {
        //"aalex", typed = "aaaaaleex"
        if(name == null || typed == null ||name.length() > typed.length())
            return false;
        int i = 0, j = 0;
        while(j < typed.length()){
            if(i < name.length() && j < typed.length() && name.charAt(i) != typed.charAt(j))
                return false;

            if(i == name.length() && name.charAt(i-1) != typed.charAt(j))
                return false;

            while(i < name.length() && j < typed.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            while(j < typed.length() && typed.charAt(j-1) == typed.charAt(j)){
                j ++;
            }
        }
        return i == name.length();
    }
}
