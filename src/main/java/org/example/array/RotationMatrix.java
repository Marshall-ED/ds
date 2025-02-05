package org.example.array;

/**
 * @Author Marshall
 * @Date 2024/9/11 15:55
 * @Description:给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 */
public class RotationMatrix {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        for (int layer = 0; layer < n; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset=i-first;
                int top = matrix[first][i];
            }
            

        }


    }
}
