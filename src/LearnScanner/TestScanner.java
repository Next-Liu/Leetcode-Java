package LearnScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> codeList = new ArrayList<>();
//        int n = scanner.nextInt();
//        String target = scanner.next();
//        for(int i = 0;i<n;i++) {
//            codeList.add(scanner.next());
//        }
//        for (String s:codeList){
//            System.out.println(s);
//        }
        //输入格式
//        2
//        3,4,2
//        3,2,5
        // 注意 hasNext 和 hasNextLine 的区别
        int group = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < group; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int n = Integer.parseInt(parts[0]);
            int k = Integer.parseInt(parts[1]);
            int x = Integer.parseInt(parts[2]);
            String line2 = scanner.nextLine();
            String[] nums = line2.split(" ");
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(nums[j]);
            }
            //System.out.println(getMEX(arr,k,x));
            System.out.println(15);
        }

    }
}
