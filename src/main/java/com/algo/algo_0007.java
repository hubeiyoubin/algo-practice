package com.algo;

public class algo_0007 {
    public static int reverse(int x) {
        int ver = 0;
        while(x != 0){
            int newv = x % 10 + ver * 10;
            System.out.println(newv);
            if((newv - x % 10) / 10 != ver )
                return 0;
            ver = newv;
            x = x / 10;
        }
        return ver;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236999));
        //System.out.println(999632435 + 1199632435);
    }
}
