package leetcode;

import javafx.print.Collation;

import java.util.*;

public class m46 {
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = null;
//        //遍历元素排序
//        List<Integer> head = new ArrayList<>();
//        int n = nums.length;
//        List<Integer> nlist = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            nlist.add(i);
//        }
//        getn(res,head,nums);
//
//
//        return res;
//    }
//
//    public static void getn(List<List<Integer>> res,List<Integer> head,int[] nums){
//        //构造一个nlist
//        if(nums.length == 0 ){
//            res.add(new ArrayList<>(head));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> headi = head;
//            int[] numsi = nums;
//            headi.add(numsi[i]);
//            getn(res,headi,ArrayRemove(numsi,i));
//        }
//    }
//
//
//    public static int[] ArrayRemove(int[] os,int i) {
//        int[] res = new int[os.length-1];
//        os[i]=os[os.length-1];
//        res = Arrays.copyOf(os,os.length-1);
//        return res;
//    }


    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth== len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast();
            used[i]=false;
        }

    }


    public static void main(String[] args) {
        int[] input = {1,2,3};
        System.out.println(permute(input));
//        List<Integer> in = new ArrayList<>();
//        in.add(1);in.add(2);in.add(3);
//        Collections.swap(in,1,2);
//        System.out.println(in.toString());
//
//        System.out.println(Arrays.toString(ArrayRemove(input,1)));
    }
}
