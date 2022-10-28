package Test10;

import java.sql.Array;
import java.util.*;

public class Problem03 {

    static class Node {
        public int index;
        public Node left = null;
        public Node right = null;

        public Node(int index) {
            this.index = index;
        }
    }

    public static final int MAX = 100; // 노드의 최대 갯수
    public static int[] result;
    public static ArrayList<Node> nodes = new ArrayList<>(); // 노드의 정보를 담는 배열리스트

    public static void reverseOrder(Node root){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Stack<Node> stack = new Stack<>();
        Node curr;

        while(!queue.isEmpty()) {
            curr = queue.poll();
            stack.push(curr);

            if (nodes.get(curr.index).right != null) {
                queue.add(nodes.get(curr.index).right);
            }

            if (nodes.get(curr.index).left != null) {
                queue.add(nodes.get(curr.index).left);
            }
        }

        int idx = 0;
        while(!stack.isEmpty()) {
            result[idx ++] = stack.pop().index;
        }
    }

    public static int[] solution(int n, int[][] left, int[][] right){

        result = new int[n];
        for (int i = 0; i < n ; i++) {
            nodes.add(new Node(i));
        }
        for(int i = 0; i < left.length; i++){
            int p = left[i][0];
            int l = left[i][1];
            nodes.get(p).left = new Node(l);
        }

        for (int i = 0; i < right.length ; i++) {
            int p = right[i][0];
            int r = right[i][1];
            nodes.get(p).right = new Node(r);
        }

        reverseOrder(new Node(0));
        return result;
    }



    public static void main(String[] args) {

        int[][] left = {{0,1},{1,5},{2,3}};
        int[][] right = {{0,2},{3,4}};

        int n = 6;


        System.out.println(Arrays.toString(solution(n,left,right)));
    }
}
