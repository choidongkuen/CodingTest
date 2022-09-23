import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1,26,17,25,99,44,303};

/*
        System.out.println("== 오름 차순 정렬 ==");
        Arrays.sort(arr); // 오름차순 정렬
        System.out.println("Sorted arr[] : " + Arrays.toString(arr));

 */
        StringBuilder sb = new StringBuilder();

        System.out.println("== 내림 차순 정렬 == ");
        Arrays.stream(arr).boxed().sorted((x,y) -> {
            int a = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
            int b = Integer.parseInt(String.valueOf(y) + String.valueOf(y));
            return a-b;}).forEach(sb::append);
    }
}