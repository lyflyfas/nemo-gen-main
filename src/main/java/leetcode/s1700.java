package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class s1700 {
    public static int countStudents(int[] students, int[] sandwiches) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        //转化队列
        for (int student : students) {
            queue.offer(student);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            int a = sandwiches[i];
            int b = queue.size();
            for (int i1 = 0; i1 < queue.size(); i1++) {
                if(queue.element()==a){
                    queue.poll();
                    break;//如果匹配上，就马上切换下一个三明治
                }else{
                    queue.offer(queue.element());
                    queue.poll();
                }
            }
            if(b== queue.size()){
                break;//如果一轮下来，没有人拿走三明治，那么循环结束
            }
        }
        res = queue.size();
        return res;
    }
    /**
     * [1,1,1,0,0,1]
     * [1,0,0,0,1,1]
     * @param args
     */
    public static void main(String[] args) {
        int[] students = new int[]{1,1,1,0,0,1};
        int[] sandwiches = new int[]{1,0,0,0,1,1};
        System.out.println(countStudents(students,sandwiches));
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        queue.offer(5);
//        queue.offer(6);
//        queue.offer(7);
//        queue.offer(queue.element());
//        queue.poll();
//        for (Integer integer : queue) {
//            System.out.println(integer);
//        }

    }

}
