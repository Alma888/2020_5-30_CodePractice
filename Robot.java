# 2020_5-30_CodePractice

//机器人走方格：

//有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
// 请设计一个算法，计算机器人有多少种走法。
//给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
//   【测试样例】：  2,2
//   【返回】：          2
//   【输入描述】：输入x,y
//   【输出描述】：输出走法数目
/*
【解题思路】：
机器人在XY的矩阵中走，每一步都有两种选择：
要么向下、要么向右。
 如果向下走，问题就变成：求(X-1)Y矩阵中机器人的走法；
如果向右走，问题就变成：求X*(Y-1)矩阵中机器人的走法；
 显然是递归的思想！ 既然是递归，再考虑退出条件：
 当整个矩阵只有一行 或 一列的时候只有一种走法。
 */

//方法一：使用递归解决
/*
public class Robot {
    public static void main(String[] args) {
        System.out.println(Count(3,3));
    }

    private static int Count(int a, int b) {
        if(a==1||b==1){
            return 1;
        }
        return Count(a-1,b)+Count(a,b-1);
    }
}
*/

//方法二：基于动态规划
public class Robot{
    public static int countWays(int x, int y) {
        // write code here
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for(int i = 1; i < x; i++){
            dp[i][0] = dp[i-1][0];
        }
        for(int i = 1; i < y; i++){
            dp[0][i] = dp[0][i-1];
        }
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }
    public static void main(String[] args) {
        System.out.println(countWays(2,3));
    }
}
