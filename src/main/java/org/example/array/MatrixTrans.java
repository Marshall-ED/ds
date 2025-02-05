package org.example.array;

import sun.applet.Main;

/**
 * @Author Marshall
 * @Date 2025/1/13 16:06
 * @Description:
 */
public class MatrixTrans {

    //转置算法（对角线的两个三角互换）
    public static void trans(int [][] a){
        int temp;
        //a.length表示行数,a[0].length表示列数
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果不用临时变量，数据会丢失
                temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        MatrixTrans.trans(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
