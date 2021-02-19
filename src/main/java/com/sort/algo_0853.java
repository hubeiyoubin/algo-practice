package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-19
 * 853 车队
 */
public class algo_0853 {
    class Car{
        int position;
        double time;
        Car(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || speed == null || position.length == 0 || speed.length == 0)
            return 0;

        Car[] cars = new Car[position.length];
        for(int i = 0; i < position.length; i ++){
            Car car = new Car(position[i], (double) (target - position[i]) / speed[i] * 1.000) ;
            cars[i] = car;
        }
        Arrays.sort(cars, (c1, c2) -> Integer.compare(c1.position, c2.position));
        int n = position.length;
        int count = 0;
        while(--n > 0){
            // System.out.println(cars[n].time);
            // System.out.println(cars[n-1].time);
            if(cars[n].time < cars[n-1].time)
                count ++;
            else
                cars[n-1] = cars[n];
        }
        return count + (n == 0 ? 1 : 0);
    }
}
