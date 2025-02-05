package org.example.array;

/**
 * @Author Marshall
 * @Date 2025/1/17 22:12
 * @Description:两个n阶整型对称矩阵
 */
public class Example02 {
    //1、按行优先存放在一维数组a，b中
    public static void compression(int[][] A, int[] a) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                int k = i * (i + 1) / 2 + j;
                a[k] = A[i][j];
            }
        }
    }

    /**
     * 输出原始矩阵
     *
     * @param A
     */
    public static void disp(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.printf("%4d", A[i][j]);
            }
            System.out.println();
        }
    }

    //通过a,b实现矩阵A，B乘积运算，结果放在C中
    public static void multi(int[] a, int[] b, int[][] C, int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int s = 0;

                for (int k = 0; k < n; k++) {
                    int k1 = getk(i, k);
                    int k2 = getk(k,j);

                    s += k1*k2;
                }
                C[i][j]=s;
            }
        }

    }

    private static int getk(int i, int j) {
        if (i >= j) {
            return i * (i + 1) / 2 + j;
        } else
            return j * (j + 1) / 2 + i;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {2, 5, 6, 7},
                {3, 6, 8, 9},
                {4, 7, 9, 10}
        };
        //行数乘下三角部分
        int len = A.length * (A.length + 1) / 2;
        int[] a = new int[len];

        compression(A, a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("原始矩阵：");
        disp(A);

        int[][] B = {
                {1, 2, 3, 4},
                {2, 5, 6, 7},
                {3, 6, 8, 9},
                {4, 7, 9, 10}
        };



    }
}
