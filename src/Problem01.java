import java.util.Arrays;

public class Problem01 {


    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{666,66,66}};

        System.out.println(Arrays.stream(arr[2]).max().getAsInt());
    }
}
