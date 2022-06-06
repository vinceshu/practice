package cn.vince.practice.LeeCode.interviewGold;

import java.util.Arrays;

/**
 * @author: vince.shu
 * @description: URL化
 * @date: 2022/6/4 11:19
 * @version: 1.0
 */
public class T3_StringToUrlLCCI {

    /**
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     */

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int length = 13;
        replaceSpaces(s, length);
    }


    public static String replaceSpaces(String S, int length) {
        char[] chs = S.toCharArray();
        int i = length-1, j = S.length()-1;
        while(i>=0){
            if(chs[i]==' '){
                chs[j--] = '0';
                chs[j--] = '2';
                chs[j--] = '%';
            }else{
                chs[j--] = chs[i];
            }
            i--;
        }
        return String.valueOf(chs,j+1, S.length()-j-1);
    }

}
