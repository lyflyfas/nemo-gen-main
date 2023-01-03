package leetcode;

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
