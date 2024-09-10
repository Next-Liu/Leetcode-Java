import java.util.Scanner;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class MT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k, sum = 0;
        n = scanner.nextInt();
        k = scanner.nextInt();
        String s = scanner.next();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'M' && s.charAt(i) != 'T') {
                count++;
            }
        }
        sum = n - count + Math.min(count, k);
        System.out.println(sum);
    }
}
