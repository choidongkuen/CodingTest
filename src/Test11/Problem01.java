package Test11;

import java.util.*;
import java.util.stream.Stream;

public class Problem01 {
    public static final int MAX_N = 10000;
    public static final int MAX_NUM = 1000000;

    public static Map<Integer,Integer> hashMap;
    public static String val;

    public static void countNumber(String number){
        hashMap = new HashMap<>();

//        int[] arr = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

        int[] arr = new int[number.length()];
        for (int i = 0; i < number.length() ; i++) {
            arr[i] = Integer.valueOf(number.substring(i,i + 1));
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length ; i++) {
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i]) + 1);

            }else{
                hashMap.put(arr[i],1);
            }
        }

        Set<Integer> key = hashMap.keySet();
        ArrayList<Integer> keyArr = new ArrayList<>(key);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key.size(); i++) {
            result.append(keyArr.get(i).toString());
            result.append(hashMap.get(keyArr.get(i)).toString());
        }

        val = result.toString();

    }


    public static int solution(int n, int num){

        Integer numInt = num;
        val = numInt.toString();
        for (int i = 0; i < n ; i++) {
            countNumber(val);
        }

        return Integer.parseInt(val);
    }

    public static void main(String[] args) {

        int n = 1;
        int num = 200;
        System.out.println(solution(n,num));

    }
}
