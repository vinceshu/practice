package cn.vince.practice.interview.javaBase;


// 实现一个类似String的indexOf(String str)的方法，用最简单实现即可
// 查找字符串str在目标字符串source中第一次出现的位置。
// 不可以调用任何第三方库，也不可以用String.equals， String.substring 方法
// 注意边界条件
public class SomeClass {

    public static int indexOf(String source, String str) {
        if (source == null || source.length() <= 0 || str == null || str.length() <= 0) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < source.length(); i++) {
            //sourceIndex临时变量，用作比较str的每一个字符
            int si = i;
            //标识变量。命中第一个，直接返回，不做后续遍历
            boolean flag = false;
            //遍历str，逐一和str字符比较
            for (int j = 0; j < str.length(); j++) {
                //防止越界
                if (si >= source.length() || str.charAt(j) != source.charAt(si)) {
                    flag = false;
                    break;
                } else {
                    si++;
                    flag = true;
                    index = si - str.length();
                }
            }
            //命中直接返回
            if (flag) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String source = "abcabdef";
        String str = "def";
        System.out.println(indexOf(source, str));
    }

}
