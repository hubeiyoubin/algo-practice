package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-28
 * 75 颜色分类
 */
public class algo_0075 {
    // 双指针， p2将2 置换到后面， p0将 0 置换到前面
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int p0 = 0, p2 = nums.length - 1;
        for(int i = 0; i <= p2; i++){
            while(i <= p2 && nums[i] == 2){
                swap(nums, i, p2);
                p2 --;
            }
            if(nums[i] == 0){
                swap(nums, i, p0);
                p0 ++;
            }
        }
    }
    private void swap(int[] nums, int pre, int cur){
        int temp = nums[cur];
        nums[cur] = nums[pre];
        nums[pre] = temp;
    }
}
