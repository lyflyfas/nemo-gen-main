package leetcode;

import lombok.var;

/**
 * "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"
 * 输出-1263895769
 * 预期97915677
 *
 */
public class h940 {
    private static int  mod = (int) (1e9+7);

    public static int distinctSubseqII(String s) {
        long res = 0L;
        long[] l = new long[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            long last = l[s.charAt(i)-'a'] ;//上一次的这个字符的子序列
            l[s.charAt(i)-'a'] = (res+1) % mod;//更新这个字符的子序数量
            res = (res+l[s.charAt(i)-'a'] + mod- last ) % mod;
        }
        return (int) res ;
    }


    public static void main(String[] args) {
        String s = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        //1、字符串坑位测试
        System.out.println(distinctSubseqII(s));

//        System.out.println(''-1);
    }
}
