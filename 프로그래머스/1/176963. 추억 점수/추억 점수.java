import java.util.*;
class Solution {
public  int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        List<String> strList = new ArrayList<>(Arrays.asList(name));

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if(strList.contains(photo[i][j])){
                     answer[i]+= yearning[strList.indexOf(photo[i][j])];
                }
            }
        }

        return answer;
    }
}