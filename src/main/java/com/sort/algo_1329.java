package com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yb
 * @date: 2021-2-24
 * 1329 将矩阵按对角线排序
 */
public class algo_1329 {

    public int[][] diagonalSort(int[][] mat) {
        for(int j = 0; j < mat[0].length; j ++){
            sortStart(mat, 0, j);
        }
        for(int i = 1; i < mat.length; i ++){
            sortStart(mat, i, 0);
        }
        return mat;
    }
    private void sortStart(int[][] mat, int i, int j){
        List<int[]> indexList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        while (i < mat.length && j < mat[i].length) {
            int[] temp = new int[]{i, j};
            indexList.add(temp);
            dataList.add(mat[i][j]);
            i ++;
            j ++;
        }
        sortArray(mat, indexList, dataList);
    }
    private void sortArray(int[][] mat, List<int[]> indexList, List<Integer> dataList){
        if(dataList.size() == 1)
            return;
        dataList = dataList.stream().sorted().collect(Collectors.toList());
        for(int i = 0; i < indexList.size(); i ++){
            int[] temp = indexList.get(i);
            mat[temp[0]][temp[1]] = dataList.get(i);
        }
    }
}
