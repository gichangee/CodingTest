import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static String[] alphabet;
    static String[] store;
    static List<String[]> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new String[C];


        store = new String[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken();
        }

        list = new ArrayList<>();

        method(0, 0);

        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    if (o1[i].compareTo(o2[i]) > 0){
                        return 1;
                    }else if(o1[i].compareTo(o2[i]) < 0){
                        return -1;
                    }else{
                        continue;
                    }
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                sb.append(list.get(i)[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());


    }

    private static void method(int depth, int start) {
        if (depth == L) {

            int aeiou = 0;
            int other = 0;

            String[] answer = new String[L];
            for (int i = 0; i < store.length; i++) {
                if(store[i].equals("a") || store[i].equals("e") || store[i].equals("i") || store[i].equals("o") || store[i].equals("u")){
                    aeiou++;
                }else{
                    other++;
                }
                answer[i] = store[i];
            }

            if( aeiou >= 1 && other >=2){
                Arrays.sort(answer);
                list.add(answer);
            }

        } else {
            for (int i = start; i < C; i++) {
                store[depth] = alphabet[i];
                method(depth + 1, i + 1);
            }
        }
    }


}