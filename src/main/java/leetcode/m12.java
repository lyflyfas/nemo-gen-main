package leetcode;

public class m12 {
    private static int I = 1;
    private static int IV = 4;
    private static int V = 5;
    private static int IX = 9;
    private static int X = 10;
    private static int XL = 40;
    private static int L = 50;
    private static int XC = 90;
    private static int C = 100;
    private static int CD = 400;
    private static int D = 500;
    private static int CM = 900;
    private static int M = 1000;


    public String intToRoman(int num) {
        return disassemble("",num);
    }

    public static String disassemble(String res, int num){
        int aa = num / M;
        for (int i = 0; i < aa; i++) {
            res += "M";
            num -= M;
        }
        int a = num / CM;
        for (int i = 0; i < a; i++) {
            res += "CM";
            num -= CM;
        }
        int b = num / D;
        for (int i = 0; i < b; i++) {
            res += "D";
            num -= D;
        }
        int c = num / CD;
        for (int i = 0; i < c; i++) {
            res += "CD";
            num -= CD;
        }
        int d = num / C;
        for (int i = 0; i < d; i++) {
            res += "C";
            num -= C;
        }
        int e = num / XC;
        for (int i = 0; i < e; i++) {
            res += "XC";
            num -= XC;
        }
        int f = num / L;
        for (int i = 0; i < f; i++) {
            res += "L";
            num -= L;
        }
        int g = num / XL;
        for (int i = 0; i < g; i++) {
            res += "XL";
            num -= XL;
        }
        int h = num / X;
        for (int i = 0; i < h; i++) {
            res += "X";
            num -= X;
        }
        int j = num / IX;
        for (int i = 0; i < j; i++) {
            res += "IX";
            num -= IX;
        }
        int k = num / V;
        for (int i = 0; i < k; i++) {
            res += "V";
            num -= V;
        }
        int l = num / IV;
        for (int i = 0; i < l; i++) {
            res += "IV";
            num -= IV;
        }
        int m = num ;
        for (int i = 0; i < num; i++) {
            res += "I";
        }
        return res;

    }

    /*官解*/
//    class Solution {
//        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//
//        public String intToRoman(int num) {
//            StringBuffer roman = new StringBuffer();
//            for (int i = 0; i < values.length; ++i) {
//                int value = values[i];
//                String symbol = symbols[i];
//                while (num >= value) {
//                    num -= value;
//                    roman.append(symbol);
//                }
//                if (num == 0) {
//                    break;
//                }
//            }
//            return roman.toString();
//        }
//    }


    public static void main(String[] args) {
        int num = 200;
        System.out.println(disassemble("",num));

    }
}
