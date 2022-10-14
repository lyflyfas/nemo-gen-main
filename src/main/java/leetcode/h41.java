package leetcode;

/**
 * 221014
 */
public class h41 {
    public static int firstMissingPositive(int[] nums) {
        int res = nums.length;
        int[] j = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=nums.length && nums[i]>0){
                j[nums[i]-1]=1;
            }
        }
        for (int i = 0; i < j.length; i++) {
            if(j[i]==0){
                res = i;
                break;
            }
        }
        return res+1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,-4,0};
//        int[] a = new int[]{1};
//        System.out.println(j[2]);
        System.out.println(firstMissingPositive(a));
    }
}
