public class Main {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 1900; i <= 9999; i++) {
            String string = i + "";
            boolean flag = false;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == '2') {
                    flag = true;
                }
            }
            if (i % 4 == 0 && i % 100 !=0 || i % 400 == 0) {
                if (flag) {
                    res += 366;
                }else {
                    res += 12 * 10 + 29 + 31;
                }
            }else {
                if (flag) {
                    res += 365;
                }else {
                    res += 12 * 10 + 28 + 31;
                }
            }
        }
        System.out.println(res);
    }
}