package org.example.array;

/**
 * @Author Marshall
 * @Date 2025/1/19 17:08
 * @Description:
 */
public class sparseArray2 {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1表示黑子，2表示蓝子

        int[][] arr1 = new int[11][11];
        arr1[0][1] = 1;
        arr1[1][2] =2;

        //输出原始的二维数组
        System.out.println("原始数组：");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {

                System.out.printf("%d\t" , arr1[i][j]);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //1、先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr1[i][j] != 0){
                    sum++;
                }

            }
        }
        System.out.println("sum= "+sum);
        //2、创建对应的稀疏数组
        int[][] sparseArr1 = new int[sum+1][3];
        sparseArr1[0][0]= arr1.length;
        sparseArr1[0][1]= arr1.length;
        sparseArr1[0][2]=sum;

        int count = 0;
        for(int i = 0;i< arr1.length;i++){
            for (int j = 0; j < arr1.length; j++) {
                if(arr1[i][j] !=0){
                    count++;
                    sparseArr1[count][0]=i;
                    sparseArr1[count][1]=j;
                    sparseArr1[count][2]=arr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr1.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr1[i][0],sparseArr1[i][1],sparseArr1[i][2]);
        }
        System.out.println();


        //将稀疏数组 --》恢复成原始数组
        //1、先读取稀疏数组第一行，根据第一行的数据，创建原始的二维数组
        int[][] arr2 = new int[sparseArr1[0][0]][sparseArr1[0][1]];

        //2、在读取稀疏数组后几行的数据（从第二行开始），并赋给原始的二维数组
        for (int i = 1; i < sparseArr1.length; i++) {

            arr2[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];

        }
        //输出恢复后的二维数组
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.printf("%d\t" , arr2[i][j]);;
            }
            System.out.println();
        }

    }


}