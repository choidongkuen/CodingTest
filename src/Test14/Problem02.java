package Test14;

import java.util.Stack;

public class Problem02 {

    public static String solution(String s, int k){

        if(Integer.parseInt(s) == 0){
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        int n = s.length() - k;


        for (int i = 0; i < s.length() ; i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                // 스택 꼭대기에 있는 값이 더 작거나 같다면 해당 값 넣주고
                if(stack.peek() <= s.charAt(i)){
                    stack.push(s.charAt(i));
                // 스택 꼭대기에 있는 값이 더 크다면
                // 빼줘야지
                }else{
                    while(k > 0 && !stack.isEmpty() && stack.peek() > s.charAt(i)){
                        stack.pop();
                        k --;
                    }
                    stack.push(s.charAt(i));
                }
            }
        }

        for (int i = 0; i < k ; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack.size() ; i++) {
            sb.append(stack.elementAt(i));
        }

        return sb.toString();

//        StringBuilder sb = new StringBuilder();
//
//        while(!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//
//        String result = sb.reverse().substring(0,n).toString();
//        Integer re = Integer.parseInt(result);
//        return re.toString();

    }


    public static void main(String[] args) {
        String s = "105990";
        int k = 1;

        System.out.println(solution(s,k));
    }
}
