import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();  // 대문자로 통일
        int[] arr = new int[26];  // A-Z까지만

        // 알파벳 개수 세기
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'A']++;
        }

        // 최대값과 해당 인덱스 찾기
        int max = -1;
        char result = '?';
        for(int i = 0; i < 26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                result = (char)(i + 'A');
            } else if(arr[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
