import java.io.*;
import java.util.*;

public class Main {
    
    static int[] arr;
    static int N;
    static long K;
    static List<Integer> list;
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
                list.add(i+1);
            }
        if(num == 1){
            K = Long.parseLong(st.nextToken());
            method1();
        }else{
            arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            method2();
        }
    }
    
     private static void method1() {
        K--; 
        for (int i = 0; i < N; i++) {
            int group = N - (i + 1);
            long groupFact = factorial(group); 
            int index = (int) (K / groupFact); 
            System.out.print(list.get(index) + " "); 
            list.remove(index); 
            K %= groupFact; 
        }
    }

    
    private static void method2(){
        long order = 1;
        for(int i=0;i<N;i++){
            int group = N-(i+1);
            long groupfact = factorial(group);
            int index = list.indexOf(arr[i]);
            list.remove(index);
            order += (index * groupfact);
        }
        System.out.println(order);
    }
    
    private static long factorial(int x){
        long fact = 1;
        for(int i=x;i>=1;i--){
            fact *= i;
        }
        return fact;
    }
}
