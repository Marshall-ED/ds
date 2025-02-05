package org.example.array;


/**
 * @Author Marshall
 * @Date 2025/1/15 16:06
 * @Description: 有一个n阶二维整数数组a，设计一个算法aⁱ（i为大于1的整数），结果矩阵元素取模111的结果
 */
public class Mult {

    /**
     * 返回矩阵a和矩阵b相乘的矩阵c
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += (a[i][k] * b[k][j]) % MOD;
                    c[i][j] %= MOD;
                }
            }
        }

        return c;
    };

    public static int[][] pow(int[][] a, int k) {
        int n = a.length;
        int[][] ans = new int[n][n];
        // 初始化为单位矩阵
        for (int i = 0; i < n; i++) {
            ans[i][i] = 1;
        }

        int[][] base = new int[n][n];
        // 复制原始矩阵a到base
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                base[i][j] = a[i][j];
            }
        }

        while (k > 0) {

            //& 按位与，两个的二进制位都是1结果才是1
            //1的二进制就是1，最低位也是1，其余都是0;
            // k的二进制与1的二进制相比;
            // 二进制只有奇数的最低位是1
            if ((k & 1) == 1) {
                ans = multiply(ans, base);
            }
            base = multiply(base, base); // base = base * base
            k >>= 1; // k = k / 2
        }
        return ans;
    }

    public static final int MOD = 111;

    public static void main(String[] args) {

        int[][] a = {
                {1, 2, 1},
                {0, 2, 3},
                {1, 0, 1}
        };

        int k = 5;

       int[][] result = pow(a,5);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }

    }
}
