import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int[] arr = new int[R];

        for (int i = 0; i < R; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;

        int startindex = 0;
        while (count != R) {
            if (list.get(startindex) == arr[count]) {
                count++;
                list.remove(startindex);
            }

            if(count==R){
                break;
            }


            //list.size의 값이 짝수일 때
            if (list.size() % 2 == 0) {
                if (list.indexOf(arr[count]) <= (list.size() / 2) - 1) {
                    while (list.get(startindex) != arr[count]) {
                        list.add(list.remove(startindex));
                        sum++;
                    }
                } else {

                    while (list.get(list.size() - 1) != arr[count]) {
                        list.add(startindex, list.remove(list.size() - 1));
                        sum++;
                    }
                    list.add(startindex, list.remove(list.size() - 1));
                    sum++;

                }
            } else {
                //list.size의 길이가 홀수이고 중간 인덱스 보다 같거나 작을 떼
                if (list.indexOf(arr[count]) <= list.size() / 2) {
                    while (list.get(startindex) != arr[count]) {
                        list.add(list.remove(startindex));
                        sum++;
                    }

                } else {
                    while (list.get(list.size() - 1) != arr[count]) {
                        list.add(startindex, list.remove(list.size() - 1));
                        sum++;
                    }
                    list.add(startindex, list.remove(list.size() - 1));
                    sum++;
                }
            }


        }

        System.out.println(sum);
    }
}