package leetcode;

public class m11 {
//    public static int maxArea(int[] height) {
//        int res = 0;
//        for (int i = 0; i < height.length-1; i++) {
//            for (int j = 0; j < height.length; j++) {
//                int len = Math.abs((i-j));
//                int hei = Math.min(height[i],height[j]);
//                if(res<len * hei){
//                    res = len * hei;
//                }
//            }
//        }
//        return res;
//    }

    public static int maxArea(int[] height) {
        int inS= 0;
        int inE = height.length-1;
        int res = (height.length-1)*Math.min(height[inS],height[inE]);
        for (int i = 2; i < height.length; i++) {
            if(inE-inS>1){
                if(height[inS]>height[inE]){
                    inE --;
                }else if(height[inS]==height[inE]){
                    inE --;
                    inS++;
                }else{
                    inS++;
                }
                int deitence = inE-inS;
                res = Math.max(res,deitence*Math.min(height[inS],height[inE]));
            }else{
                res = Math.max(res,(inE-inS)*Math.min(height[inS],height[inE]));
            }
        }

        System.out.println(inS+"("+height[inS]+")  和  "+inE+"("+height[inE]+") ="+res);
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,2,3,4,5,6,72,8999,9,10,4,2,3,4,5,22};
       maxArea(height);
    }
}
