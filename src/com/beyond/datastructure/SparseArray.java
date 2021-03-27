package com.beyond.datastructure;

/**
 * 原始数组转换为稀疏数组：originArray[][] ->  sparseArray[有效数据个数+1][3]
 *
 *   0	0	1	0	0	0	0	0	0	0	0
 *   0	0	0	1	0	0	0	0	0	0	0
 *   2	0	0	1	0	0	0	0	0	0	0
 *   0	0	2	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *   0	0	0	0	0	0	0	0	0	0	0
 *
 */
public class SparseArray {
    public static void main(String[] args) {
        // 1.构建一个原始二维数组 11*11 代表棋盘： 1-黑子、2-白子
        int[][] chessArr = new int[11][11];
        // 构造5个有效数据
        chessArr[0][2] = 1;
        chessArr[1][3] = 1;
        chessArr[2][0] = 1;
        chessArr[2][3] = 2;
        chessArr[3][2] = 2;
        System.out.println("原始数组：");
        printArray(chessArr);
        // 2.转换成稀疏数组
        // 2.1遍历数据计算有效数据个数
        int sum = 0;
        for (int[] rows : chessArr) {
            for (int i : rows) {
                if (i != 0) {
                    sum++;
                }
            }
        }

        // 2.2 构造稀疏数组： sparseArray[有效数据个数+1][3]
        int[][] sparseArray = new int[sum + 1][3];
        // 2.3将数据存入稀疏数组: 第一行存原始数组的行数、列数以及有效数据的个数
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = chessArr[0].length;
        sparseArray[0][2] = sum;
        // 2.4 其余行存有效数据在原始数组中的行、列以及本身的数值
        sum = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArray[sum][0] = i;
                    sparseArray[sum][1] = j;
                    sparseArray[sum][2] = chessArr[i][j];
                    sum++;
                }
            }
        }
        System.out.println("稀疏数组:");
        printArray(sparseArray);
    }


    /**
     * 打印数组
     */
    public static void printArray(int[][] arr) {
        for (int[] rows : arr) {
            for (int i : rows) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

}
