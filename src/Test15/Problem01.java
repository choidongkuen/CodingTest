package Test15;

public class Problem01 {


    public static void main(String[] args) {
        String a = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=813269163e31fcdb7e20a4cb0d5fd313";
        String b = "https://api.openweathermap.org/data/2.5/weather?q=seoul@appid=813269163e31fcdb7e20a4cb0d5fd313";

        for (int i = 0; i < a.length() ; i++) {
            if(a.charAt(i) != b.charAt(i)){
                System.out.println(a.charAt(i) +" "+ i);
            }
        }
    }
}
