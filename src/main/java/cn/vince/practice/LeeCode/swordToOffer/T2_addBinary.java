package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author: vince.shu
 * @description: 二进制加法
 * @date: 2022/5/2 11:56
 * @version: 1.0
 */
public class T2_addBinary {

    public static void main(String[] args) {
        String result = addBinary1("1010", "1011");
        System.out.println(result);
    }


    /**
     * @author vinceshu
     * @date 2022/5/2 12:04
     * @description TODO
     */
    public static String addBinary1(String a, String b) {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("sdad");
        });

        StringBuilder res = new StringBuilder();

        int aLastIndex = a.length() - 1;
        int bLastIndex = b.length() - 1;
        int carry = 0;
        while (aLastIndex >= 0 || bLastIndex >= 0) {
            int aLastNum = aLastIndex < 0 ? 0 : a.charAt(aLastIndex) - '0';
            int bLastNum = bLastIndex < 0 ? 0 : b.charAt(bLastIndex) - '0';
            int sum = aLastNum + bLastNum + carry;
            res.append(sum % 2);
            carry = sum / 2;

            aLastIndex--;
            bLastIndex--;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }



    /**
     * @author vinceshu
     * @date 2022/5/2 12:04
     * @description 思路一：将2进制转为10进制，计算结果后再转为二进制
     */
    public static String addBinary(String a, String b) {
        int aInt = Integer.parseInt(a, 2);
        int bInt = Integer.parseInt(b, 2);
        int resultInt = aInt + bInt;
        return Integer.toString(resultInt, 2);
    }

}
