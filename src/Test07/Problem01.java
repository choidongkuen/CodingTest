package Test07;

public class Problem01 {

    public static StringBuilder sb = new StringBuilder();
    public static boolean isPossible(int[][] img, int x, int y, int size){

        int val = img[x][y];

        for (int i = x; i < x + size ; i++) {
            for (int j = y; j <  y + size; j++) {
                if(val != img[i][j])
                    return false; // 추가적인 분할 필요
            }
        }

        return true;
    }

    public static void backtracking(int[][] img, int x, int y, int n){

        if(isPossible(img,x,y,n)){
            sb.append(img[x][y]);
            return;
        }

        int diviedSize = n / 2; // 분할

        sb.append('(');

        backtracking(img,x,y,diviedSize);
        backtracking(img,x,y + diviedSize,diviedSize);
        backtracking(img,x + diviedSize,y,diviedSize);
        backtracking(img,x + diviedSize,y + diviedSize, diviedSize);

        sb.append(')');
    }

    public static void solution(int[][] img){

        if(img == null || img.length == 0)
            return;
        // 예외처리

        int n = img.length; // 전체 이미지의 사이즈
        backtracking(img,0,0,n);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {


        int[][] arr = {{0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}
        };
        solution(arr);

    }
}
