package com.qinchy.sftpdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
class Solution6 {
    public int reverse(int x) {

        int tmp = Math.abs(x);
        long reverse = 0;
        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            if (reverse > Integer.MAX_VALUE) {
                return 0;
            }
            tmp = tmp / 10;
        }
        return (int) (x > 0 ? reverse : -reverse);

    }
}

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution6().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}