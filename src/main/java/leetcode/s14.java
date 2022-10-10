package leetcode;

import org.apache.commons.lang3.StringUtils;

public class s14 {
    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        //选第一个元素当作基准，去对比所有元素
        String base = strs[0];
        int count = 0;
        int fornum = base.length();
        for (int i = 0; i < fornum; i++) {
            count = 0;
            for (String str : strs) {
                if (str.startsWith(base)){
                    count ++;
                }
            }
            if(count == strs.length){
                res = base;
                break;
            }else{
                count = 0;
                base = base.substring(0,fornum-i-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));


//        System.out.println("aaaa".startsWith("aaaaaaaa"));
    }
}
