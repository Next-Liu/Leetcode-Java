package traceback;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_93 {
    List<String> res = new ArrayList<>();

    public boolean check(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
    // pointNum代表.的数量
    public void traceback(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {   // 判断最后一个部分
            if (check(s, startIndex, s.length() - 1)) {
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (check(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                traceback(s, i + 2, pointNum);//i+2是因为加了一个点，所以要跳过点
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        traceback(s, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String length = sc.nextLine();
        String data = sc.nextLine();
        String[] arr = data.split(" ");
        System.out.println(length);
        for (String s:arr){
            System.out.println(s);
        }
    }
}
