public class Main {
    public static void main(String[] args) {
        String a = "";
        for(int i = 0; i < 106; i++){
          a += "abcdefghijklmnopqrs";
        }

        String b = "";
        while(a.length() > 1){
            b = "";
            for(int i = 1; i < a.length(); i += 2){
                b += a.charAt(i);
            }

            a = b;
        }

        System.out.println(a);
    }
}