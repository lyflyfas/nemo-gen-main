package leetcode;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class s342 {
    public static boolean isPowerOfFour(int n) {
        //
        if(n<4){
            if(n==1){
                return true;
            }else{
                return false;
            }
        }else{
            if (n%4==0){
                return isPowerOfFour(n/4);
            }else{
                return false;
            }

        }
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfFour(5));
        System.out.println(5/4);
    }


}
